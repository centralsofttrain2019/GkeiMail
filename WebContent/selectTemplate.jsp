<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form method="post" action="DispTemplateServlet">

<div id="atesaki">
<label>宛先</label>
<select name="atesaki">
<option value="0">----</option>
<option value="1">社内</option>
<option value="2">取引先</option>
<option value="3">上司</option>
</select>

<label>内容</label>
<select name="naiyou">
<option value="0">----</option>
<option value="1">連絡</option>
<option value="2">謝罪</option>
<option value="3">感謝</option>
</select>
</div>

<label><b>マシマシ</b></label>
ふつう<input type="radio" name="mashimashi" value="normal">
マシ<input type="radio" name="mashimashi" value="hard">
マシマシ<input type="radio" name="mashimashi" value="extreme">

<br>
<input type="submit" value="次へ">

<form method="get" action="">
<input type="submit" value="戻る">
</form>

</body>
</html>