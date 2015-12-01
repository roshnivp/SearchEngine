package com.sjsu.search;

//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.sjsu.search.database.DB;

public class SearchBean {
	FileReaderClient fileClient = null;

	ResultSet rs = null;

	public SearchBean() {
		System.out.println("Hi");
		System.out.println("init searchbean");
		// fileClient = new
		// FileReaderClient("/Users/Kashyap/Desktop/sjsu_cs257/cs257_proj/04CS257Semantic
		// DB/backup-2012.09.07/backup/inputfiles/doc1.txt");
		// System.out.println("init searchbean " + fileClient);
	}

	boolean success = false;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	ArrayList<String> result = new ArrayList<String>();
	public ArrayList<String> result2 = new ArrayList<String>();
	String query = null;
	String query1= null;
	String query2 = null;
	String searchResult = null;

	public void reset() {
		success = false;
		query = null;
	}

	public ArrayList<String> getResult() {
		return result;
	}

	public ArrayList<String> getURL()
	{
		System.out.println("URLS : "+result2);
		return result2;
	}

	public void setQuery(String query) {

		try {

			// List<String> tokList = new ArrayList<String>();
			final DB db = new DB();
			ArrayList<String> tokList = new ArrayList<String>();
			this.query = query;
			System.out.println("setQuery " + query);

			// Retrieve data from database
			String sql1 = "SELECT TokensOrigin from Concepts where TokensOrigin like '%" + query + "%'";
			Statement st1 = DB.conn.createStatement();
			System.out.println(sql1);
			rs = st1.executeQuery(sql1);

			while (rs.next()) {

				tokList.add(rs.getString("TokensOrigin"));

			}
			this.result = tokList;
			db.finalize();
			this.success = true;
			rs.close();

		}

		catch (Throwable s) {

			((Throwable) s).printStackTrace();
		}

	}

	 public ArrayList<String> setURL(String query1)
	 {
		 try
		 {
			 final DB db = new DB();
				ArrayList<String> urlList = new ArrayList<String>();
				this.query1 = query1;
				// Retrieve urlList which contains queried word from Semantic DB
				String sql2 = "select distinct u.url from URLPages u inner join MapConceptToURL m on u.id=m.URLID inner join Concepts c on m.ConceptID= c.ID  and c.TokensOrigin like '%"
						+ query1 + "%'";
				Statement st2 = DB.conn.createStatement();
				System.out.println(sql2);
				ResultSet rs2 = st2.executeQuery(sql2);

				while (rs2.next()) {
					urlList.add(rs2.getString("URL"));

				}
				this.result2 = urlList;
				db.finalize();
				this.success = true;
				rs2.close();
		 }
		 
		 catch (Throwable s) {
				((Throwable) s).printStackTrace();
			}
		 return result2;
		 
	 }
	 
	public String getFile(String filename,String query2) {
		try {
			
			
			//ArrayList<String> url=result2;
			System.out.println("\nFile with " + query2 + "  : " +filename);
			FileReaderNew fr = new FileReaderNew();
			this.searchResult = fr.openFile(filename,query2);		

		} catch (Throwable s) {
			((Throwable) s).printStackTrace();
		}
		return searchResult;

	}

}
