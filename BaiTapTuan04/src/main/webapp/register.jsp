<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ĐĂNG KÝ TÀI KHOẢN</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f7f7f7;
}

.form-container {
	width: 350px;
	margin: 50px auto;
	background: #fff;
	padding: 20px;
	border-radius: 6px;
	box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.1);
}

.form-container h2 {
	text-align: center;
	margin-bottom: 20px;
}

.form-container input {
	width: 100%;
	padding: 10px;
	margin: 8px 0;
	border: 1px solid #ccc;
	border-radius: 4px;
}

.form-container button {
	width: 100%;
	padding: 10px;
	background-color: #007bff;
	color: white;
	border: none;
	border-radius: 4px;
	font-size: 16px;
	cursor: pointer;
}

.form-container button:hover {
	background-color: #0056b3;
}

.form-container .footer {
	text-align: center;
	margin-top: 15px;
}

.form-container .footer a {
	color: #007bff;
	text-decoration: none;
}

.error {
	color: red;
	text-align: center;
	margin-bottom: 10px;
}

.success {
	color: green;
	text-align: center;
	margin-bottom: 10px;
}
</style>
</head>
<body>

	<div class="form-container">
		<h2>ĐĂNG KÝ TÀI KHOẢN</h2>

		<!-- Hiển thị thông báo lỗi -->
		<c:if test="${not empty error}">
			<p class="error">${error}</p>
		</c:if>

		<!-- Hiển thị thông báo thành công -->
		<c:if test="${not empty success}">
			<p class="success">${success}</p>
		</c:if>

		<form action="${pageContext.request.contextPath}/register"
			method="post">
			<input type="text" name="username" placeholder="Tên đăng nhập"
				required> <input type="text" name="fullname"
				placeholder="Họ tên" required> <input type="email"
				name="email" placeholder="Nhập Email" required> <input
				type="tel" name="phone" placeholder="Số điện thoại" required>
			<input type="password" name="password" placeholder="Mật khẩu"
				required> <input type="password" name="confirmPassword"
				placeholder="Nhập lại mật khẩu" required>
			<button type="submit">Đăng Ký</button>
		</form>
	</div>
</body>
</html>