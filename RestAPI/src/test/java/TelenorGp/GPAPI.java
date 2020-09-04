package TelenorGp;

import static com.jayway.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.MessagingException;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.itextpdf.text.DocumentException;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class GPAPI extends EmailReport {

	static SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
	
	@Test(priority=2,enabled=false)
	public void mongoverify() {
		logger = extent.startTest("MONGO", "MONGO Check");
		mongoDB("8802222200011","profilemanager","userinfo");
		
	}

	@Test(priority=0,enabled=true)
	public void apicall() throws Exception {

		propertyelements();
		List<String> activsub = new ArrayList<>();
		HSSFWorkbook apimethods_wb = Exceel();
		HSSFSheet apisheet = apimethods_wb.getSheet("ApiMethods");

		for (int i = 1; i < apisheet.getPhysicalNumberOfRows(); i++) {
			String apiMethod = apisheet.getRow(i).getCell(0).getStringCellValue().trim();
			System.out.println("apimethds ==" + apiMethod);
			String Req_body = apisheet.getRow(i).getCell(1).getStringCellValue().trim();

			System.out.println(Req_body);
			Gson gson = new Gson();
			JsonObject jsonObject = gson.fromJson(Req_body, JsonObject.class);

			// Unsubscription body update
// latest code
			
			if (apiMethod.equalsIgnoreCase("Unsubscribe") || apiMethod.equalsIgnoreCase("De-activate Subscriber") || apiMethod.equalsIgnoreCase("De-activate Subscriber1")) {

				jsonObject.getAsJsonObject("subscriptionInfo").remove("subscriptionId");
				//System.out.println("SubscrptionId = " + activsub.get(0));
				jsonObject.getAsJsonObject("subscriptionInfo").addProperty("subscriptionId",
						(activsub != null && !activsub.isEmpty()) ? activsub.get(0) : "");
				
				
			}

			// DC Charge OTP body Update

			if (apiMethod.equalsIgnoreCase("DC_chargeOTP") || apiMethod.equalsIgnoreCase("Part_ChargeOTP")) {

				jsonObject.getAsJsonObject("accesInfo").remove("transactionPIN");
				jsonObject.getAsJsonObject("accesInfo").remove("otpTransactionId");
				//System.out.println("DC Push GTRID = " + activsub.get(0));
				jsonObject.getAsJsonObject("accesInfo").addProperty("otpTransactionId",
						(activsub != null && !activsub.isEmpty()) ? activsub.get(0) : "");
				System.out.println("DC OTP = " + otpget.get(0));
				jsonObject.getAsJsonObject("accesInfo").addProperty("transactionPIN",
						(otpget != null && !otpget.isEmpty()) ? otpget.get(0) : "");

			}

			if (jsonObject.getAsJsonObject("accesInfo").get("referenceCode") != null) {

				System.out.println("Reference ==" + jsonObject.getAsJsonObject("accesInfo").get("referenceCode"));

				String Randint11 = jsonObject.getAsJsonObject("accesInfo").remove("referenceCode").toString();

				Random rnd = new Random();
				int n = 1000000000 + rnd.nextInt(900000000);
				int y = 10000 + rnd.nextInt(90000);

				String up = n + "" + n + "" + y;
				System.out.println("RandInt ==> " + n + "" + n + "" + y);
				jsonObject.remove(Randint11);
				jsonObject.getAsJsonObject("accesInfo").addProperty("referenceCode", up);

				System.out.println("after change == " + jsonObject);

				String url = apisheet.getRow(i).getCell(2).getStringCellValue();
				System.out.println(url);
				Response respactivate = given().when().contentType(ContentType.JSON).body(jsonObject.toString())
						.post(url);
				// given().when().contentType(ContentType.JSON).body(Req_body).get(url);
				System.out.println("respactivate Response : " + respactivate.asString());

				System.out.println("Response Body == " + respactivate.body().asString());
				System.out.println("Response Header == " + respactivate.getHeaders());

				String StatusCode = respactivate.body().jsonPath().get("statusInfo.statusCode");

				logger = extent.startTest(apiMethod, "Description to DPDP GP API Methods");

				if (StatusCode.equalsIgnoreCase("200")) {

					logger.log(LogStatus.PASS, "Request URL == " + url);
					logger.log(LogStatus.PASS, "Response Header == " + respactivate.getHeaders());
					logger.log(LogStatus.PASS, "Request Body == " + jsonObject.toString());

					// System. out. print(System.lineSeparator());
					logger.log(LogStatus.PASS, "API Status Code for " + apiMethod + " == " + StatusCode);
					// System. out. print(System.lineSeparator());
					logger.log(LogStatus.PASS, "API Response for " + apiMethod + " ==" + respactivate.asString());
					if(apiMethod.equalsIgnoreCase("De-activate Subscriber") || apiMethod.equalsIgnoreCase("Activate Subscriber") || apiMethod.equalsIgnoreCase("Register Subscriber"))
					{
						mongoDB("8801307257910","profilemanager","userinfo");
					}
					
					// gtridsheet();

				} else {
					logger.log(LogStatus.PASS, "Request URL == " + url);
					logger.log(LogStatus.PASS, "Response Header == " + respactivate.getHeaders());
					logger.log(LogStatus.PASS, "Request Body == " + jsonObject.toString());
					// logger.log(LogStatus.FAIL, "API StatusCode for " + apiMethod + " ==" +
					// StatusCode);
					logger.log(LogStatus.FAIL, "API Response for " + apiMethod + " ==" + respactivate.asString());
					logger.log(LogStatus.FAIL,
							"Expected StatusCode is 200 for " + apiMethod + " but found to be ==" + StatusCode);				

				}

				String serverReferenceCode = respactivate.body().jsonPath().get("statusInfo.serverReferenceCode");
				System.out.println("serverReferenceCode ==> " + serverReferenceCode);
				// apisheet.getRow(i).createCell(3).setCellValue(serverReferenceCode);
				if (serverReferenceCode != null && !serverReferenceCode.isEmpty()
						&& !serverReferenceCode.trim().equals("null")) {

					apisheet.getRow(i).createCell(3).setCellValue(serverReferenceCode);
				} else {
					System.out.println("serverbatchReferenceCode else");
					String serverbatchReferenceCode = respactivate.body().jsonPath()
							.get("statusInfo.serverBatchReferenceCode");
					System.out.println("serverbatchReferenceCode =" + serverbatchReferenceCode);
					apisheet.getRow(i).createCell(3).setCellValue(serverbatchReferenceCode);
				}

				if (apiMethod.equalsIgnoreCase("Activate Subscriber") || apiMethod.equalsIgnoreCase("Activate Subscriber1")) {
					if (StatusCode.equals("200")) {
						String ActivateSubscriptionId = respactivate.body().jsonPath()
								.get("subscriptionInfo.subscriptionId");
						System.out.println(ActivateSubscriptionId);
						if (ActivateSubscriptionId != null && !ActivateSubscriptionId.isEmpty()) {
							activsub.add(ActivateSubscriptionId);
							System.out.println("subpinid = " + activsub.get(0));
						} else {
							System.out.println("SubscrptionId couldn't find");
							logger.log(LogStatus.INFO, "SubscrptionId couldn't find");
						}
					} else {
						System.out.println("SubscrptionId couldn't find");
						logger.log(LogStatus.INFO, "SubscrptionId couldn't find");
					}
				}

				ExceelOutput(apimethods_wb);

				List<Map<String, Object>> completeDataAllAPIs = new ArrayList<>();
				List<String> queries = new ArrayList<>();
				if (apiMethod.equalsIgnoreCase("DC_PustOTP") || apiMethod.equalsIgnoreCase("Part_pushotp")) {
					activsub.clear();
					queries.add("SELECT otp  FROM gateway_config_21.chargeotp WHERE otp_transid=");
					// GTRID cell value

					String Pushgtr = apisheet.getRow(i).getCell(3).getStringCellValue().trim();
					System.out.println("PushGtr = " + Pushgtr);
					activsub.add(Pushgtr);
					Map<String, Object> allTablesData = db(apiMethod, Pushgtr, queries);

					completeDataAllAPIs.add(allTablesData);
					System.out.println("Complete::: " + completeDataAllAPIs);

				}

				if ((apiMethod.equalsIgnoreCase("pushalertsms") && StatusCode.equalsIgnoreCase("200")) || (apiMethod.equalsIgnoreCase("pushalertsms without charge") && StatusCode.equalsIgnoreCase("200"))) {
					Thread.sleep(3000);
					activsub.clear();
					queries.clear();
					queries.add("SELECT tid FROM imidigital_sub_alerts.usm_push_service_alert_process WHERE gtrid=");
					String smsgtrid1 = apisheet.getRow(i).getCell(3).getStringCellValue().trim();
					System.out.println("SmsGtrid = " + smsgtrid1);
					activsub.add(smsgtrid1);
					db(apiMethod, smsgtrid1, queries);
					Thread.sleep(3000);
					activsub.clear();
					queries.clear();			
					otpget.get(0);
					queries.add("SELECT new_gtrid FROM imidigital_sub_alerts.usm_alert_data_process_trans6 WHERE tid ='"
							+ otpget.get(0) + "'AND gtrid = ");

					Map<String, Object> allTablesData2 = db(apiMethod, smsgtrid1, queries);

					System.out.println("PushAlert New GTRID =" + allTablesData2);
					
					String new_gtrid1 = allTablesData2.containsKey("pushalertsms_1")? ((Map<String, String>) allTablesData2.get("pushalertsms_1")).get("new_gtrid"): "";
					System.out.println("new_gtrid :" + new_gtrid1);
					if(new_gtrid1!=null) {
						apisheet.getRow(i).createCell(4).setCellValue(new_gtrid1);
						ExceelOutput(apimethods_wb);						
					}else {
						System.out.println("Could not generate new gtrid for :"+apiMethod);
						logger.log(LogStatus.FAIL, "Could not generate new gtrid for "+apiMethod);
					}
					
					
					} 
				
				if ((apiMethod.equalsIgnoreCase("groupsms") && StatusCode.equalsIgnoreCase("200")) || (apiMethod.equalsIgnoreCase("groupsms without charge") && StatusCode.equalsIgnoreCase("200"))) {
					Thread.sleep(3000);
					activsub.clear();
					queries.clear();
					queries.add("SELECT new_gtrid FROM imidigital_sub_alerts.usm_alert_data_process_trans6 WHERE gtrid=");
					String smsgtrid2 = apisheet.getRow(i).getCell(3).getStringCellValue().trim();
					System.out.println("SmsGtrid = " + smsgtrid2);
					activsub.add(smsgtrid2);
					Map<String, Object> allTablesData3 =db(apiMethod, smsgtrid2, queries);	
					
					System.out.println("Group Sms New GTRID =" + allTablesData3);
					
					String new_gtrid2 = allTablesData3.containsKey("groupsms_1")? ((Map<String, String>) allTablesData3.get("groupsms_1")).get("new_gtrid")	: "";
					System.out.println("new_gtrid :" + new_gtrid2);
					if(new_gtrid2!=null) {
						apisheet.getRow(i).createCell(4).setCellValue(new_gtrid2);
						ExceelOutput(apimethods_wb);						
					}else {
						System.out.println("Could not generate new gtrid for :"+apiMethod);
						logger.log(LogStatus.FAIL, "Could not generate new gtrid for "+apiMethod);
					}
					
				
					}
				
				
			} else {
				System.out.println("Reference ==" + jsonObject.getAsJsonObject("charge").get("referenceCode"));

				String Randint = jsonObject.getAsJsonObject("charge").get("referenceCode").toString();

				String Randint11 = jsonObject.getAsJsonObject("charge").remove("referenceCode").toString();

				Random rnd = new Random();
				int n = 1000000000 + rnd.nextInt(900000000);
				int y = 10000 + rnd.nextInt(90000);

				String up = n + "" + n + "" + y;
				System.out.println("RandInt ==> " + n + "" + n + "" + y);
				// JsonObject jsonObject2 = gson.fromJson(up, JsonObject.class);
				jsonObject.remove(Randint11);
				jsonObject.getAsJsonObject("charge").addProperty("referenceCode", up);

				System.out.println("after change == " + jsonObject);

				String url = apisheet.getRow(i).getCell(2).getStringCellValue();
				System.out.println(url);
				Response respactivate = given().when().contentType(ContentType.JSON).body(jsonObject.toString())
						.post(url);
	
				System.out.println("respactivate Response : " + respactivate.asString());

				System.out.println("Response Body == " + respactivate.body().asString());
				System.out.println("Response Header == " + respactivate.getHeaders());

				String StatusCode = respactivate.body().jsonPath().get("statusInfo.statusCode");

				respactivate.getStatusLine();

				logger = extent.startTest(apiMethod, "Description to DPDP GP API Methods");

				if (StatusCode.equalsIgnoreCase("200")) {

					logger.log(LogStatus.PASS, "Request URL == " + url);
					logger.log(LogStatus.PASS, "Response Header == " + respactivate.getHeaders());
					logger.log(LogStatus.PASS, "Request Body == " + jsonObject.toString());

					// System. out. print(System.lineSeparator());
					logger.log(LogStatus.PASS, "API Status Code for " + apiMethod + " == " + StatusCode);
					// System. out. print(System.lineSeparator());
					logger.log(LogStatus.PASS, "API Response for " + apiMethod + " ==" + respactivate.asString());

					// gtridsheet();

				} else {
					logger.log(LogStatus.PASS, "Request URL == " + url);
					logger.log(LogStatus.PASS, "Response Header == " + respactivate.getHeaders());
					logger.log(LogStatus.PASS, "Request Body == " + jsonObject.toString());
					// logger.log(LogStatus.FAIL, "API StatusCode for " + apiMethod + " ==" +
					// StatusCode);
					logger.log(LogStatus.FAIL, "API Response for " + apiMethod + " ==" + respactivate.asString());
					logger.log(LogStatus.FAIL,
							"Expected StatusCode is 200 for " + apiMethod + " but found to be ==" + StatusCode);

				}

				String serverReferenceCode = respactivate.body().jsonPath().get("statusInfo.serverReferenceCode");
				System.out.println("serverReferenceCode ==> " + serverReferenceCode);

				if (serverReferenceCode != null && !serverReferenceCode.isEmpty()
						&& !serverReferenceCode.trim().equals("null")) {

					apisheet.getRow(i).createCell(3).setCellValue(serverReferenceCode);
				} else {
					System.out.println("serverbatchReferenceCode else");
					String serverbatchReferenceCode = respactivate.body().jsonPath()
							.get("statusInfo.serverBatchReferenceCode");
					System.out.println("serverbatchReferenceCode =" + serverbatchReferenceCode);
					apisheet.getRow(i).createCell(3).setCellValue(serverbatchReferenceCode);

				}

				ExceelOutput(apimethods_wb);
			}
		}
	}

	@Test(priority = 1, enabled = true)
	public void gtridsheet() throws Exception {
		FetchOtp("DPDP_DB");
	}

	public void FetchOtp(String sheetname) throws Exception {

		HSSFWorkbook apimethods_wb = Exceel();
		HSSFSheet apisheet = apimethods_wb.getSheet("ApiMethods");
		// List<Map<String, Object>> completeDataAllAPIs = new ArrayList<>();
		HSSFSheet dbqueries = apimethods_wb.getSheet(sheetname);
		
		
		
		for (int i = 1; i < apisheet.getPhysicalNumberOfRows(); i++) {
			String apiMethod = apisheet.getRow(i).getCell(0).getStringCellValue();

			logger = extent.startTest(apiMethod + " DB Details", "DPDP-GP-DB Details");
			
			

			String gtrid = apisheet.getRow(i).getCell(3).getStringCellValue();
			List<String> queries = new ArrayList<>();
			for (int k = 1; k < dbqueries.getPhysicalNumberOfRows(); k++) {
				HSSFRichTextString dbethd = dbqueries.getRow(k).getCell(0).getRichStringCellValue();
				if (apiMethod.equalsIgnoreCase(dbethd.getString())) {
				//	String query = dbqueries.getRow(k).getCell(2).getStringCellValue();
					String query = dbqueries.getRow(k).getCell(2).toString();
					queries.add(query);
				}
			}
			if (apiMethod.equalsIgnoreCase("pushalertsms") || apiMethod.equalsIgnoreCase("groupsms") || apiMethod.equalsIgnoreCase("groupsms without charge") || apiMethod.equalsIgnoreCase("pushalertsms without charge")) {
				// logger = extent.startTest(apiMethod+" DB Details", "DPDP-GP-DB Details");

				//String log = dbqueries.getRow(i).getCell(1).getStringCellValue();
				System.out.println(apiMethod);
				//System.out.println("log : " + log);
				for (int j = 0; j < queries.size(); j++) {
					System.out.println("J loop :"+j+ ":"  +queries.get(j));
					if (queries.get(j).contains("gw_api_trans_log")) {
						System.out.println("gw_api_trans_log");
						db(apiMethod, gtrid, queries.get(j));
					} else {						
						String ngtrid = apisheet.getRow(i).getCell(4) !=null ?  apisheet.getRow(i).getCell(4).getStringCellValue().trim() : "No New GTRID";
						System.out.println("API: " + apiMethod + " Queries: " + queries);
						db(apiMethod, ngtrid, queries.get(j));
						}
					}
			

			} else {

				System.out.println("API: " + apiMethod + " Queries: " + queries);
				db(apiMethod, gtrid, queries);
				// completeDataAllAPIs.add(allTablesData);
				// System.out.println("Complete::: " + completeDataAllAPIs);
			}
		}

	}

	Map<String, Object> apiWiseDataIndividual = new HashMap<String, Object>();

	public Map<String, Object> db(String apimethd, String gtrid, List<String> queries) throws Exception {
		propertyelements();

		try {
			Thread.sleep(15000);

			int i = 1;
			for (String query : queries) {
				System.out.println("Query ==>" + query + "'" + gtrid + "'");
				Map<String, Object> dt = getLogsFromDB(query, gtrid, apimethd);
				apiWiseDataIndividual.put(apimethd + "_" + i, dt);
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return apiWiseDataIndividual;

	}

	public Map<String, Object> db(String apimethd, String gtrid, String query) throws Exception {
		propertyelements();

		try {
			Thread.sleep(15000);

			int i = 1;
			System.out.println("Query ==>" + query + "'" + gtrid + "'");
			Map<String, Object> dt = getLogsFromDB(query, gtrid, apimethd);
			apiWiseDataIndividual.put(apimethd + "_" + i, dt);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return apiWiseDataIndividual;

	}

	String Exceel_Path;

	public HSSFWorkbook Exceel() throws Exception {

		Exceel_Path = obj.getProperty("Exceel_Physical_Path");
		File file = new File(Exceel_Path);
		FileInputStream fis = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);

		return workbook;
	}

	public void ExceelOutput(HSSFWorkbook workbook) throws Exception {
		Exceel_Path = obj.getProperty("Exceel_Physical_Path");
		FileOutputStream fos = new FileOutputStream(Exceel_Path);
		workbook.write(fos);
	}

	public static void WriteToFile(String fileContent, String fileName) throws IOException {

		String projectPath = System.getProperty("user.dir");
		String tempFile = projectPath + File.separator + fileName;
		File file = new File(tempFile);
		// if file does exists, then delete and create a new file
		if (file.exists()) {
			try {
				File newFileName = new File(projectPath + File.separator + "backup_" + fileName);
				file.renameTo(newFileName);
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();

			}
		}
		// write to file with OutputStreamWriter
		OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
		Writer writer = new OutputStreamWriter(outputStream);
		writer.write(fileContent);
		writer.close();

	}

	public static String getDate() {

		return sdf.format(new java.util.Date());
	}

	@BeforeTest
	public void reports() throws MessagingException, DocumentException, Exception {

		String now = getDate();
		extent = new ExtentReports(System.getProperty("user.dir") + "/test-output/Report.html", true);
		extent.addSystemInfo("Host Name", "DPDP GP API's").addSystemInfo("Environment", "API Automation - Rest Assured")
				.addSystemInfo("User Name", "DPDP");
		extent.loadConfig(new File(System.getProperty("user.dir") + "\\extent-config.xml"));
	}

	@AfterTest(timeOut = 5000)
	public void tearDown() throws MessagingException, DocumentException, Exception {	
		extent.flush();
		

	}

}
