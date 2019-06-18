<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.DisplayTemplateListBean" scope="request" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
function load() {
  alert("宛先:(<%= bean.getAddList().get(bean.getAtesaki()-1).getAddressTypeName() %>)   内容:(<%= bean.getPurList().get(bean.getNaiyou()-1).getPurposeTypeName() %>)\nの検索結果はありません");
  location.href = "http://localhost:8080/GkeiMail/SelectTemplateServlet";
}

window.onload = load;


</script>

</body>
</html>