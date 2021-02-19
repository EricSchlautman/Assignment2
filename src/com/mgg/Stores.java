package com.mgg;

public class Stores {

	private String codeStore;
	private String codeManager;
	private Address address;
	
	public Stores(String codeStore, String codeManager, Address address) {
		this.codeStore = codeStore;
		this.codeManager = codeManager;
		this.address = address;
	}
	public String getCodeStore() {
		return this.codeStore;
	}
	public String getCodeManager() {
		return this.codeManager;
	}
	public Address getAddress() {
		return this.address;
	}
	@Override
	public String toString() {
		return "Stores [codeStore=" + codeStore + ", codeManager=" + codeManager + ", address=" + address + "]";
	}
}
