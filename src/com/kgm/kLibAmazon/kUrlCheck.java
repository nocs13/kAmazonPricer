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
	        connection = (HttpURLConnection) http.openConnection();     
	        connection.setRequestMethod("HEAD");         
	        int code = connection.getResponseCode();
	        
	        if(code != 200)
	        {
	        	
	        }
	        
	        return true;
	    } 
	    catch (Exception e) 
	    {
	    	return false;
	    }	
	}
}
