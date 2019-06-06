<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
div#subContents {
	width: 10%;
	height: 100%;
	background: #F7F7F7;
	padding: 10px;
	position: fixed;
	z-index: 20;
	background: #F7F7F7;
}

* html div#subContents {
	position: absolute;
	top: expression(eval(document.documentElement.scrollTop +100));
}

.main {
	width: 70%;
	margin: 0 auto;
}

.btn_template {
	position: absolute;
	top: 10px;
	left: 930px;
	display: inline-block;
	width: 40px;
	height: 40px;
	text-align: center;
	line-height: 40px;
	border-radius: 50%;
	border: solid 1px black;
	font-size: 150%;
}
</style>

<meta charset="UTF-8">
<title>mailsakusei</title>
</head>
<body>
	<!-- %if(flag = 0){ % -->
	<p>
		<a class="btn_template" href="#">テ</a>
	</p>
	<!--% } %-->

	<h1>G</h1>
	<div id="subContents">
		<ul class="category">
			<li><a href="" title="New">New</a></li>
			<li><a href="" title="受信箱">受信箱</a></li>
			<li><a href="" title="下書き">下書き</a></li>
			<li><a href="" title="送信済み">送信済み</a></li>
			<li><a href="" title="ゴミ箱">ゴミ箱</a></li>
			<!--/ .category-->
		</ul>
		<!--/ #subContents-->
	</div>
	<div class="main">
		<div class="box" id="menu01">
			title<input name="atesaki" type="text"><br> <br>
			from<input name="kenmei" type="text"><br> <br>
			<textarea name="honbun" placeholder="本文を入力してください。" rows="25"
				cols="90"></textarea>
			<br>
			<button type="submit" name="name">送信</button>
			<input type="button" value="戻る" onclick="history.back()">
		</div>
	</div>
</body>
</html>