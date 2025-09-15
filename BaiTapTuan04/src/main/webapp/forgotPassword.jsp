<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quên mật khẩu</title>
</head>
<body>
	<h2>Quên mật khẩu</h2>
	<form action="${pageContext.request.contextPath}/forgot" method="post">
		<input type="text" name="username" placeholder="Tên đăng nhập"
			required />
		<button type="submit">Lấy lại mật khẩu</button>
	</form>
	<c:if test="${not empty alert}">
		<p style="color: red">${alert}</p>
	</c:if>
</body>
</html>