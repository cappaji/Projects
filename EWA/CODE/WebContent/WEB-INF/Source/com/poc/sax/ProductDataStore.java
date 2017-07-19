package com.poc.sax;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.model.pojo.Airlines;


public class ProductDataStore extends DefaultHandler{
	Airlines product;
	List<Airlines> productsList;
	String productXmlFileName;
	String elementValueRead;
	
	public ProductDataStore(String ProductFile){
		System.out.println("Inside constrctor of ProductDataStore : "+ProductFile);
		this.productXmlFileName = ProductFile;
		productsList = new ArrayList<Airlines>();
        parseDocument();
        printReadProducts();
        addProductsToMap();
	}
	
	private void parseDocument() {
		System.out.println("Inside parseDocument() method of ProductDataStore : "+productXmlFileName);
		System.out.println("this : "+this);
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            parser.parse(productXmlFileName, this);
        } catch (ParserConfigurationException e) {
            System.out.println("ParserConfig error");
        } catch (SAXException e) {
            System.out.println("SAXException : xml not well formed");
        } catch (IOException e) {
            System.out.println("IO error");
        }
    }
	
	private void printReadProducts()
	{
		System.out.println("Inside printMap()");
		
		for (Airlines product: productsList) {
           System.out.format("%-5s|%-10s|%-20s|%-10s|%-30s|%-10s|%-30s|%-5s\n", product.getAirlinesName(), product.getCarrierFsCode(), product.getImage());
        }
	}
	
	HashMap<String,Airlines> productMap=new HashMap<String,Airlines>();
	
	public HashMap addProductsToMap(){
		System.out.println("Inside addProductsToMap() method of ProductDataStore");
		for(Airlines product:productsList){
				productMap.put(product.getCarrierFsCode(), product);
		}
		return productMap;
	}
	
	private void printMap(){
		Set<Map.Entry<String, Airlines>> entries=productMap.entrySet();
		for(Map.Entry<String, Airlines> prodMap:entries){
			Airlines product=prodMap.getValue();
			System.out.println(prodMap.getKey()+" :  "+product.getAirlinesName()+"  "+product.getCarrierFsCode()+" "+product.getImage());
		}
	}
	 	@Override
	    public void startElement(String str1, String str2, String elementName, Attributes attributes) throws SAXException {
	        if (elementName.equals("airline")) {
	            product = new Airlines();
	        }
	    }
	 	
	 	@Override
	    public void endElement(String str1, String str2, String element) throws SAXException {
	        if (element.equals("airline")) {
	        	productsList.add(product);
	        	return;
	        }
	        if (element.equalsIgnoreCase("airlinesName")) {
	        	product.setAirlinesName(elementValueRead);
	        	return;
	        }
	        if (element.equalsIgnoreCase("carrierCode")) {
	        	product.setCarrierFsCode(elementValueRead);
	        	return;
	        }
	        
	        if (element.equalsIgnoreCase("image")) {
	        	product.setImage(elementValueRead);
	        	return;
	        }
	    }
	 	
	 	@Override
	    public void characters(char[] content, int begin, int end) throws SAXException {
	        elementValueRead = new String(content, begin, end);
	    }

}