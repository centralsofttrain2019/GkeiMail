<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map.Entry" %>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.DispTemplateBean" scope="request" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テンプレート検索結果画面</title>
</head>
<body>

<div style="float:left;width:200px;">
<b>テンプレート一覧表示</b>
<div style="padding: 100px; margin-bottom: 30px; border: 1px solid #333333;">
あああああああああああ
</div>
 </div>
<div style="float:left;width:200px;">

<b>サンプル</b>
<div style="padding: 100px; margin-bottom: 30px; border: 1px solid #333333;">
</div>
 </div>
<div style="clear:both;"></div>


<label><b>宛先</b></label>

<select name="atesaki">
<option value="0">----</option>
<% for(Entry<Integer, String> entry: bean.getAddressTypes().entrySet()) { %>
<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
<% } %>
</select>

<label><b>内容</b></label>
<select name="naiyou">
<option value="0">----</option>
<% for(Entry<Integer, String> entry: bean.getPurposeTypes().entrySet()) { %>
<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
<% } %>
</select><br>

<b>その他</b><input name="keyword" type="text" ><br>

<label><b>マシマシ</b></label>
ふつう<input type="radio" name="mashimashi" value="normal">
マシ<input type="radio" name="mashimashi" value="hard">
マシマシ<input type="radio" name="mashimashi" value="extreme">

<button type="submit" name="name" >再検索</button><br>
<button type="submit" name="name" >戻る</button><br>

</body>
</html>