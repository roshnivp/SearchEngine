package com.sjsu.search;

import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderClient {

	private String fileName;
	public FileReaderClient(String filename) {
		this.fileName = filename;
	}
	
	public String getLines() {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			
			line = br.readLine();
			if(line != null) {
				sb.append(line);
			}
			do {
				line = br.readLine();
				if(line != null) {
					sb.append("\n").append(line);
				}
			} while(line != null);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	public String queryFile(String queryTerm) {
		System.out.println("queryFile " + queryTerm);
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			
			line = br.readLine();
			if(line != null && line.contains(queryTerm)) {
				sb.append(line);
			}
			do {
				line = br.readLine();
				if(line != null && line.contains(queryTerm)) {
					sb.append("\n").append(line);
				}
			} while(line != null);
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		//FileReaderClient c = new FileReaderClient("/Users/Kashyap/Desktop/sjsu_cs257/cs257_proj/04CS257Semantic DB/backup-2012.09.07/backup/inputfiles/doc1.txt");
		//System.out.println(c.getLines());
		System.out.println("Hello");
	}

}
