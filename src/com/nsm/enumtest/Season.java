package com.nsm.enumtest;

public enum Season {
	SUMMER("夏"),WINNER("冬"),AUTUMN("秋"),SPRING("春");
	private String name;
	private Season(String name){
		this.name=name;
	}
}
