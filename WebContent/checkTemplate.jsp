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
このテンプレートでよろしいですか？
<div style="display:inline-block; padding:15px; border:1px solid; border-radius:10px; word-break:break-all;">
<%! %></div>
<button type="submit" name="name" >OK</button>
<button type="submit" name="name" >やり直し</button>
<br>

</body>
</html>