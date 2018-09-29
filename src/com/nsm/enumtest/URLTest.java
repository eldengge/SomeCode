package com.nsm.enumtest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {
	public static void main(String[] args) throws Exception {
		URL url = new URL("https://desk-fd.zol-img.com.cn/t_s1440x900c5/g5/M00/0F/07/ChMkJlauymeIYMI3AAhS3aKLXp4AAH8tQD5_3oACFL1729.jpg");
		HttpURLConnection conn = (HttpURLConnection)url.openConnection();
		conn.setRequestMethod("GET");
		conn.setConnectTimeout(5*1000);
		int responseCode = conn.getResponseCode();
		if(responseCode == HttpURLConnection.HTTP_OK){
			InputStream inputStream = conn.getInputStream();
			BufferedInputStream in = new BufferedInputStream(inputStream);
			BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("C:/Users/nsmha/Desktop/工作/TXT/test.jpg"));
			byte[] buffer = new byte[8*1024];
			int len;
			while((len = in.read(buffer, 0, buffer.length))!=-1){
				out.write(buffer, 0, len);
			}
		}
	}
}
