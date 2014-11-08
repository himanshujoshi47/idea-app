package com.phoenixtechnoz.idea;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class ParseXmlResponse {
	
	  public static String XMLfromString(String xml,String Root){
		  String val;
			Document doc = null;
			
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		        try {

				DocumentBuilder db = dbf.newDocumentBuilder();

				InputSource is = new InputSource();
			        is.setCharacterStream(new StringReader(xml));
			        doc = db.parse(is); 
			        
			        NodeList nl = doc.getElementsByTagName(Root);
			         val = getElementValue(nl.item(0));
			        

				} catch (ParserConfigurationException e) {
					System.out.println("XML parse error: " + e.getMessage());
					return null;
				} catch (SAXException e) {
					System.out.println("Wrong XML file structure: " + e.getMessage());
		            return null;
				} catch (IOException e) {
					System.out.println("I/O exeption: " + e.getMessage());
					return null;
				}

		        return val;

			}
public final static String getElementValue(Node elem) {
	        Node child;
	        if( elem != null){
	            if (elem.hasChildNodes()){
	                for( child = elem.getFirstChild(); child != null; child = child.getNextSibling() ){
	                    if( child.getNodeType() == Node.TEXT_NODE  ){
	                        return child.getNodeValue();
	                    }
	                }
	            }
	        }
	        return "";
	 } 

}
