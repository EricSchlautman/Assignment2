package com.mgg;

/**
 * @author Byron Rustrian
 * @author Eric Schlautman
 *
 */
public class Store {
	String storeCode;
	String managerCode;
	Address address;
	
	public String getStoreCode() {
		return this.storeCode;
	}
	public String getManagerCode() {
		return this.managerCode;
	}
	public Address getAddress() {
		return this.address;
	}
	public Store(String storeCode, String managerCode, Address address) {
		this.storeCode = storeCode;
		this.managerCode = managerCode;
		this.address = address;
	}
	
	
	
}
