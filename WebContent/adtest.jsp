<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.SelectTemplateBean" scope="request"/>
<html>
<head>
<meta charset="UTF-8">
<title>テスト用（by安達）</title>
</head>
<body>
宛先<%=bean.getAte() %><br>
内容<%=bean.getNai() %>
</body>
</html>