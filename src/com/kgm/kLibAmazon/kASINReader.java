package com.kgm.kLibAmazon;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class kASINReader {
	String ASIN = "";

	public kASINReader(String url_page) {
		try {
			URL url = new URL(url_page);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(url.openStream());
			Element el = doc.getElementById("detail-bullets");

			if (el != null) {
				NodeList divs = el.getElementsByTagName("div");

				for (int i = 0; i < divs.getLength(); i++) {
					String asin = findASIN((Element) divs.item(i));

					if (asin != "") {
						ASIN = asin;

						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Error while check ASIN: " + e.getMessage());

		}
	}

	public String getASIN() {
		return ASIN;
	}

	private String findASIN(Element el) {
		String asin = "";
		NodeList els = el.getElementsByTagName("li");

		for (int i = 0; i < els.getLength(); i++) {
			Element cel = (Element) els.item(i);

			Element bel = (Element) cel.getFirstChild();

			if ((bel.getTagName() == "b" || bel.getTagName() == "B")
			    && bel.getNodeValue() == "ASIN: ") {
				asin = cel.getNodeValue();

				break;
			}
		}

		if (asin != "")
			return asin;

		return "";
	}
}
