package com.kgm.kLibAmazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

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
    
    private List   dbList;

    public kDbPricer()
    {
    	dbList = new ArrayList();
    	
    	try {
    		xml_object = XmlPullParserFactory.newInstance();
    		xml_parser = xml_object.newPullParser();
    		        	
        	String data = readFile(dbFile);
        	
        	if (data.length() < 1)
        		return;
        	
        	xml_parser.setInput(new StringReader(data));
        	
        	 int eventType = xml_parser.getEventType();

        	 while (eventType != XmlPullParser.END_DOCUMENT) {
              if(eventType == XmlPullParser.START_DOCUMENT) {
                  System.out.println("Start document");
              } else if(eventType == XmlPullParser.START_TAG) {
                  System.out.println("Start tag "+xml_parser.getName());
              } else if(eventType == XmlPullParser.END_TAG) {
                  System.out.println("End tag "+xml_parser.getName());
              } else if(eventType == XmlPullParser.TEXT) {
                  System.out.println("Text "+xml_parser.getText());
              }
              eventType = xml_parser.next();
             }

    	} catch (Exception e) {
    		
    	}    	
    }
    
    private String readFile(String filename)
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
    
    private boolean writeFile(String filename, String data)
    {
    	return true;
    }
}
