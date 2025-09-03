<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm danh mục</title>
<style>
body {
	margin: 0;
	font-family: Arial, sans-serif;
	background: #f4f4f4;
}

.sidebar {
	width: 220px;
	height: 100vh;
	background: #2c3e50;
	color: white;
	position: fixed;
	top: 0;
	left: 0;
	padding-top: 20px;
}

.sidebar h2 {
	text-align: center;
	margin-bottom: 30px;
}

.sidebar a {
	display: block;
	color: white;
	padding: 10px 20px;
	text-decoration: none;
}

.sidebar a:hover {
	background: #34495e;
}

.main {
	margin-left: 220px;
	padding: 20px;
}

form {
	background: white;
	padding: 20px;
	border-radius: 6px;
}

label {
	display: block;
	margin: 10px 0 5px;
}

input[type="text"], input[type="file"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #ccc;
	border-radius: 4px;
}

button {
	margin-top: 10px;
	padding: 10px 15px;
	background: #27ae60;
	border: none;
	border-radius: 4px;
	color: white;
	cursor: pointer;
}

button:hover {
	background: #2ecc71;
}
</style>
</head>
<body>
	<!-- Sidebar -->
	<div class="sidebar">
		<h2>Dashboard</h2>
		<a href="${pageContext.request.contextPath}/home.jsp">Trang chủ</a> <a
			href="${pageContext.request.contextPath}/category/list">Quản lý
			Danh mục</a> <a href="${pageContext.request.contextPath}/logout">Đăng
			xuất</a>
	</div>

	<!-- Nội dung chính -->
	<div class="main">
		<h2>Thêm danh mục</h2>
		<form action="${pageContext.request.contextPath}/category/add"
			method="post" enctype="multipart/form-data">
			<label for="cateName">Tên danh mục:</label> <input type="text"
				id="cateName" name="cateName" required /> <label for="iconFile">Ảnh
				đại diện:</label> <input type="file" id="iconFile" name="iconFile"
				accept="image/*" />

			<button type="submit">Thêm</button>
		</form>
	</div>
</body>
</html>
