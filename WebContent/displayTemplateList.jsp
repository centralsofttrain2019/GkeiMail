<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="java.util.Map.Entry" %>
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
	.wide {
		position: absolute;
		top: 0;
		bottom: 0;
		left: 0;
		right: 0;
	}
	#template_form:before {
		content: "";
		display: block;
		padding-top: 100%;
	}
</style>
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

			<form id="template_form" class="clear-fix" method="post" action="CheckTemplateServlet"
					style="position: relative;">
				<label class="common-list-box wide-margin">
					<select class="template-list wide" name="app" size="10" onchange="showPreview(this.value)">
					<% for ( int i = 0; i < bean.getTemplates().size() ; i++  ){%>
					<option value="<%= bean.getTemplates().get(i).getTemplateContent() %>"> <%=bean.getTemplates().get(i).getTemplateName() %></option>
					<%}%>
					</select>
				</label>
			</form>

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

<div id="main">
	<div class="section">
		<div class="content"><div class="inner">
			<label><b>宛先</b></label>
			<label class="common-combo-box">
				<select name="atesaki">
					<option value="0">----</option>
					<% for(Entry<Integer, String> entry: bean.getAddressTypes().entrySet()) { %>
					<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
					<% } %>
				</select>
			</label>

			<label><b>内容</b></label>
			<label class="common-combo-box">
				<select name="naiyou">
					<option value="0">----</option>
					<% for(Entry<Integer, String> entry: bean.getPurposeTypes().entrySet()) { %>
					<option value="<%=entry.getKey() %>"><%=entry.getValue() %></option>
					<% } %>
				</select><br>
			</label>
			<b>その他</b><input name="keyword" type="text" ><br>

			<b>マシマシ</b>
			<label class="common-radio-button">
				<input type="radio" name="mashimashi" value="normal" checked="checked">
				<span>ふつう</span>
				</label>
				<label class="common-radio-button">
				<input type="radio" name="mashimashi" value="hard">
				<span>マシ</span>
				</label>
				<label class="common-radio-button">
				<input type="radio" name="mashimashi" value="extreme">
				<span>マシマシ</span>
				</label>
			<br>


			<label class="common-check-box">
				<b>時候</b>
				<input name="keyword" type="checkbox" >
			</label>
			<br>
			<button class="rounded-rectangle-button" type="submit" name="name" >再検索</button><br>
			</div>
		</div>
	</div>
</div>

<form id="return_form" method="post" action="SelectTemplateServlet">
</form>

<div id="form"><div class="inner">
	<button class="rounded-rectangle-button big-button" type="button" name="submit"
			onclick="javascript:template_form.submit()">
		決定
	</button>
	<button class="rounded-rectangle-button big-button" type="button" name="return"
			onclick="javascript:return_form.submit()">
		戻る
	</button>
</div></div>

<div id="footer"><div class="inner">
	<p class="non-margin">© 2019 アンコちゃんチーム</p>
</div></div>

</body>

</html>
