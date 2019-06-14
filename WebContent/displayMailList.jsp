<%@ page contentType="text/html; charset=utf-8" %>

<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">
<link rel="stylesheet" href="common.css">
<title>メール表示一覧画面</title>
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
</style>

</head>

<body>

<div id="header"><div class="inner">
	<p class="non-margin">G系メール(メール一覧表示画面)</p>
</div></div>

<div id="navigation"><div class="inner">
	<img class="logo" src="./logo.png" alt="logo-image" />
	<ul>
		<li><button class="rounded-rectangle-button">新規作成</button></li>
		<li><button class="rounded-rectangle-button">ごみ箱</button></li>
	</ul>
	<div class="float-right">
		<form>
			<label class="common-text-box">
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
				<option value="0">項目A</option>
				<option value="1">項目B</option>
				<option value="2">項目C</option>
				</select>
			</label>

		</div></div>
	</div>
	<div id="sidebar"><div class="inner">
		<ul class="sidebar-menu">
			<li>受信箱</li>
			<li>下書き</li>
			<li>送信済み</li>
		</ul>
	</div></div>
</div>

<div id="footer"><div class="inner">
	<p class="non-margin">Copyrightアンコちゃん</p>
</div></div>

</body>

</html>