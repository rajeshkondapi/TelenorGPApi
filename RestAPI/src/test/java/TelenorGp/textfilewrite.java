package TelenorGp;

import java.io.*;
import java.util.Random;

import org.json.JSONObject;

import com.google.gson.Gson;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

public class textfilewrite {
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

    public static void main(String[] args) throws ParseException
    {
    	//System.out.println(getRandomNumberInRange(100000000000000000,  999));
    	Random rnd = new Random();
    	int n = 1000000000 + rnd.nextInt(900000000);
    	int y = 10000 + rnd.nextInt(90000);
    	System.out.println(n+""+n+""+y);
    	
    	
    	String c = "{  \"accesInfo\": {  \r\n" + 
    			"  \"accesskey\": \"d5a3f90c062248a7be17e4deed14b23e\",  \r\n" + 
    			"  \"endUserId\": \"8801307257910\",\r\n" + 
    			"  \"accesschannel\": \"CRM\",  \r\n" + 
    			"  \"referenceCode\": \"{{$randomInt}}\"  }, \r\n" + 
    			"  \"charge\": {  \r\n" + 
    			"  \"serviceIdentifier\": \"SUB00010201205\",\r\n" + 
    			"  \"code\": \"SUB0001020120519411527\"  } \r\n" + 
    			" }";
    	
    	Gson gson = new Gson();

        //convert java object to JSON format
        String json = gson.toJson(c);
        System.out.println(json);
    	
    	
    }
    }