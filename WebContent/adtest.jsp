<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.DispTemplateBean" scope="request"/>
<jsp:useBean id="bean1" class="jp.co.central_soft.train2019.wakaba.bean.Bean" scope="request"/>

<html>
<head>
<meta charset="UTF-8">
<title>テスト用（by安達）</title>
</head>
<body>
<br>

<form action="Servlet" method="get">
<select name="app" size="3" onChange="submit(this.form)">
<option value="0">項目A</option>
<option value="1">項目B</option>
<option value="2">項目C</option>
</select>
</form>
<%=bean1.getName() %>
</body>
</html>