<%@ page import = "com.sjsu.search.SearchBean" %>
<jsp:useBean id="search" class="com.sjsu.search.SearchBean" scope="session"/>
<jsp:setProperty name="search" property="*"/>

<html>
<head><title>Search</title></head>
<body background="blue.jpg">
<font size=3>
Search Results....
<BR>
<% 
String searchword=request.getParameter("query1");
String fname=request.getParameter("query2");
%>
  You searched for :<B> <% out.println(searchword);%> </B> <BR>
    <% out.println(search.getFile(fname,searchword));  
%>

</body>
</html>