<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng Nhập Vào Hệ Thống</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f8f8f8;
}

.login-container {
	width: 400px;
	margin: 100px auto;
	background: #fff;
	border: 1px solid #ddd;
	border-radius: 5px;
	padding: 30px;
	box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
}

h2 {
	text-align: center;
	margin-bottom: 20px;
	color: #444;
}

.input-group {
	margin-bottom: 15px;
}

.input-group input {
	width: 100%;
	padding: 10px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

.checkbox-group {
	display: flex;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 15px;
}

.login-btn {
	width: 100%;
	padding: 10px;
	background: #3b8edb;
	border: none;
	border-radius: 3px;
	color: #fff;
	font-size: 16px;
	cursor: pointer;
}

.login-btn:hover {
	background: #337ab7;
}

.register {
	text-align: center;
	margin-top: 15px;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>Đăng Nhập Vào Hệ Thống</h2>
		<form action="/LTWeb02/LoginController" method="post">
			<div class="input-group">
				<input type="text" name="username" placeholder="Tên đăng nhập"
					required>
			</div>
			<div class="input-group">
				<input type="password" name="password" placeholder="Mật khẩu"
					required>
			</div>
			<div class="checkbox-group">
				<label><input type="checkbox" name="remember"> Nhớ
					tôi</label> <a href="forgotPassword.jsp">Quên mật khẩu?</a>
			</div>
			<button type="submit" class="login-btn">Đăng nhập</button>
		</form>
		<div class="register">
			Nếu bạn chưa có tài khoản trên hệ thống, thì hãy <a
				href="register.jsp">Đăng ký</a>
		</div>
	</div>
</body>
</html>
