package TelenorGp;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DbConn extends MongoTest {

	ExtentReports extent;
	ExtentTest logger;

	Properties obj = new Properties();
	
	public Properties propertyelements() throws IOException {

		FileInputStream objfile = new FileInputStream(System.getProperty("user.dir") + "\\DPDP.properties");
		obj.load(objfile);
		return obj;
	}

	public String mongoDB(String id, String dbname, String collectionname,String apiMethod) throws IOException {
		propertyelements();
		try {	
			String dbURI = obj.getProperty("mongourl");
			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));
			DB db = mongoClient.getDB(dbname);
			DBCollection collection = db.getCollection(collectionname);
			BasicDBObject query1 = new BasicDBObject();
			query1.put("_id", id);
			BasicDBObject outer = null;
			List<BasicDBObject> objelement = new ArrayList<BasicDBObject>();
			if(apiMethod.equals("Register Subscriber")) {
				objelement.add(new BasicDBObject("cCode", obj.getProperty("cCode")).append("state", 0));				
			} else if(apiMethod.equals("Activate Subscriber")) {
				objelement.add(new BasicDBObject("cCode", obj.getProperty("cCode")).append("state", 1));
			} else if(apiMethod.equals("De-activate Subscriber")) {
				objelement.add(new BasicDBObject("cCode", obj.getProperty("cCode")).append("state", 11));				
			}
			query1.append("subscriptions", new BasicDBObject("$elemMatch", objelement));
			System.out.println(query1.toString().replace("[", "").replace("]", ""));
			String js = query1.toString().replace("[", "").replace("]", "");
			
			DBCursor cursor = collection.find(new BasicDBObject().parse(js));
			
			 if(cursor.hasNext()) {
				 while (cursor.hasNext()) {
						logger.log(LogStatus.PASS, "Mongo Collection for " +apiMethod+ "  :  " + cursor.next());				
				 	}
			}  else {
				 logger.log(LogStatus.FAIL, "No Records Found for "+apiMethod);
				 logger.log(LogStatus.FAIL, "Mongo Query  "+query1);				 
				 System.out.println("No");
				 }
			mongoClient.close();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return "Unable to get Details !";

	}

	

	List<String> otpget = new ArrayList<>();

	public Map<String, Object> getLogsFromDB(String query, String gtrid, String apiMethod) throws Exception {

		propertyelements();

		otpget.clear();

		String dbUrl = obj.getProperty("dbUrl");
		String username = obj.getProperty("username");
		String password = obj.getProperty("password");

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		Map<String, Object> mp = new HashMap<String, Object>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, username, password);
			stmt = con.createStatement();
			if (query.contains("SELECT new_gtrid")) {
				Thread.sleep(25000);
				rs = stmt.executeQuery(query + "'" + gtrid + "'");
			} else {

				rs = stmt.executeQuery(query + "'" + gtrid + "'");
			}

			while (rs.next()) {
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {

					mp.put(rs.getMetaData().getColumnName(i), rs.getString(rs.getMetaData().getColumnName(i)));

				}

			}

			System.out.println("Data == " + mp);

			if (mp.containsKey("otp")) {

				otpget.add(mp.get("otp").toString());

			}
			if (mp.containsKey("tid")) {

				otpget.add(mp.get("tid").toString());
				System.out.println("tid =" + otpget);

			}

			if (mp.isEmpty()) {

				// logger.log(LogStatus.FAIL, "Api Failed for ==>"+apiMethod);

				logger.log(LogStatus.FAIL,
						"Failed to fetch data for =  " + apiMethod + " : " + query + "'" + gtrid + "'");
			}
			// logger.log(LogStatus.PASS, "Test Case (LoginPage) Status is passed");
			else {

				logger.log(LogStatus.PASS,
						"Data is Available for  " + apiMethod + " : " + query + "'" + gtrid + "'" + " : " + mp);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Exception:: " + ex);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (stmt != null) {
					stmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return mp;

	}

}
