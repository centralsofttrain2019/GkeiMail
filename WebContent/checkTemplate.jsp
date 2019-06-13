<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:useBean id="bean"
	class="jp.co.central_soft.train2019.wakaba.bean.CheckTemplateBean"
	scope="request" />
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="common.css">
<meta charset="UTF-8">
<title>テンプレート生成確認画面</title>
<style>
.inline-block {
	display: inline-block;
}

.width-fixed-list {
	width: 200px;
}
</style>
</head>

<body>
	<div id="header">
		<div class="inner">
			<p class="non-margin">G系メール</p>
		</div>
	</div>
	<div id="main">
		<div class="section">
			<div class="content">
				<div class="inner">
					<h1>テンプレート選択</h1>
					<div style="text-align: center;">
						<div
							style="display: inline-block; background: white; width: 80%; height: 500px; padding: 15px; border: 1px solid; border-radius: 10px; word-break: break-all;">
							<%=bean.getTemplateContent()%></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="form">
		<div class="inner">
			<div>
			<form action="CreateMailServlet" method="post">
				<button class="rounded-rectangle-button big-button" type="submit"
					name="ok" value="ok">OK</button>
			</form>
			<form action="DisplayTemplateListServlet" method="post">
				<button class="rounded-rectangle-button big-button" type="submit"
					name="no" value="no">やり直す</button>
			</form>
			</div>
			<div style="text-align: right;">
				<button class="rounded-rectangle-button"  type="submit" name="iine">☆いいね</button>
			</div>
		</div>
	</div>

</body>
</html>