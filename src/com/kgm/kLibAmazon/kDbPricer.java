package com.kgm.kLibAmazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.w3c.dom.*;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import android.content.Context;

/**
 * Created by goga on 7/18/14.
 */
public class kDbPricer
{
    private XmlPullParserFactory xml_object = null;
    private XmlPullParser xml_parser = null;
    
    private String dbFile = "kdbprice.db";

    public kDbPricer()
    {
    	try {
    		xml_object = XmlPullParserFactory.newInstance();
    		xml_parser = xml_object.newPullParser();
    		        	
        	String data = readFile(dbFile);
        	
        	if (data.length() < 1)
        		return;
        	
        	
    	} catch (Exception e) {
    		
    	}    	
    }
    
    public String readFile(String filename)
    {
       String content = null;
       File file = new File(filename);
       
       try {
           FileReader reader = new FileReader(file);
           char[] chars = new char[(int) file.length()];
           reader.read(chars);
           content = new String(chars);
           reader.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
       
       return content;
    }

    public boolean update()
    {
        return true;
    }

}
