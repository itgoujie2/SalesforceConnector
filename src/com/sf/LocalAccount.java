package com.sf;

import java.io.Serializable;

public class LocalAccount implements Serializable{
	
	private String name;
	
	public LocalAccount() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
