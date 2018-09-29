package com.nsm.iotest;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Ziptest {
	public void packageSource(String filePath,File file,FileOutputStream fos,ZipOutputStream zos) throws IOException{
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		ZipEntry zipEntry = null;
		if(file.isDirectory()){
			filePath +=file.getName() + File.separator;
			File[] files = file.listFiles();
			if(files.length != 0){
				for (int i = 0; i < files.length; i++) {
					packageSource(filePath,files[i],fos,zos);
				}
			}else{
				zipEntry = new ZipEntry(filePath);
				System.out.println(zipEntry.getName());
				zos.putNextEntry(zipEntry);
			}
		}else{
			try{
				zipEntry = new ZipEntry(filePath + file.getName());
				System.out.println(zipEntry.getName());
				zos.putNextEntry(zipEntry);
				byte[] buffer = new byte[8*1024];
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				int len = 0;
				while((len = bis.read(buffer, 0, buffer.length))!=-1){
					zos.write(buffer, 0, len);
				}
			}finally{
				if(null != bis){
					bis.close();
				}
			}
		}
	
	}
	
	public File getZip(File file){
		if(!file.isDirectory()){
			throw new RuntimeException("方法只对目录有效");
		}
		String zipPath = "D:/" + file.getName() + ".zip";
		File zipFile = new File(zipPath);
		if(zipFile.exists()){
			System.out.println("原压缩文件已删除");
			zipFile.delete();
		}
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipPath);
			zos = new ZipOutputStream(new BufferedOutputStream(fos));
			packageSource("",file,fos,zos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(null != zos){
				try {
					zos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return zipFile;
	}
	
	public static void main(String[] args) throws IOException {
		new Ziptest().getZip(new File("D:/home"));
	}
}
