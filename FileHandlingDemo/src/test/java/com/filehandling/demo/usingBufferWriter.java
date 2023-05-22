package com.filehandling.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class usingBufferWriter {

	public static void main(String[] args) throws IOException {
		
		String location = "FileUsingBuffer.txt";
		String content = "Writing into File using File Buffer Writer";
		
		FileWriter fileWriter = new FileWriter(location);
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
		bufferWriter.write(content);
		bufferWriter.close();
	}

}
