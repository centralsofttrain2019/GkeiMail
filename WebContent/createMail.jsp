<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.CreateMailBean" scope="request"/>
<html>
<head>
<link rel="stylesheet" href="common.css">
<style>

.non-margin {
	margin: 0;
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
.sidebar-button {
	color: #FAFAFA;
	text-decoration: none;
}
.temp {
	word-break: keep-all;
	font-size: 70%;
}
</style>
<script>
window.onload = function(){
	if(<%=bean.isFlag()%>){
		window.alert("件名または本文を入れてください");
	}
}
</script>
<meta charset="UTF-8">
<meta name="description" content="G系メール">
<title>メール作成画面</title>
</head>
<body>
	<div id="header">
		<div class="inner">
		<p class="non-margin">G系メール(メール作成画面)</p>
		</div>
	</div>
	<div id="navigation"><div class="inner">
	<img class="logo" src="./logo.png" alt="logo-image" />
	<ul>
		<li><form id="return" action="DisplayMailListServlet" method="post">
		<button id="button-return" class="rectangle-button">戻る</button></form></li>
		<li>
		<button id="button-send" class="rectangle-button" onclick="javascript:send_form.submit()">メール送信</button>
		</li>
		<li><form id="selectTemplate" action="SelectTemplateServlet" method="post">
		<button id="select-template" class="rectangle-button temp" onclick="javascript:selectTemplate.submit()">
		<%=bean.getTemplateBottonLabel()%></button></form></li>
	</ul>
	</div></div>

	<div id="main">
		<div id="section">
			<div class="content"><div class="inner">
				<form id="send_form" action="CreateMailServlet" method="post">
				宛先<input name="atesaki" type="text" size="80"><br> <br>
				件名<input name="kenmei" type="text" size="80"><br> <br>
				<textarea name="honbun" placeholder="本文を入力してください。" rows="25"
					cols="90"><%if(bean.getContent() != null) {%><%=bean.getContent() %><% } %></textarea>
				<br>
					<input style="display: none;" name="fromPage" value="send">
				</form>
			</div></div>
		</div>
		<div id="sidebar"><div class="inner">
			<ul class="sidebar-menu">
				<li><a href="DisplayMailListServlet?folder=INBOX" class="sidebar-button">受信箱</a></li>
				<li><a href="DisplayMailListServlet?folder=DRAFTS" class="sidebar-button">下書き</a></li>
				<li><a href="DisplayMailListServlet?folder=SENT" class="sidebar-button">送信済み</a></li>
			</ul>
		</div></div>
	</div>

	<div id="footer">
		<div class="inner">
		<p class="non-margin">© 2019 アンコちゃんチーム</p>
		</div>
	</div>
</body>
</html>