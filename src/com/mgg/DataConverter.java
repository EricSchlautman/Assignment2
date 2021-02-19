package com.mgg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//import unl.cse.library.Author;
//import unl.cse.library.Book;

public class DataConverter {

	public static void main(String[] args) {
		
		loadFileStores();
		
	}
	
	private static void loadFileStores() {
		Scanner s = null;
		try {
			s = new Scanner(new File("data/Stores.csv"));
			int temp = Integer.parseInt(s.nextLine());
			
			while(s.hasNext()) {
	    		String line = s.nextLine();

	    		String tokens[] = line.split(",|;");
	    		//System.out.printf("%s\n", tokens[6]);
	    		String storeCode = tokens[0];
	    		String managerCode = tokens[1];
	    		Address address = new Address(tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]);
	    		Stores b = new Stores(storeCode, managerCode, address);
	    		System.out.println(b);
	    		printFileStores(b, temp);
	    	}  
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		
		return;
	}
	
	public static void printFileStores(Stores b, int length) {
		
		
	}
}
