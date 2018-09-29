package com.nsm.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DownLoadTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("http://www.nmc.cn/publish/observations/hourly-precipitation.html");
		StringBuilder sb = new StringBuilder();
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5000);
		int responseCode = conn.getResponseCode();
		//如果地址不存在返回
		if(responseCode == HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println("地址不存在,稍后下载.....");
			return;
		}
		//如果状态码为200进行图片往本地写入操作
		if(responseCode == HttpURLConnection.HTTP_OK){
			InputStream inputStream = null;
			byte[] buff = new byte[8 * 1024];
			BufferedInputStream in  = null;
			BufferedOutputStream out = null;
			FileOutputStream fileOutputStream = null;
			try {
				//获取输入流
				inputStream = conn.getInputStream();
				fileOutputStream = new FileOutputStream("C:/Users/nsmha/Desktop/新/test.html");
				in = new BufferedInputStream(inputStream);
				out = new BufferedOutputStream(fileOutputStream);
				int len = 0;
				while((len = in.read(buff, 0, buff.length))!=-1){
					out.write(buff, 0, len);
				}
			} catch (Exception e) {
				// TODO: handle exception
				throw new Exception(e.getMessage());
			} finally{
				if(null!=in){
					in.close();
				}
				if(null!=out){
					out.close();
				}
			}
		}
	}
}
