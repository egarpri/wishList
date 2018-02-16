package com.wishList;

import org.hibernate.validator.constraints.NotEmpty;

public class Wish {

	@NotEmpty
	private String title;

	private Wish() {
		
	}
	
	public Wish(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
