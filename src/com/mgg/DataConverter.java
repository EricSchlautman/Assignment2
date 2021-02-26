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
	public static List<Items> loadFileItems() {
		Scanner s = null;
		List <Items> items = new ArrayList <>();
		
		try {
			s = new Scanner(new File("data/Items.csv"));
			//read in first line for number of lines
		    int temp = Integer.parseInt(s.nextLine());
		    
		    while (s.hasNextLine()) {
		    	String line = s.nextLine();
		    	
		    	String tokens[] = line.split(",|;");
		    	
		    	String code = tokens[0];
		    	String type = tokens[1];
		    	String name = tokens[2];
		    	String price = tokens[3];
		    	Items b = new Items(code, type, name, price);
		    	items.add(b);
		    }
		} catch (FileNotFoundException e) {
		throw new RuntimeException (e); 
	    }
		return items;
	}
	public static void printFileItems(List<Items> b) {
		try {
			PrintWriter p = new PrintWriter(new File("data/Items.xml"));
			p.println("<Items>");
			for (Items s : b) {
				XStream xstream = new XStream();
				xstream.alias("items", Items.class);
				String xmlItems = xstream.toXML(s);
				p.println(xmlItems);
			}
			p.println("</Items>");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException (e);
		}
		
	}
	public static List<Persons> loadFilePersons() {
		Scanner s = null;
		List <Persons> persons = new ArrayList <>();
		
		try {
			s = new Scanner(new File("data/Persons.csv"));
			//read in first line for number of lines
		    int temp = Integer.parseInt(s.nextLine());
		    
		    while (s.hasNextLine()) {
		    	List <String> emailAddresses = new ArrayList<>();
		    	String line = s.nextLine();
		    	
		    	String[] tokens = line.split(",|;",13);
		    	
		    	String code = tokens[0];
		    	String type = tokens[1];
		    	String lastName = tokens[2];
		    	String firstName = tokens[3];
		    	
		    	if(tokens.length > 9) {
		    		for(int i = 9; i < tokens.length; i++) {
		    			if(!tokens[i].isEmpty())
		    				emailAddresses.add(tokens[i]);
		    		}
		    	}
		    	
		    	Address address = new Address(tokens[4], tokens[5], tokens[6], tokens[7], tokens[8]);
		    	Persons b = new Persons(code, type, lastName, firstName, address, emailAddresses);
		    	
		    	persons.add(b);
		    }
		} catch (FileNotFoundException e) {
		throw new RuntimeException (e); 
	    }
		return persons;
	}
		
	public static void printFilePersons(List<Persons> b) {
		try {
			PrintWriter p = new PrintWriter(new File("data/Persons.xml"));
			p.println("<Persons>");
			for (Persons s : b) {
				XStream xstream = new XStream();
				xstream.alias("person", Persons.class);
				String xmlPersons = xstream.toXML(s);
				p.println(xmlPersons);
			}
			p.println("</Persons>");
			p.close();
		} catch (FileNotFoundException e) {
			throw new RuntimeException (e);
		}
		
	}
	
	public static void main(String[] args) {
		List<Store> stores = loadFileStores();
		printFileStores(stores);
		
		List<Items> items = loadFileItems();
		printFileItems(items);
		
		List<Persons> persons = loadFilePersons();
		printFilePersons(persons);
	}

}
