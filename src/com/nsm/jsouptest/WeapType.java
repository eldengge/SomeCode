package com.nsm.jsouptest;

public enum WeapType {
	
	EAR("ear","heavyrain","短时强降雨监测"){},//全国短时强降水
	EDA("eda","gale","雷暴大风监测"){},//全国雷暴大风
	ELTN("eltn","lighting","地闪监测"){},//全国地闪
	EHAIL("ehail","hail","冰雹天气监测"){};//全国冰雹天气
	
	private String name;
	
	private String urlPart;
	
	private String chname;
	

	private WeapType(String name, String urlPart, String chname) {
		this.name = name;
		this.urlPart = urlPart;
		this.chname = chname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrlPart() {
		return urlPart;
	}

	public void setUrlPart(String urlPart) {
		this.urlPart = urlPart;
	}

	public String getChname() {
		return chname;
	}

	public void setChname(String chname) {
		this.chname = chname;
	}
	
}
