<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vn.iotstar.models.UserModels"%>
<%
UserModels user = (UserModels) session.getAttribute("account");
if (user == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return;
}
%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
<style>
body {
	font-family: Arial, sans-serif;
	background: #f4f6f9;
	margin: 0;
	padding: 0;
}

.navbar {
	background: #007bff;
	padding: 15px;
	color: #fff;
	font-size: 18px;
}

.container {
	max-width: 900px;
	margin: 30px auto;
	padding: 20px;
}

.card {
	background: #fff;
	border-radius: 8px;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
	padding: 20px;
	margin-bottom: 20px;
}

h2 {
	margin-top: 0;
	color: #333;
}

.btn {
	display: inline-block;
	padding: 10px 15px;
	margin: 5px;
	border-radius: 5px;
	text-decoration: none;
	color: #fff;
	background: #007bff;
	transition: background 0.3s;
}

.btn:hover {
	background: #0056b3;
}

.info p {
	margin: 6px 0;
	font-size: 16px;
}
</style>
</head>
<body>
	<div class="navbar">
		Xin chào,
		<%=user.getFullName()%>
		👋
	</div>
	<div class="container">
		<div class="card info">
			<h2>Thông tin tài khoản</h2>
			<p>
				<strong>Email:</strong>
				<%=user.getEmail()%></p>
			<p>
				<strong>Số điện thoại:</strong>
				<%=user.getPhone()%></p>
		</div>

		<div class="card">
			<h2>Chức năng</h2>
			<a href="<%=request.getContextPath()%>/category/list" class="btn">📂
				Quản lý Danh mục</a> <a href="<%=request.getContextPath()%>/logout"
				class="btn" style="background: #dc3545">🚪 Đăng xuất</a>
		</div>
	</div>
</body>
</html>
