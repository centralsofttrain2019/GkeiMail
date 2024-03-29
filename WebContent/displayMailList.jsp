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

<form id="createMailForm" action="CreateMailServlet">
<input type="hidden" name="fromPage" value="create"></form>

<div id="navigation"><div class="inner">
	<img class="logo" src="./logo.png" alt="logo-image" />
	<ul>
		<li><button id="button-new" class="rectangle-button" onclick="createMailForm.submit()">新規作成</button></li>
		<li><button id="button-trash" class="rectangle-button" onclick="document.location='DisplayMailListServlet?folder=TRASH'">ごみ箱</button></li>
		<li><button id="button-update" class="rectangle-button" onClick="document.location='DisplayMailListServlet';">更新</button></li>
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
	<form method="POST" action="DisplayMailDetailsServlet" id="list_form">
	<div id="section">
		<div class="content"><div class="inner">
			<label class="common-list-box wide-margin block" style="padding: 0;">
				<span>[<%=bean.getFolder() %>] 件名 / 発信者 / 日付</span>
				<select class="mail-list" style="width: 100%;" name="mail-list" size="15" ondblclick ="javascript:list_form.submit()">
				<% for(MailInformation entry: bean.getMailInformations()) { %>
				<option value="<%=entry.getId() %>"><%=entry.getJoinedString() %></option>
				<% } %>
				</select>

			</label>

		</div></div>

	</div>
	</form>
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