package TelenorDTAC;


import java.io.FileInputStream;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class APIDtac {

	@Test(groups= {"DC"})
	public void deactivatesubscriber () throws Exception {

		JSONObject jo1 = new JSONObject();		

		Map<String, Object> m1 = new LinkedHashMap<String, Object>();

		String path = "C:\\Users\\rajesh.k\\Desktop\\dtacautomationapi.xls";
		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = new HSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);

		int lastRow = sheet.getLastRowNum();

		//for(int i=0; i<=lastRow; i++) {
			Row row = sheet.getRow(1);
			//1st Cell as Value
			Cell valueCell = row.getCell(1);
			for (int j=0; j<=lastRow; j++) {
			//0th Cell as Key
			Cell keyCell = row.getCell(j);
			
			
			
			String value = valueCell.getStringCellValue().trim();
			String key = keyCell.getStringCellValue().trim();

			System.out.println("Key is  = "+key);
			System.out.println("Value is = "+value);
			}
			/*m1.put("accesskey", );
			m1.put("endUserId", "8801756393310");
			m1.put("accesschannel", "CRM");		 
			m1.put("referenceCode", "{{$randomInt}}");

			jo1.put("accesInfo", m1);

			//m1 = new LinkedHashMap<String, Object>();
			m1.put("serviceIdentifier", "SUB00010201205");
			m1.put("productIdentifier", "1453");
			m1.put("subscriptionId", "5512111501554367137573298");

			jo1.put("subscriptionInfo", m1);
			//responseGenerator.setJSONData(data.toMap());

			System.out.println("deactivate format = " +jo1.toString());


			Response respdeactivate = given().
					when().
					contentType(ContentType.JSON).
					body(jo1.toString()).
					post("http://10.21.11.50:9091/digital5crm/subscription/v5.0/deactivate");
			System.out.println("Deactivate Response : " +respdeactivate.asString());

			assertEquals(200, respdeactivate.getStatusCode());
			System.out.println("statuscode1 = "+respdeactivate.getStatusCode());
			System.out.println("statuscode2= "+respdeactivate.statusCode());
			System.out.println("Deactivate pass");*/
		}

	}
//}
