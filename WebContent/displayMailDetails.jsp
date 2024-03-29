<%@ page contentType="text/html; charset=utf-8" %>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.DisplayMailDetailsBean" scope="request"/>
<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">
<link rel="stylesheet" href="common.css">
<title>メール詳細画面 - G系メール</title>
<meta name="description" content="G系メール">

<style>
	.mail-meta {
		font-size: 90%;
		width: 100%;
		background-color: #FAFAFA;
		border: 1px solid #101010;
		border-bottom: none;
		padding: 8px;
	}
	.mail-body {
		height: 400px;
		background-color: #FAFAFA;
		border: 1px solid #101010;
		padding: 8px;
	}
	.mail-meta-item {
		width: 80px;
	}
	.sidebar-button {
		color: #FAFAFA;
		text-decoration: none;
	}
	#button-return {
	}
	#button-reply {
	}
</style>

</head>

<body>

<div id="header"><div class="inner">
	<p class="non-margin">G系メール（メール詳細画面）</p>
</div></div>

<form id="back_form" action="DisplayMailListServlet">
</form>
<div id="navigation"><div class="inner">
	<img class="logo" src="./logo.png" alt="logo-image" />
	<ul>
		<li><button id="button-return" class="rectangle-button" onclick="back_form.submit()">戻る</button></li>
		<li><button id="button-reply" class="rectangle-button">メール返信</button></li>
	</ul>
</div></div>

<div id="main">
	<div id="section">
		<div class="content"><div class="inner">
			<table class="mail-meta">
				<tr>
					<td class="mail-meta-item">件名</td>
					<td id=><%=bean.getSubject() %></td>
				</tr>
				<tr>
					<td class="mail-meta-item">発信者</td>
					<td id=><%=bean.getFrom() %></td>
				</tr>
				<tr>
					<td class="mail-meta-item">日付</td>
					<td id=><%=bean.getDate() %></td>
				</tr>
			</table>
			<div class="mail-body">
				<span id=><%=bean.getHonbun() %></span>
			</div>
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

<div id="footer"><div class="inner">
	<p class="non-margin">© 2019 アンコちゃんチーム</p>
</div></div>

</body>

</html>


