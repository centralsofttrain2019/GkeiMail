<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="common.css">
<title>ログイン画面 - G系メール</title>
<meta name="description" content="G系メール">
<meta charset="utf-8">
<style>
.margin-tate {
	margin-top: 4em;
	margin-bottom: 4em;
}
ul {
	margin-left: auto;
	margin-right: auto;
}
ul li {
    list-style: none;
}
label {
	    margin-right: 10px;
	    width:150px;
	    float: left;
	}
</style>
</head>
<body>

<div id="header"><div class="inner">
	<p class="non-margin">G系メール（ログイン画面）</p>
</div></div>

<div id="main">
	<div class="section">
		<div class="content"><div class="inner">
		    <p>ログインに失敗しました！</p>
			<p>正しいIDとパスワードを入力してください。</p>
			<form id="login_form" class="align-left margin-tate" method="post" action="LoginServlet">
				<ul>
				<li><label>ユーザ名:</label><input name="userName" size="30"></li>
				<li><label>パスワード:</label><input name="password" type="password" size="30"></li>
				</ul>
			</form>
		</div></div>
	</div>
</div>

<div id="form"><div class="inner">
	<button class="rounded-rectangle-button big-button" type="button" name="submit"
			onclick="javascript:login_form.submit()">
		ログイン
	</button>
</div></div>

<div id="footer"><div class="inner">
	<p class="non-margin">© 2019 アンコちゃんチーム</p>
</div></div>
</body>
</html>