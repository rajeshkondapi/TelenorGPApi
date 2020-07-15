package DatabaseConnections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.testng.annotations.Test;

import RestAPI.RestAPI.WheaterGetRequest;


public class Dbconn extends WheaterGetRequest {

	WheaterGetRequest wr = new WheaterGetRequest();
	
	String query1;
	ResultSet rs = null;

	@Test 
	public void sqlconnection() throws Exception{

		int lport=8080;
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/seleniumdb";

		//Database Username		
		String username = "root";	

		//Database Password		
		String password = ""; 	

		//Load mysql jdbc driver		
		Class.forName("com.mysql.jdbc.Driver");

		//Create Connection to DB		
		Connection con = DriverManager.getConnection(dbUrl,username,password);


		//rs = con.getMetaData().getCatalogs();

		//System.out.println("Result set is = "+rs);

		if(con != null){

			System.out.println("checking if db exists");

			rs = con.getMetaData().getCatalogs();

			//System.out.println(rs);

			while(rs.next()){
				String catalogs = rs.getString(1);

				String tablename = "seleniumdb";

				if(tablename.equals(catalogs)){

					System.out.println("the database "+tablename+" exists");

				}
			}
		}
		else{

			System.out.println("unable to create database connection");

		}

		Statement stmt = con.createStatement();

		java.sql.DatabaseMetaData dbm = con.getMetaData();

		rs = dbm.getTables(null, null, "seltable2", null);

		//wr.allstates();
		
	}
	
	
	public void s() throws Exception {
		
		int lport=8080;
		//Connection URL Syntax: "jdbc:mysql://ipaddress:portnumber/db_name"
		String dbUrl = "jdbc:mysql://localhost:3306/seleniumdb";

		//Database Username		
		String username = "root";	

		//Database Password		
		String password = ""; 	

		//Load mysql jdbc driver		
		Class.forName("com.mysql.jdbc.Driver");

		//Create Connection to DB		
		Connection con = DriverManager.getConnection(dbUrl,username,password);
		
		Statement stmt = con.createStatement();
		
		java.sql.DatabaseMetaData dbm = con.getMetaData();

		rs = dbm.getTables(null, null, "seltable2", null);
		
		lvdb = wr.lvdb;

		int x1 =  lvdb.getId();		
		
		String x2 =	lvdb.getCountry();
			
		String x3 = lvdb.getNam();
		
		String x4 = lvdb.getAbbr();		
		
		String x5 = lvdb.getAre();
		
		String x6 = lvdb.getLargest_city();
		
		String x7 = lvdb.getCapital();	
		
		//System.out.println("Substring is = "+x2.substring(0, 2));
		
		
		
		if (rs.next()) {

			//System.out.println("seltable2 Table Already Exists !");
			
			if(x2!= null){
			
			String query2 = ("INSERT IGNORE INTO seltable2 (id, country , nam , abbr , are , largest_city , capital) VALUE ("+x1+",'"+x2+"','"+x3+"','"+x4+"','"+x5+"', '"+x6+"','"+x7+"')");
			
			//System.out.println("Query is = "+query2);
			
			stmt.execute(query2);

		}
		}
		else{

			query1 = "CREATE TABLE IF NOT EXISTS seltable2 (id INT(10), country VARCHAR(50), nam VARCHAR(50), abbr VARCHAR(50), are VARCHAR(50), largest_city VARCHAR(50), capital VARCHAR(50));";

			String query2 = ("INSERT IGNORE INTO seltable2 (id, country , nam , abbr , are , largest_city , capital) VALUE ("+x1+",'"+x2+"','"+x3+"','"+x4+"','"+x5+"', '"+x6+"','"+x7+"')");
			//Create Statement Object		


			// Execute the SQL Query. Store results in ResultSet		
			stmt.execute(query1);
			
			stmt.execute(query2);




		}

	}
}
