<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register form</title>
</head>
<body>
	<form action="/controllerTest/LonginControl?action=register">
		이름<input type="text" name="name">
		비밀번호<input type="password" name="pw">
		학년<input type="text" name="grade">
		전화번호<input type="tel" name="tel">
		이메일<input type="email" name="email">
		<input type="submit" value="제출">
	</form>
</body>
</html>