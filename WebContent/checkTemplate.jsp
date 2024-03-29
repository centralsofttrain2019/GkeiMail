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
							style="text-align: left; overflow: scroll; display: inline-block; background: white; width: 80%; height: 500px; padding: 15px; border: 1px solid; border-radius: 10px; word-break: break-all;">
							<pre>
							<%=bean.getTemplateContent()%>
							</pre>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<form id="OK_form" action="CreateMailServlet" method="post">
		<input type="hidden" name="fromPage" value="template">
		<input type="hidden" name="content" value="<%=bean.getTemplateContent() %>">
	</form>

	<form id="NO_form" action="DisplayTemplateListServlet" method="post">
<!-- 		DisplayTemplateListServletの呼び出し -->
<!-- 		そのために宛先や内容の値を再入力しています -->
		<input name="atesaki" value="<%=bean.getAtesaki() %>" style="display: none">
		<input name="naiyou" value="<%=bean.getNaiyou() %>" style="display: none">
		<input name="keyword-1" value="<%=bean.getKeyword1() %>" style="display: none">
		<input name="mashimashi" value="<%=bean.getMashimashi() %>" style="display: none">
	</form>
	<div id="form">
		<div class="inner">
			<div class="align-left inline-block">
				<button class="rounded-rectangle-button big-button" type="button"
					name="ok" value="ok"
					onclick="javascript:OK_form.submit()">
					確定</button>

				<button class="rounded-rectangle-button big-button" type="button"
					name="no" value="no"
					onclick="javascript:NO_form.submit()">
					やり直す
				</button>
			</div>
			<div style="text-align: right;">
				<button class="rounded-rectangle-button"  type="submit" name="iine">☆いいね</button>
			</div>
		</div>
	</div>
</body>
</html>