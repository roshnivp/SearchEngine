<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import = "com.sjsu.search.SearchBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<jsp:useBean id="search" class="com.sjsu.search.SearchBean" scope="session"/>
<jsp:setProperty name="search" property="*"/>

<html>
<head><title>SJSU Search</title></head>
<link rel = "stylesheet" href = "gui_fnl_practice.css">
<body background="blue.jpg" >
<font size=5>

			

<% if (search.isSuccess()) { %>

Search Results 
<table width="1000px" cellspacing="1">
<TR>
<TD>

<% Iterator<String> Iter = search.getResult().iterator();

		while (Iter.hasNext()) {
		String t=Iter.next(); %>  <% System.out.println(t);%> 
<a href="url.jsp?query1=<%out.println(t);%>" > <% out.println(t); %></a> <BR> <%
  
		}

%>
</TD>
</TR>

 
</table>

<% search.reset(); %>
  
<a href="search.jsp">Search again</a>

<% } else { %>

<div id = mysearchform>
<img src = "SJSU_Spirit_blue.png" width = "50" hieght = "50" align = middle>
  <h2><p>SJSU Search:</p></h2></div>
	<form id = "mysearch" method=get name = "query">
<div id = "query">
	<table class = "centerTable">
	<tr>
	<td><input type=text size = 50 height = 50px name="query" width = 200px placeholder = "Search or typeURL"text-align: center;></td>
	<!--<td><textarea name = "SJSU Search" rows = "1.5" cols = "70" placeholder = "Search or type URL"></textarea></td></div>-->
	<td><input type = "submit" value = "Search"></td>
	</tr>
	</table></div>
  <!--
  <table class = "centerTable" align = center style = "margin:0px auto;">
  <tbody>
  <tr align = center><br><img src = "SJSU_Spirit_blue.png" width = "50" hieght = "50"></br></tr>
  <tr>SJSU Search: <input type=text name="query" text-align: center;></tr>
  <input type=submit value="Submit" text-align: center;>
  </tbody>
  </table>-->
  </form>


<% } %>

</font>
</body>
</html>
