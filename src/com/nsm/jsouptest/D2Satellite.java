package com.nsm.jsouptest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import com.nsm.jsouptest.SatellitePic.StarArea;
import com.nsm.jsouptest.SatellitePic.Type;

public class D2Satellite {
	
	private static final String urlHead = "http://www.jma.go.jp/jp/gms/large.html";

	//包含目标图片的img标签的id
	private static final String HTMLPAGE_IMG_ID = "image";
	
	private static final String PATTERN_DIR ="yyyyMMdd";
	
	private static final String PATTERN_FILENAME ="yyyyMMddHHmm";
	
	private static final String DATA_HOME = "D:/";
	//url上时间比实际时间提前的小时数
	private static final long BEFOR_TIME = 0;
	
	public void download() {
		// TODO Auto-generated method stub
		try {
			long start = System.currentTimeMillis()/1000;
			downloadWebImg();
			long end = System.currentTimeMillis()/1000;
			System.out.println("用时:"+(end-start));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	private void downloadWebImg() throws Exception{
		//获取全部分析地区
		StarArea[] areas = StarArea.values();
		Type[] types = Type.values();
		String pageUrl = "";
		for(StarArea area : areas){
			for(Type type : types){
				pageUrl = urlHead + area.getUrlPart() + type.getUrlPart();
				System.out.println(pageUrl);
				String imgUrl = getImgUrl(pageUrl);
				System.out.println("Picture start to download");
				System.out.println("imgUrl: " + imgUrl);
				InputStream imgStream = getWebSource(imgUrl);
				File file = getFilePath(imgUrl,area,type);
				System.out.println(file.getPath());
				//File writeFile = writeFile(file, imgStream);
			}
		}
	
	
	}
	/**
	 * 
	 * @param pageUrl //页面url
	 * @return 图片url
	 * @throws Exception
	 */
	private String getImgUrl(String pageUrl) throws Exception{
		String imgUrl = "";
		Document doc = null;
		try {
			//获取页面Document
			doc = Jsoup.connect(pageUrl).get();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Problem with page access :" + pageUrl);
			throw new Exception(e);
		}
		//获取页面中img标签的src
		imgUrl = doc.getElementById(HTMLPAGE_IMG_ID).attr("src");
		return imgUrl;
	}
	/**
	 * 
	 * @param imgUrl //图片url
	 * @return 图片输入流
	 * @throws Exception
	 */
	private InputStream getWebSource(String imgUrl) throws Exception{
		URL url = null;
		HttpURLConnection imgConn = null;
		url = new URL(imgUrl);
		imgConn = (HttpURLConnection)url.openConnection();
		imgConn.setRequestMethod("GET");
		imgConn.setConnectTimeout(5000);
		int responseCode = imgConn.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
//			System.out.println("图片地址不存在,稍后下载.....");
			return null;
		}else if(responseCode == HttpURLConnection.HTTP_OK){
			//如果状态码为200返回图片输入流
			return imgConn.getInputStream();
		}else{
			return null;
		}
	}
	//根据图片url进行图片路径拼接，为逐小时降雨使用。
	private File getFilePath(String imgUrl,StarArea area,Type type){
		String urlTimeStr = imgUrl.substring(imgUrl.lastIndexOf("/")+1, imgUrl.lastIndexOf("-"));
		String fname = type.name().toLowerCase()+"_"+getDateString(urlTimeStr, BEFOR_TIME, PATTERN_FILENAME) +".star";
		String dataHome = DATA_HOME;
		String filePath = dataHome + "japanstar" + File.separator + area.name().toLowerCase() + File.separator
				+ type.name().toLowerCase() + getDateString(urlTimeStr, BEFOR_TIME, PATTERN_DIR) +File.separator
				+ fname;
		return new File(filePath);
	}
	//将图片流写入本地目录
	private File writeFile(File file,InputStream imgStream) throws Exception{
		String parentPath = file.getParent();//获取要创建的文件的目录
		isDirExists(parentPath);//判断目录是否存在如果不存在则创建
		if(file.exists()){
			System.out.println("This file already exists......");
			return null;
		}
		byte[] buff = new byte[8 * 1024];
		BufferedInputStream in  = null;
		BufferedOutputStream out = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
			in = new BufferedInputStream(imgStream);
			out = new BufferedOutputStream(fileOutputStream);
			int len = 0;
			while((len = in.read(buff, 0, buff.length))!=-1){
				out.write(buff, 0, len);
			}
			System.out.println("picture " + file.getName() + " writing success in "+file.getAbsolutePath() + " ........");
		}finally{
			if(in != null){
				in.close();
			}
			if(out != null){
				out.close();
			}
		}
		return file;
	}
	/**
	 * 
	 * @param Hours //比实际时间提前的小时数
	 * @param pattern //需要格式化的格式
	 * @return
	 */
	private String getDateString(String urlTimeStr,long Hours, String pattern) {
		LocalDateTime time = LocalDateTime.parse(urlTimeStr,DateTimeFormatter.ofPattern(PATTERN_FILENAME));
		LocalDateTime plus = time.plusHours(Hours);
		DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
		return df.format(plus);
	}

	/**
	 * 查看文件目录是否存在,不存在建立文件夹
	 */
	private int isDirExists(String path) {
		File file = new File(path);
		boolean exists = file.exists();
		if (exists) {
			return 0;
		} else {
			exists = file.mkdirs();
			if (exists) {
				System.out.println(path
						+ " is not exist,create folder success!");
				return 1;
			} else {
				System.out.println("some reasons lead to unsuccess");
				return 2;
			}
		}
	}
	public static void main(String[] args) {
		new D2Satellite().download();
	}
}
