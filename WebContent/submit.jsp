<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Enter to database</title>
</head>
<body>
<%@ page import ="java.sql.*" %>
<%@ page import ="javax.sql.*" %>
<%
java.sql.Connection con; 
java.sql.Statement st;
java.sql.ResultSet rs;
java.sql.PreparedStatement pst;
con=null;
st=null;
rs=null;
pst=null;

try{
  Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
  con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1;databaseName=SemanticDB","cs267","harmonic"); 
} 
catch (SQLException e) {
    e.printStackTrace();
} 
catch (ClassNotFoundException e) {
    e.printStackTrace();
}

String sql="select top 10 * from dbo.Concepts ";
try{
  st= con.createStatement(); 
  //rs=st.executeQuery(sql);
 // while(rs.next()){ 
	out.println("Hi");
	//(rs.getInt(1)+" "+rs.getString(2));
	//}
  con.close();
}
catch (Exception e) {
    e.printStackTrace();
} 

%>
</body>
</html>