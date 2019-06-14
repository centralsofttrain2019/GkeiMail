<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Map.Entry" %>
<%@ page import="jp.co.central_soft.train2019.wakaba.dto.PurposeTypeDto" %>
<jsp:useBean id="bean" class="jp.co.central_soft.train2019.wakaba.bean.DisplayTemplateListBean" scope="request" />

<!DOCTYPE html>

<html>

<head>

<meta charset="utf-8">
<link rel="stylesheet" href="common.css">
<title>テンプレート検索結果画面 - G系メール</title>
<meta name="description" content="G系メール">

<style>
	.inline-block {
		display: inline-block;
	}
	.block {
		display: block;
	}
	.template-list {
		width: 100%;
	}
	.keyword-textbox {
		width: 130px;
	}
	.wide-margin {
		margin-top: 10px;
		margin-bottom: 10px;
	}
</style>
<script>
var purposeTypes = {};
<% for (PurposeTypeDto purposeType: bean.getPurList()) { %>
	purposeTypes[<%= purposeType.getPurposeTypeID() %>] = {
		name: '<%=purposeType.getMashiMashiType().getName() %>',
		element1: '<%=purposeType.getMashiMashiType().getElement1() %>',
		element2: '<%=purposeType.getMashiMashiType().getElement2() %>',
		element3: '<%=purposeType.getMashiMashiType().getElement3() %>',
	}
<% } %>
</script>
<script>
var showPreview = function(str){
	var el = document.getElementById("preview");
	el.innerHTML = str;
}
</script>

</head>

<body>

<div id="header"><div class="inner">
	<p class="non-margin">G系メール（テンプレート検索結果）</p>
</div></div>

<div id="main">
	<div class="section">
		<div class="content-half"><div class="inner">
			<h1>テンプレート一覧</h1><br>

			<label class="common-combo-box wide-margin float-right">
				<span>ソート基準</span>
				<select name="sort">
					<option value="0" hidden=></option>
					<option value="1">マシマシ度一致率</option>
				</select>
			</label>

			<form id="template_form" class="clear-fix" method="post" action="CheckTemplateServlet">
				<label class="common-list-box wide-margin block">
					<select class="template-list" name="app" size="10" onchange="showPreview(this.value)">
					<% for ( int i = 0; i < bean.getTemplates().size() ; i++  ){%>
					<option value="<%= bean.getTemplates().get(i).getTemplateContent() %>"> <%=bean.getTemplates().get(i).getTemplateName() %></option>
					<%}%>
					</select>
				</label>
				<input type="hidden" name="atesaki" value="<%=bean.getAtesaki() %>">
				<input type="hidden" name="naiyou" value="<%=bean.getNaiyou() %>">
				<input type="hidden" name="keyword-1" value="<%=bean.getKeyword1() %>">
				<input type="hidden" name="mashimashi" value="<%=bean.getMashimashi() %>">
			</form>

			<hr>

			<label class="common-combo-box">
				<span>宛先</span>
				<select name="atesaki">
					<% for ( int i = 0; i < bean.getAddList().size() ; i++  ){%>
						<option value="<%=i+1 %>"<%if(i == 0){%>selected<%}%>><%=bean.getAddList().get(i).getAddressTypeName() %></option>
					<% } %>
				</select>
			</label>

			<label class="common-combo-box">
				<span>内容</span>
				<select name="naiyou" onchange="mashimashi(this.value)">
					<% for ( int i = 0; i < bean.getPurList().size() ; i++  ){%>
						<option value="<%=i+1 %>"<%if(i == 0){%>selected<%}%>><%=bean.getPurList().get(i).getPurposeTypeName() %></option>
					<% } %>
				</select><br>
			</label>
			<br>

			<label class="">
				<span>その他</span>
				<input name="keyword" type="text">
			</label>
			<br>

			<div>
				<span id="name">マシマシ</span>
				<label class="common-radio-button">
					<input type="radio" name="mashimashi" value="normal" checked="checked">
					<span id="element1">ふつう</span>
				</label>
				<label class="common-radio-button">
					<input type="radio" name="mashimashi" value="hard">
					<span id="element2">マシ</span>
				</label>
				<label class="common-radio-button">
					<input type="radio" name="mashimashi" value="extreme">
					<span id="element3">マシマシ</span>
				</label>
				<script>
						var mashimashi = function(num){
							var el = document.getElementById("name");
							el.innerHTML = purposeTypes[num].name;
							var el = document.getElementById("element1");
							el.innerHTML = purposeTypes[num].element1;
							var el = document.getElementById("element2");
							el.innerHTML = purposeTypes[num].element2;
							var el = document.getElementById("element3");
							el.innerHTML = purposeTypes[num].element3;

						}
				</script>
			</div>

			<label class="common-check-box">
				<span>時候</span>
				<input name="keyword" type="checkbox" >
			</label>
			<br>

			<button class="rounded-rectangle-button" type="submit" name="name" >再検索</button><br>

		</div></div>

		<div class="content-half"><div class="inner">

			<h1>プレビュー</h1>
			<div style="padding: 10px; margin-bottom: 30px; border: 1px solid #333333;">
				<span id="preview">プレビュー</span>
			</div>
			<div style="clear:both;"></div>

		</div></div>
	</div>
</div>


<div id="form"><div class="inner">
	<button class="rounded-rectangle-button big-button" type="button" name="submit"
			onclick="javascript:template_form.submit()">
		決定
	</button>
	<button class="rounded-rectangle-button big-button" type="button" name="return"
			onclick="javascript:return_form.submit()">
		戻る
	</button>

	<form id="return_form" method="post" action="SelectTemplateServlet">
	</form>
</div></div>

<div id="footer"><div class="inner">
	<p class="non-margin">© 2019 アンコちゃんチーム</p>
</div></div>

</body>

</html>
