package TelenorGp;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.relevantcodes.extentreports.LogStatus;


public class MongoTest {
	
	
	 private  void getAllDocuments(MongoCollection<Document> col) {
		    
		 
	        // Performing a read operation on the collection.
	        FindIterable<Document> fi = col.find();
	        MongoCursor<Document> cursor = fi.iterator();
	        try {
	            while(cursor.hasNext()) {
	            	System.out.println( "Fetching all documents from the mongo collection : "+cursor.next().toJson());
	            	//logger.info(cursor.next().toJson());
	            }
	        } finally {
	            cursor.close();
	        }
	    }
	 
	    // Fetch a selective document from the mongo collection.
	    private  void getSelectiveDocument(MongoCollection<Document> col) {
	       
	 
	        // Performing a read operation on the collection.
	        String col_name = "state", srch_string = "1";
	        FindIterable<Document> fi = col.find(Filters.eq(col_name, srch_string));      
	        MongoCursor<Document> cursor = fi.iterator();
	        try {
	            while(cursor.hasNext()) {
	            	System.out.println("Fetch a selective document from the mongo collection : "+cursor.next().toJson());
	            	
	               
	            }
	        } finally {
	            cursor.close();
	        }
	    }

	public String mongoDBSep(String id,String dbname,String collectionname) {

		try {

			String dbURI = "mongodb://AppUser:atLQL1KX1P5w@10.21.11.52:9075/admin";
			MongoClient mongoClient = new MongoClient(new MongoClientURI(dbURI));	
			
								
					MongoDatabase db1 = mongoClient.getDatabase(dbname);
					MongoCollection<Document> coll = (MongoCollection<Document>) db1.getCollection(collectionname);
			       
					//getAllDocuments(coll);
			 
					
			        // Fetching a single document from the mongodb based on a search_string.
			        //getSelectiveDocument(coll);
					
					DB db = mongoClient.getDB(dbname);
					 DBCollection collection = db.getCollection(collectionname);
//Keep your query conditions and selected fields objects as separate parameters to find:
					BasicDBObject query = new BasicDBObject();
			        query.put("_id", id);
			        
			        
			        System.out.println(query);

			        /* Step 5 : Get all documents */
			        DBCursor cursor = collection.find(query);
			        
			       

			        /* Step 6 : Print all documents */
			        while(cursor.hasNext()){
			            System.out.println(cursor.next());
			            			        }
			    
							
			
			mongoClient.close();
		} catch (MongoException e) {
			e.printStackTrace();
		}
		return "Unable to get Details !";

	}

}
