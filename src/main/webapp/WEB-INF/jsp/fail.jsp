<%--
  Created by IntelliJ IDEA.
  User: yingjiahe
  Date: 2024/4/9
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>操作失败页面</title>
</head>
<body>
<h1><%= session.getAttribute("msg") %></h1>
<h1>操作失败！</h1>
</body>
</html>
