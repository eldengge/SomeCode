package com.nsm.jsouptest;


public class SatellitePic{
	private int flag;
	private Type sdco;// 资料类型  红外(1 I;2 J);可见光(V);水蒸气(W)
	private String sdpr;// 投影方式
	private StarArea sarea;// 有效区域
	private StarType star;// 卫星类型
	private String Path;//文件路径
	
	
	public SatellitePic() {
	}
	
	
	public int getFlag() {
		return flag;
	}

	public void setFlag(int flag) {
		this.flag = flag;
	}

	public Type getSdco() {
		return sdco;
	}

	public void setSdco(Type sdco) {
		this.sdco = sdco;
	}

	public String getSdpr() {
		return sdpr;
	}

	public void setSdpr(String sdpr) {
		this.sdpr = sdpr;
	}

	public StarArea getSarea() {
		return sarea;
	}

	public void setSarea(StarArea sarea) {
		this.sarea = sarea;
	}

	public StarType getStar() {
		return star;
	}

	public void setStar(StarType star) {
		this.star = star;
	}

	public String getPath() {
		return Path;
	}

	public void setPath(String path) {
		Path = path;
	}



	public enum StarType{
		JAPAN_STAR("2","日本卫星"){};
		
		private String value;
		
		private String chName;
		
		private StarType(String value, String chName) {
			this.value = value;
			this.chName = chName;
		}
		
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getChName() {
			return chName;
		}

		public void setChName(String chName) {
			this.chName = chName;
		}
		
	}
	
	public enum Type{
		STAR_INFRARED("红外线","I","element=0"){},//红外线
		STAR_VISIBILITY("能见度","V","element=1"){},//能见度
		STAR_VAPOUR("水蒸气","W","element=2"){};//水蒸气
		
		private String chName;
		
		private String value;
		
		private String urlPart;

		private Type(String chName, String value,String urlPart) {
			this.chName = chName;
			this.value = value;
			this.urlPart = urlPart;
		}

		public String getChName() {
			return chName;
		}

		public void setChName(String chName) {
			this.chName = chName;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getUrlPart() {
			return urlPart;
		}

		public void setUrlPart(String urlPart) {
			this.urlPart = urlPart;
		}
	}
	
	public enum StarArea{
		JAPAN("日本","?area=0&"){};
		private String chName;
		
		private String urlPart; 

		private StarArea(String chName,String urlPart) {
			this.chName = chName;
			this.urlPart = urlPart;
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
		
	}
	
	public static class STAR
	{
		public static final String FENG_YUN = "1";// 风云
		public static final String JAPAN = "2";// 日本
		
		public static final String FENG_YUN_1D = "1D";//风云1D极轨卫星
		public static final String FENG_YUN_2C = "2C";//风云2C
		public static final String FENG_YUN_2D = "2D";//风云2D
		public static final String FENG_YUN_2E = "2E";//风云2号E星
		public static final String FENG_YUN_3A = "3A";//风云3号极轨A星

		public static final String JAPAN_MT = "MT";//日本静止卫星
	}

	public static class DataType
	{
		public static final String HONG_WAI1 = "I";
		public static final String HONG_WAI2 = "J";
		public static final String KE_JIAN_GUANG = "V";
		public static final String SHUI_QI = "W";
	}
}


