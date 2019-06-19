<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto" %>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.SelectTemplateBean" scope="request" />

<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<link rel="stylesheet" href="common.css">
<title>テンプレート選択画面 - G系メール</title>
<meta name="description" content="G系メール">

<style>
	.inline-block {
		display: inline-block;
	}
	.type-list {
		width: 200px;
		margin-right: 20px;
	}
	.type-list-last {
		margin-right: 0;
	}
	.keyword-textbox {
		width: 130px;
	}
	.wide-margin {
		margin-top: 10px;
		margin-bottom: 10px;
	}
	#template_form {
		font-size: 125%;
	}
	#template_form .span-narrow {
		display: inline-block;
		width: 60px;
	}
	#template_form .span-wide {
		display: inline-block;
		width: 120px;
	}
</style>

<script>
var purposeTypes = {};
<% for (PurposeTypeDto purposeType: bean.getPurList()) { %>
	purposeTypes[<%= purposeType.getPurposeTypeID() %>] = {
		name: '<%=purposeType.getMashiMashiType().getName() %>',
		description: '<%=purposeType.getMashiMashiType().getDescription() %>',
		element1: '<%=purposeType.getMashiMashiType().getElement1() %>',
		element2: '<%=purposeType.getMashiMashiType().getElement2() %>',
		element3: '<%=purposeType.getMashiMashiType().getElement3() %>',
	}
<% } %>
</script>

</head>
<body>

<div id="header"><div class="inner">
	<p class="non-margin">G系メール（テンプレート選択）</p>
</div></div>

<div id="main">
	<div class="section">
		<div class="content"><div class="inner">
			<h1>テンプレート選択</h1>
			<div class="align-center">
				<!-- <form id="template_form" class="align-left inline-block" method="post" action="test"> -->
				<form id="template_form" class="align-left inline-block" method="post" action="DisplayTemplateListServlet">
					<label class="common-list-box wide-margin">
						<span class="span-narrow">宛先</span>
						<select class="type-list" name="atesaki" size="8">
							<% for ( int i = 0; i < bean.getAddList().size() ; i++  ){%>
							<option value="<%=i+1 %>"<%if(i == 0){%>selected<%}%>><%=bean.getAddList().get(i).getAddressTypeName() %></option>
							<% } %>
							<%-- <% for(Entry<Integer, String> entry: bean.getAddressTypes().entrySet()) { %>
							<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
							<% } %> --%>
						</select>
					</label>

					<label class="common-list-box wide-margin">

						<span class="span-narrow">内容</span>
						<select class="type-list type-list-last" name="naiyou" size="8" onchange="hoge(this.value)">
							<% for ( int i = 0; i < bean.getPurList().size() ; i++  ){%>
							<option value="<%=i+1 %>"<%if(i == 0){%>selected<%}%>><%=bean.getPurList().get(i).getPurposeTypeName() %></option>
							<% } %>

<%-- 							<% for(Entry<Integer, String> entry: bean.getPurposeTypes().entrySet()) { %> --%>
<%-- 							<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option> --%>
<%-- 							<% } %> --%>
						</select>
					</label>

					<br>

					<label class="common-text-box wide-margin">
						<span class="span-wide">その他</span>
						<input class="keyword-textbox" type="text" name="keyword-1">
						<input class="keyword-textbox" type="text" name="keyword-2">
						<input class="keyword-textbox" type="text" name="keyword-3">
					</label>

					<br>

					<div class="inline-block wide-margin">
						<span class="span-wide" id="preview">
						<%=bean.getPurList().get(0).getMashiMashiType().getName() %>
						</span>

						<label class="common-radio-button">
							<input type="radio" name="mashimashi" value="1" checked="checked">
							<span id ="element1"><%=bean.getPurList().get(0).getMashiMashiType().getElement1() %></span>

						</label>
						<label class="common-radio-button">
							<input type="radio" name="mashimashi" value="2">
							<span id ="element2"><%=bean.getPurList().get(0).getMashiMashiType().getElement2() %></span>

						</label>
						<label class="common-radio-button">
							<input type="radio" name="mashimashi" value="3">
							<span id ="element3"><%=bean.getPurList().get(0).getMashiMashiType().getElement3() %></span>

						</label>

						<br>
						<span class="span-wide" id="description">
						<%=bean.getPurList().get(0).getMashiMashiType().getDescription() %>
						</span>


						<script>
						var hoge = function(num){
							var el = document.getElementById("preview");
							el.innerHTML = purposeTypes[num].name;
							var el = document.getElementById("description");
							el.innerHTML = purposeTypes[num].description;
							var el = document.getElementById("element1");
							el.innerHTML = purposeTypes[num].element1;
							var el = document.getElementById("element2");
							el.innerHTML = purposeTypes[num].element2;
							var el = document.getElementById("element3");
							el.innerHTML = purposeTypes[num].element3;

						}
						</script>
					</div>

					<br>

					<div class="inline-block wide-margin">
						<span class="span-wide">時候</span>
						<label class="common-check-box">
							<input type="checkbox" name="jikou">
						</label>
					</div>
				</form>
			</div>
		</div></div>
	</div>
</div>

<div id="form"><div class="inner">
	<button class="rounded-rectangle-button big-button" type="button" name="submit"
			onclick="javascript:template_form.submit()">
		検索
	</button>
</div></div>

<div id="footer"><div class="inner">
	<p class="non-margin">© 2019 アンコちゃんチーム</p>
</div></div>

</body>
</html>