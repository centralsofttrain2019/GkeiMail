<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.CheckTemplateBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テンプレート生成確認画面</title>
</head>
<body>
<form method="post" action="CreateMailServlet">
このテンプレートでよろしいですか？<br>
<div style="text-align:center">
<div style="display:inline-block; text-align:center; padding:15px; border:1px solid; border-radius:10px; word-break:break-all;">
<%= bean.getTemplateContent() %></div>
<p>
<button type="button" name="ok" value="ok" >OK</button>
<button type="button" name="no" value="no" >やり直す</button>
</p>
</div>
<button type="submit" name="iine">☆いいね</button>
</form>

</body>
</html>