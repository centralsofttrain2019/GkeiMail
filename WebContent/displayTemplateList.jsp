<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map.Entry" %>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.DisplayTemplateListBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テンプレート検索結果画面</title>
</head>
<body>

<div style="float:left;width:200px;">
<b>テンプレート一覧</b><br>
<button type="submit" name="name" >ソート基準</button><br>
<div style="padding: 10px; margin-bottom: 30px; border: 1px solid #333333;">
テンプレートを一覧表示
<form action="Servlet" method="get">
<select name="app" size="3" onChange="submit(this.form)">
<option value="0">項目A</option>
<option value="1">項目B</option>
<option value="2">項目C</option>
</select>
</form>
</div>
 </div>
<div style="float:left;width:200px;">

<b>プレビュー</b>
<div style="padding: 10px; margin-bottom: 30px; border: 1px solid #333333;">
プレビュー画面
</div>
 </div>
<div style="clear:both;"></div>


<label><b>宛先</b></label>

<select name="atesaki">
<option value="0">----</option>
<option value="1">社内</option>
<option value="2">取引先</option>
<option value="3">就活生</option>
<option value="4">上司</option>
<% for(Entry<Integer, String> entry: bean.getAddressTypes().entrySet()) { %>
<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
<% } %>
</select>

<label><b>内容</b></label>
<select name="naiyou">
<option value="0">----</option>
<option value="1">連絡</option>
<option value="2">謝罪</option>
<option value="3">感謝</option>
<% for(Entry<Integer, String> entry: bean.getPurposeTypes().entrySet()) { %>
<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
<% } %>
</select><br>

<b>その他</b><input name="keyword" type="text" ><br>

<label><b>マシマシ</b></label>
ふつう<input type="radio" name="mashimashi" value="normal">
マシ<input type="radio" name="mashimashi" value="hard">
マシマシ<input type="radio" name="mashimashi" value="extreme">
<br>

<b>時候</b><input name="keyword" type="checkbox" ><br>

<button type="submit" name="name" >再検索</button><br>
<button type="submit" name="name" >決定</button>
<button type="submit" name="name" >戻る</button><br>

<%=bean.toString() %>
</body>
</html>