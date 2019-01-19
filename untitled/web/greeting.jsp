<%--
  Created by IntelliJ IDEA.
  User: mac
  Date: 19/1/17
  Time: 下午8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Java static page example</title>
</head>
<body>
<h1>Java static page example</h1>
<%
    String[] arr = {
            "What's up","hello","It's a nice day today"
    };
    String greeting = arr[(int)(Math.random()*arr.length)];
%>
<p><%= greeting %></p>
</body>
</html>
