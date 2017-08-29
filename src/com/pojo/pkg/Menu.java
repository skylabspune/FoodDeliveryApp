package com.pojo.pkg;

public class Menu {
	
	private String name;
	private String price;
	private String available ;
	
	
	
	public Menu(String name, String price, String available) {
		super();
		this.name = name;
		this.price = price;
		this.available = available;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getAvailable() {
		return available;
	}
	public void setAvailable(String available) {
		this.available = available;
	}
	
	
	
	
	
}
