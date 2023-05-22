package com.filehandling.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class bufferReader {

	public static void main(String[] args) throws IOException {
		
		String location = "FileUsingBuffer.txt";
		
		FileReader fileReader = new FileReader(location);
		
		BufferedReader bufferReader = new BufferedReader(fileReader);
		String readlines ;
		
		while((readlines = bufferReader.readLine())!=null) {
			System.out.println(readlines);
		}
		
		bufferReader.close();

	}

}
