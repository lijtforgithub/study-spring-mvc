<%@page import="java.util.List"%>
<%@page import="java.lang.String"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - URL</title>
</head>
<body>
<h1>SpringMVC</h1>
<br/>
<% List<String> urls = (List)request.getAttribute("urls");%>
<% for (String url : urls) { %>
<%="<a href=\"" + url + "\" target=\"_blank\">" + url + "</a><br />" %>
<% } %>
</body>
</html>