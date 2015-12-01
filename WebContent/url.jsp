<%@page language="java" contentType="text/html" pageEncoding="UTF-8" %>
<%@ page import = "com.sjsu.search.SearchBean" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<jsp:useBean id="search" class="com.sjsu.search.SearchBean" scope="session"/>
<jsp:setProperty name="search" property="*"/>

<html>
<head><title>SJSU Search</title></head>
<body background="blue.jpg">
<font size=4>
<table width="1700px" align="center" cellspacing="1">
Search results... <TR>
<BR>
 <% String req=request.getParameter("query1");%> 
You searched for :<B><% out.println(req);%> </B> 
<TD> 
<BR>
<% search.setURL(req); %>

<% Iterator<String> Iterat = search.getURL().iterator();

while (Iterat.hasNext()) {
		String url=Iterat.next(); %>  <% System.out.println(url);%> 
		<a href="click.jsp?query2=<%out.println(url);%>&query1=<%out.println(req);%>" > <% out.println(url); %></a> <BR> <%
  
		}

%>

</TD>
</TR>
</table>
<% search.reset(); %>
  
<BR>
<a href="search.jsp">Back to search</a>

</font></body>
</html>