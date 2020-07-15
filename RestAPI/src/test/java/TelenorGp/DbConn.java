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
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
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

	public String mongoDB(String id, String dbname, String collectionname) {

		try {
			
			

			String dbURI = "mongodb://AppUser:atLQL1KX1P5w@10.21.11.52:9075/admin";
			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));

			DB db = mongoClient.getDB(dbname);
			DBCollection collection = db.getCollection(collectionname);

			BasicDBObject query = new BasicDBObject();
			query.put("_id", id);

			System.out.println(query);

			/* Step 5 : Get all documents */
			DBCursor cursor = collection.find(query);

			// if(cursor.hasNext()) {
			/* Step 6 : Print all documents */
			while (cursor.hasNext()) {
				// System.out.println(cursor.next());
				logger.log(LogStatus.PASS, "Mongo Collection :  " + cursor.next());
				// }
			} // else {
				// logger.log(LogStatus.FAIL, "No Records Found ");
				// }

			// logger.log(LogStatus.PASS, "Mongo Details : "+jo);

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
