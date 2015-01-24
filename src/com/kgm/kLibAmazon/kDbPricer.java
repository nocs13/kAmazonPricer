package com.kgm.kLibAmazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import android.content.Context;

/**
 * Created by goga on 7/18/14.
 */
public class kDbPricer {
	private XmlPullParserFactory xml_object = null;
	private XmlPullParser xml_parser = null;

	private String dbFile = "kdbprice.db";
	private Document xml_doc = null;

	public kDbPricer() {
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setValidating(false);

			DocumentBuilder db = dbf.newDocumentBuilder();
			DocumentBuilder builder = dbf.newDocumentBuilder();
			
			File file = new File(dbFile);
			
			if(!file.exists())
				xml_doc = builder.newDocument();
			else
				xml_doc = db.parse(new FileInputStream(file));
		} catch (Exception e) {
			System.out.print("kDbPricer::kDbPricer error: " + e.getMessage());
		}
	}
	
	public void update() {
		String data = xml_doc.toString();
		
		try {
			FileWriter file = new FileWriter(dbFile);
			
			file.write(data);
		} catch (Exception e) {
			System.out.print("kDbPricer::update error: " + e.getMessage());
		}
	}
	
	public Document getDoc() {
		return xml_doc;
	}
}
