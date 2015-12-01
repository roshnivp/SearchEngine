package com.sjsu.search;

import java.util.ArrayList;
import java.io.*;
import java.util.Iterator;

public class FileReaderNew {

	public String fileName;
	public String sCurrentLine;
	public SearchBean bean = new SearchBean();
	BufferedReader br;
	StringBuilder sb = new StringBuilder();

	public FileReaderNew() {

	}

	public String openFile(String Filename, String word) {
		try {
			sb.append("<BR>" + "<BR>" + "<B>");
			sb.append(Filename);
			sb.append("</B>" + "<BR>" + "<BR>");
			String[] tokens = word.split("\\s+");

			// Read the files and check for matched tokens inside the file
			br = new BufferedReader(new FileReader(Filename));
			String lines = null;

			while (((lines = br.readLine()) != null)) {
				boolean match = false;
				//String[] linesplit = line.split("\\.");
				//int it = 1;
				//for (String lines : linesplit) {
					for (int i = 0; i < tokens.length; i++) {

						String tok = tokens[i];
						//System.out.println("Splitted Token : " + tok);
						// if (lines.matches("(?i:.*"+tok+".*)"))

						if (lines.contains(tok))

						{
							// System.out.println(" lines : " +lines);

							match = true;
							// System.out.println(" Token is : " + tok);
							String bold = "<mark>"+"<B>" + tok +"</B>"+ "</mark>";
							lines = lines.replace(tok, bold);
						}
					}
					if (match) {

						sb.append(lines);
						sb.append("\n");
						sb.append("<BR>");
						// System.out.println("Line :"+line);
						// sb.append();
					}
				//}
				//it++;
			}

		} catch (Throwable s) {
			((Throwable) s).printStackTrace();
		}

		return sb.toString();
	}

	public String setFile(ArrayList<String> urlList, String word) {
		try {

			System.out.println("\nSearched word :" + word);
			Iterator<String> iter = urlList.iterator();

			while (iter.hasNext()) {
				String FileList = iter.next();
				System.out.println("Filelists :" + FileList);
				sb.append("<BR>" + "<BR>" + "<B>");
				sb.append(FileList);
				sb.append("</B>" + "<BR>" + "<BR>");

				// Split searched word into tokens
				String[] tokens = word.split("\\s+");

				// Read the files and check for matched tokens inside the file
				br = new BufferedReader(new FileReader(FileList));
				// Scanner scan = new Scanner(new FileReader(FileList));
				String line = null;

				while (((line = br.readLine()) != null))
				// while (scan.hasNextLine())
				{
					boolean match = false;

					String[] linesplit = line.split("\\.");
					int it = 1;
					for (String lines : linesplit) {

						for (int i = 0; i < tokens.length; i++) {
							// System.out.println(i + " TOKEN : " + tokens[i]);
							String tok = tokens[i];
							// System.out.println("Splitted Token : " + tok);
							if (lines.contains(tok)) {

								match = true;
								// System.out.println(" Token is : " + tok);
								String bold = "<mark>" + tok + "</mark>";
								lines = lines.replace(tok, bold);
							}
						}
						if (match) {

							sb.append(lines);
							sb.append("\n");
							sb.append("<BR>");
							// System.out.println("Line :"+line);
							// sb.append();
						}
					}
					it++;
				}

				// scan.close();
				br.close();
			}
		} catch (Throwable s) {
			((Throwable) s).printStackTrace();
		}
		return sb.toString();
	}

}
