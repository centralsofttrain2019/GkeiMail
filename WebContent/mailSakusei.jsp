<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="mailSakusei.css">
<meta charset="UTF-8">
<title>mailsakusei</title>
</head>
<body>
<p><a class="btn_template" href="#">テ</a></p>
<h1>G</h1>
	<div id="subContents">
		<ul class="category">

			<li><a href="" title="受信箱">受信箱</a></li>
			<li><a href="" title="下書き">下書き</a></li>
			<li><a href="" title="送信済み">送信済み</a></li>
			<li><a href="" title="ゴミ箱">ゴミ箱</a> </li>
			<!--/ .category-->
		</ul>
		<!--/ #subContents-->
	</div>
	<div class="main">
		<div class="box" id="menu01">
			title<input name="atesaki" type="text"><br> <br>
			from<input name="kenmei" type="text"><br> <br>
			<textarea name="honbun" placeholder="本文を入力してください。" rows="25" cols="90"></textarea>
			<br>
			<button type="submit" name="name">送信</button>
			<input type="button" value="戻る" onclick="history.back()">
		</div>
	</div>
</body>
</html>