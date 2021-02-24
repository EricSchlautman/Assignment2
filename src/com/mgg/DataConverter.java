package com.mgg;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
/**
 * Program reads in data from .csv file converts it to the appropriate
 * object and outputs data to properly formatted XML/JSON file.
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class DataConverter {
	
	public static List<Store> loadFileStores() {
		Scanner s = null;
		List <Store> stores = new ArrayList <>();
		
		try {
			s = new Scanner(new File("data/Stores.csv"));
			//read in first line for number of lines
		    int temp = Integer.parseInt(s.nextLine());
		    
		    while (s.hasNextLine()) {
		    	String line = s.nextLine();
		    	
		    	String tokens[] = line.split(",|;");
		    	
		    	String storeCode = tokens[0];
		    	String managerCode = tokens[1];
		    	Address address = new Address(tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
		    	Store b = new Store(storeCode, managerCode, address);
		    	stores.add(b);
		    	System.out.println();
		    }
		} catch (FileNotFoundException e) {
		throw new RuntimeException (e); 
	    }
		return stores;
	}
	public static void printFileStores(List<Store> b) {
		try {
			PrintWriter p = new PrintWriter(new File("data/Stores.xml"));
			p.println("<Stores>");
			for (Store s : b) {
				XStream xstream = new XStream();
				xstream.alias("store", Store.class);
				String xmlStore = xstream.toXML(s);
				p.println(xmlStore);
			}
			p.println("</Stores>");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException (e);
		}
		
	}
	public static void main(String[] args) {
		List<Store> stores = loadFileStores();
		
		printFileStores(stores);
	}

}
