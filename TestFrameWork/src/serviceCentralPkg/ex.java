package serviceCentralPkg;



import java.sql.SQLException;
import java.util.ArrayList;
import org.testng.annotations.Test;
import beanRelated.ServicecentralBean;
import sqlpackage.sqlconnector;

public class ex extends sqlconnector  {
	//String querry;
	@Test
	
	public void sq() throws ClassNotFoundException, SQLException {
		
		
		sqlconnector sqlcon1= new sqlconnector();
		ArrayList<ServicecentralBean> al=sqlcon1.ss();
		//int[] a= new int[];
		System.out.println("Size of sql data is="+al.size());
		
		for(int i=0;i<=1;i++){  
		int id1 = al.get(i).getId();
		System.out.println(id1);
		
		int id2 = al.get(i).getId();
		System.out.println(id2);
		
		/*int id3 = al.get(0).getId();
		System.out.println(id3);
		int id4 = al.get(0).getId();
		System.out.println(id4);*/
		}
		
		   
		    String dp1=al.get(0).getProjectsdropdown();
		    System.out.println(dp1);
		    
		    String dp2=al.get(0).getCategorydropdown();
		    System.out.println(dp2);
		    
		    String dp3=al.get(0).getTaskdropdown();
		    System.out.println(dp3);	    
		    
		  	
		   
		    
		
	}		
	
}

