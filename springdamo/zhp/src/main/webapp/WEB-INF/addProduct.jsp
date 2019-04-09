<%--&lt;%&ndash;--%>
  <%--Created by IntelliJ IDEA.--%>
  <%--User: mac--%>
  <%--Date: 19/3/27--%>
  <%--Time: 下午4:24--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>
<%--</head>--%>
<%--<body>--%>

<%--</body>--%>
<%--</html>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" isELIgnored="false"%>


<div style="margin:0px auto; width:500px">


    <form action="addProduct" method="post">


        name: <input name="pname" value="${p.pname}"> <br>
        name: <input name="price" value="${p.price}"> <br>
        name: <input name="amount" value="${p.amount}"> <br>


        <input name="id" type="hidden" value="${p.id}">
        <button type="submit">提交</button>

    </form>
</div>