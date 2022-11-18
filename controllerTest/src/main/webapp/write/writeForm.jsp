<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>KH Today :: write</title>
</head>
<body>
	<form method="post" action="/WriteProcess">
		제목<input type="text" name="title">
		<input type="text" name="context">
		<input type="submit" value="발행">
	</form>
</body>
</html>