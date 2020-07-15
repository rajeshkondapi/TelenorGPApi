package TelenorGp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class Test1 {
	List<String> activatecharge = new ArrayList<String>();
	
	
	@Test
	public List<String> db() throws Exception {
		
	String dbUrl = "jdbc:mysql://10.21.11.55:9000/gateway_logs_21";
	String username = "lokesh.s";
	String password = "2g!VC8FfORaJTU";	
	String referenceCode="5502111531565002222594004";
	
	Thread.sleep(5000);
	Connection con = null;
	//propertyelements();
    try {
    	Class.forName("com.mysql.jdbc.Driver");
    	con = DriverManager.getConnection(dbUrl, username, password);
        Statement stmt = con.createStatement();
        HSSFWorkbook report_an_issue_wb = Exceel();
		HSSFSheet report_an_issue_Sheet = report_an_issue_wb.getSheet("DPDP_DB");
		report_an_issue_Sheet.getPhysicalNumberOfRows();
        //The query can be update query or can be select query
		
		
		
		for (int i=1; i<report_an_issue_Sheet.getPhysicalNumberOfRows(); i++)
		{
			String query = report_an_issue_Sheet.getRow(i).getCell(1).getStringCellValue();
			//String query = "SELECT * FROM imidigitaltrans_logs.gw_api_trans_log WHERE gtrid='"+referenceCode+"'" ;
			System.out.println("Query ==>"+query + "'" +referenceCode+"'");
		
       // String query = "select * from emp";
        boolean status = stmt.execute(query  + "'" +referenceCode+"'");
        if(status){
            //query is a select query. msisdn,action,requested_charge_code,requested_price,description,trans_type 
            ResultSet rs = stmt.getResultSet();        
            ResultSetMetaData metadata = rs.getMetaData();
            System.out.println("metadata ==> "+metadata);
            int columnCount = metadata.getColumnCount();
			while (rs.next()) {
           
            for (int j=1; j<=columnCount; j++) 
            {
            	
                String columnName = metadata.getColumnName(j);
                System.out.println(columnName);
                System.out.println(rs.getString(j));
            }
               
            rs.close();
                
            }
        } 
         else {
            //query can be update or any query apart from select query
            int count = stmt.getUpdateCount();
            System.out.println("Total records updated: "+count);
        }
    }
    }catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally{
        try{
            if(con != null) con.close();
        } catch (Exception ex){}
    }

    return activatecharge;
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

	Properties obj = new Properties();

	public Properties propertyelements() throws IOException {
		
		FileInputStream objfile = new FileInputStream(
		System.getProperty("user.dir") + "\\DPDP.properties");
		obj.load(objfile);
		return obj;
	}
	
	public void mm() {
		JSONObject jo = new JSONObject(); 
		jo.put("msis","9246543225");
		System.out.println("jo = "+jo.get("msis"));
		
	
	
	}
	
		
}


