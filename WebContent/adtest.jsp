<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.SelectTemplateBean" scope="request"/>
<html>
<head>
<meta charset="UTF-8">
<title>テスト用（by安達）</title>
<script src="/GkeiMail/adtest.js"></script>
</head>
<body>
宛先<%=bean.getAtesaki() %><br>
内容<%=bean.getNaiyou() %>
<br>

<select name="app" multiple="multiple" size="3">
<option value="0">項目A</option>
<option value="1">項目B</option>
<option value="2">項目C</option>
</select>

</body>
</html>