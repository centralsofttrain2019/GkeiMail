<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map.Entry" %>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.SelectTemplateBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テンプレート選択画面</title>
<link rel="stylesheet" type="text/css" href="/GkeiMail/selectTemplateStyle.css">
</head>
<body>
<h2 id="title">テンプレート選択画面</h2>
<hr>
<form method="post" action="DisplayTemplateListServlet">

<div id="atesaki">
<label>宛先</label>

<select name="atesaki">
<option value="1">----</option>
<% for(Entry<Integer, String> entry: bean.getAddressTypes().entrySet()) { %>
<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
<% } %>
</select>

<label><b>内容</b></label>

<select name="naiyou">
<option value="1">----</option>
<% for(Entry<Integer, String> entry: bean.getPurposeTypes().entrySet()) { %>
<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
<% } %>
</select>
</div>
その他<input name="keyword" type="text" ><br>
<label><b>マシマシ</b></label>
ふつう<input type="radio" name="mashimashi" value="1">
マシ<input type="radio" name="mashimashi" value="2">
マシマシ<input type="radio" name="mashimashi" value="3">

<br>
<input type="submit" value="次へ">
</form>

<form method="get" action="">
<input type="submit" value="戻る">
</form>

</body>
</html>