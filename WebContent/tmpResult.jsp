<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>テンプレート検索結果画面</title>
</head>
<body>

テンプレート一覧
<iframe  name="sample" width="500" height="1000">
この部分はインラインフレームを使用しています。
</iframe>

サンプル
<iframe  name="sample" width="500" height="1000">
この部分はインラインフレームを使用しています。
</iframe>

<label>宛先</label>
<select name="atesaki">
<option value="0">----</option>
<option value="1">社内</option>
<option value="2">取引先</option>
<option value="3">就活生</option>
</select>

<label>内容</label>
<select name="naiyou">
<option value="0">----</option>
<option value="1">連絡</option>
<option value="2">謝罪</option>
<option value="3">感謝</option>
</select>

その他<input name="keyword" type="text" ><br>

<label>マシマシ</label>
ふつう<input type="radio" name="mashimashi" value="normal">
マシ<input type="radio" name="mashimashi" value="hard">
マシマシ<input type="radio" name="mashimashi" value="extreme">


<button type="submit" name="name" >再検索</button>

</body>
</html>