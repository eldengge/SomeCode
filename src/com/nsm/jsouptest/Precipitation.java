package com.nsm.jsouptest;

public class Precipitation {
	
	
	
	// 类型
	enum PrecipitationType {
		HOURLY("逐小时降水", "publish/observations/hourly-precipitation") {
		}, // 逐小时降水
		SIXHOUR("6小时降水量", "publish/observations/6hour-precipitation-",
				new Aging[] { Aging.SIXHOUR_02, Aging.SIXHOUR_08,
						Aging.SIXHOUR_14, Aging.SIXHOUR_20 }) {
		}, // 6小时降水量
		DAILY("24小时降水量", "publish/observations/24hour-precipitation-",
				new Aging[] { Aging.DAILY_06, Aging.DAILY_08, Aging.DAILY_14,
						Aging.DAILY_20 }) {
		}, // 24小时降水量
		MONTHLY("月降水量", "publish/observations/precipitation-", new Aging[] {
				Aging.MONTHLY_10, Aging.MONTHLY_20, Aging.MONTHLY_30 }) {
		}, // 月降水量
		MONTHLYANOMALY("月降水距平", "publish/observations/precipitation-",
				new Aging[] { Aging.MONTHLYANOMALY_10, Aging.MONTHLYANOMALY_20,
						Aging.MONTHLYANOMALY_30 }) {
		};// 月降水距平

		private String chName;

		private String urlPart;

		private Aging[] child;

		private PrecipitationType(String chName, String urlPart, Aging... child) {
			this.chName = chName;
			this.urlPart = urlPart;
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

		public Aging[] getChild() {
			return child;
		}

		public void setChild(Aging[] child) {
			this.child = child;
		}

	}

	// 时效
	enum Aging {
		SIXHOUR_02("02时(6hr)", "02") {
		},
		SIXHOUR_08("08时(6hr)", "08") {
		},
		SIXHOUR_14("14时(6hr)", "14") {
		},
		SIXHOUR_20("20时(6hr)", "20") {
		},
		DAILY_06("06时(24hr)", "05") {
		},
		DAILY_08("08时(24hr)", "08") {
		},
		DAILY_14("14时(24hr)", "14") {
		},
		DAILY_20("20时(24hr)", "20") {
		},
		MONTHLY_10("近10天降水量", "10day") {
		},
		MONTHLY_20("近20天降水量", "20day") {
		},
		MONTHLY_30("近30天降水量", "30day") {
		},
		MONTHLYANOMALY_10("近10天降水距平百分率", "10pa") {
		},
		MONTHLYANOMALY_20("近20天降水距平百分率", "20pa") {
		},
		MONTHLYANOMALY_30("近30天降水距平百分率", "30pa") {
		};

		private String chName;

		private String urlPart;

		private Aging(String chName, String urlPart) {
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

}
