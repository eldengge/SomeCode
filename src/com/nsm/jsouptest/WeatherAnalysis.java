package com.nsm.jsouptest;

public class WeatherAnalysis {
	
	public enum WeatherAnalysisArea{
		
		CHINA("中国","publish/observations/china/dm/","c",new WeatherAnalysisType[]{WeatherAnalysisType.ANALYSIS,WeatherAnalysisType.SATELLITE,WeatherAnalysisType.RADAR}){},
		ASIA("亚欧","publish/observations/asia/dm/","a",new WeatherAnalysisType[]{WeatherAnalysisType.ANALYSIS,WeatherAnalysisType.ASIA_SATELLITE }){},
		NORTH("北半球","publish/observations/north/dm/","n",new WeatherAnalysisType[]{WeatherAnalysisType.ANALYSIS}){};
		
		private String chName;
		//用于拼接页面url
		private String urlPart;

		private WeatherAnalysisType[] child;
		//用于拼接文件名
		private String fnamePart;
		
		private WeatherAnalysisArea(String chName,String urlPart,String fnamePart,WeatherAnalysisType ... child){
			this.chName = chName;
			this.urlPart = urlPart;
			this.fnamePart = fnamePart;
			this.child = child;
		}

		public String getChName() {
			return chName;
		}

		public void setChName(String chName) {
			this.chName = chName;
		}

		public String getUrlPart() {
			return urlPart;
		}

		public void setUrlPart(String urlPart) {
			this.urlPart = urlPart;
		}

		public WeatherAnalysisType[] getChild() {
			return child;
		}

		public void setChild(WeatherAnalysisType[] child) {
			this.child = child;
		}

		public String getFnamePart() {
			return fnamePart;
		}

		public void setFnamePart(String fnamePart) {
			this.fnamePart = fnamePart;
		}
		
	}
	
	public enum WeatherAnalysisType{
		
		ANALYSIS("基本天气分析","weatherchart-","a"){},
		
		SATELLITE("叠加卫星云图","radar-","a"){},
		
		ASIA_SATELLITE("叠加卫星云图","cloud-","as"){},
		
		RADAR("叠加雷达拼图","cloud-","r"){};
		
		private String chName;
		//用于拼接页面url
		private String urlPart;
		//用于拼接文件名
		private String fnamePart;

		private WeatherAnalysisType(String chName, String urlPart, String fnamePart) {
			this.chName = chName;
			this.urlPart = urlPart;
			this.fnamePart = fnamePart;
		}

		public String getChName() {
			return chName;
		}

		public void setChName(String chName) {
			this.chName = chName;
		}

		public String getUrlPart() {
			return urlPart;
		}

		public void setUrlPart(String urlPart) {
			this.urlPart = urlPart;
		}

		public String getFnamePart() {
			return fnamePart;
		}

		public void setFnamePart(String fnamePart) {
			this.fnamePart = fnamePart;
		}
		
	}
	
	public enum WeatherAnalysisLevel{
		GROUND("地面","h000","0"){},
		
		PA_925("925hPa","h925","9"){},
		
		PA_850("850hPa","h850","8"){},
		
		PA_700("700hPa","h700","7"){},
		
		PA_500("500hPa","h500","5"){},
		
		PA_200("200hPa","h200","2"){},
		
		PA_100("100hPa","h100","1"){};
		
		private String chName;
		//用于拼接页面url
		private String urlPart;
		//用于拼接文件名
		private String fnamePart;

		private WeatherAnalysisLevel(String chName, String urlPart, String fnamePart) {
			this.chName = chName;
			this.urlPart = urlPart;
			this.fnamePart = fnamePart;
		}

		public String getChName() {
			return chName;
		}

		public void setChName(String chName) {
			this.chName = chName;
		}

		public String getUrlPart() {
			return urlPart;
		}

		public void setUrlPart(String urlPart) {
			this.urlPart = urlPart;
		}

		public String getFnamePart() {
			return fnamePart;
		}

		public void setFnamePart(String fnamePart) {
			this.fnamePart = fnamePart;
		}
		
	}
	
}
