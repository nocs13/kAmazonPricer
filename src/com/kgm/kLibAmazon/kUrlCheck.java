package com.kgm.kLibAmazon;

import java.net.HttpURLConnection;
import java.net.URL;

public class kUrlCheck 
{
	public static boolean isValid(String url)
	{
	    HttpURLConnection connection = null;
	    
	    try
	    {         
	        URL http = new URL(url);        
	        System.out.println("001");
	        connection = (HttpURLConnection) http.openConnection();     
	        System.out.println("002");
	        connection.setRequestMethod("GET");    
	        System.out.println("003");
	        
	        int code = connection.getResponseCode();

	        System.out.println("Responce code: " + Integer.toString(code));
	        
	        if(code != 200)
	        {
	        	
	        }
	        
	        return true;
	    } 
	    catch (Exception e) 
	    {
	    	System.out.println("Not valid url: " + url + " error: " + e.getMessage());
	    	
	    	return false;
	    }	
	}
}
