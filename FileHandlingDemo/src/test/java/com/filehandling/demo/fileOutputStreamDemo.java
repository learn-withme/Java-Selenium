package com.filehandling.demo;

import java.io.FileOutputStream;
import java.io.IOException;

public class fileOutputStreamDemo {

	public static void main(String[] args) throws IOException {
		String location ="FileOutputStreamDemo.txt";
		String content = "Using File Output Stream for Demo Purpouse";
		
		FileOutputStream fileOutputStream =  new FileOutputStream(location);
		
		byte[] contentbyte = content.getBytes();
		fileOutputStream.write(contentbyte);
		fileOutputStream.close();
	}

}
