<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="jp.co.central_soft.train2019.wakaba.bean.DisplayMailListBean.MailInformation" %>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.DisplayMailListBean" scope="request" />

<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">
<link rel="stylesheet" href="common.css">
<title>メール一覧表示画面</title>
<meta name="description" content="テストHTML">

<style>
	.mail-list {
		height: 600px;
		background-color: #FAFAFA;
		border: 1px solid #101010;
		padding: 4px;
	}
	.block {
		display: block;
	}
	.non-margin {
		margin: 0;
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
	<p class="non-margin">G系メール(メール一覧表示画面)</p>
</div></div>

<div id="navigation"><div class="inner">
	<img class="logo" src="./logo.png" alt="logo-image" />
	<ul>
		<li><button id="button-new" class="rectangle-button">新規作成</button></li>
		<li><button id="button-trash" class="rectangle-button">ごみ箱</button></li>
	</ul>
	<div class="float-right">
		<form>
			<label class="common-text-box">
				<span>検索</span>
				<input type="text">
			</label>
		</form>
	</div>
</div></div>

<div id="main">
	<div id="section">
		<div class="content"><div class="inner">
			<label class="common-list-box wide-margin block mail-list" style="padding: 0;">
				<select class="mail-list" style="width: 100%;" name="mail-list" size="15">
				<% for(MailInformation entry: bean.getMailInformations()) { %>
				<option value="<%=entry.getId() %>"><%=entry.getJoinedString() %></option>
				<% } %>
				</select>
			</label>

		</div></div>
	</div>
	<div id="sidebar"><div class="inner">
		<ul class="sidebar-menu">
			<li><a class="sidebar-button" href="javascript:void(0)">受信箱</a></li>
			<li><a class="sidebar-button" href="javascript:void(0)">下書き</a></li>
			<li><a class="sidebar-button" href="javascript:void(0)">送信済み</a></li>
		</ul>
	</div></div>
</div>

<div id="footer"><div class="inner">
	<p class="non-margin">© 2019 アンコちゃんチーム</p>
</div></div>

</body>

</html>