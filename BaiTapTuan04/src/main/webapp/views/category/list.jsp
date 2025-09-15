<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý danh mục</title>
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

table {
	width: 100%;
	border-collapse: collapse;
	background: white;
}

table th, table td {
	padding: 10px;
	border: 1px solid #ddd;
	text-align: center;
}

table th {
	background: #2980b9;
	color: white;
}

img {
	width: 50px;
	height: 50px;
	border-radius: 4px;
}

.btn {
	padding: 5px 10px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

.btn-edit {
	background: #f39c12;
	color: white;
}

.btn-delete {
	background: #e74c3c;
	color: white;
}

.btn-add {
	background: #27ae60;
	color: white;
	margin-bottom: 15px;
	display: inline-block;
	padding: 8px 12px;
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
		<h2>Quản lý danh mục</h2>
		<a href="${pageContext.request.contextPath}/views/category/add.jsp"
			class="btn-add">+ Thêm danh mục</a>

		<table>
			<tr>
				<th>ID</th>
				<th>Ảnh</th>
				<th>Tên danh mục</th>
				<th>Hành động</th>
			</tr>
			<c:forEach var="c" items="${list}">
				<tr>
					<td>${c.cateId}</td>
					<td><c:if test="${not empty c.icons}">
							<img src="${pageContext.request.contextPath}/uploads/${c.icons}"
								alt="icon" />
						</c:if></td>
					<td>${c.cateName}</td>
					<td><a
						href="${pageContext.request.contextPath}/category/edit?id=${c.cateId}"
						class="btn btn-edit">Sửa</a> <a
						href="${pageContext.request.contextPath}/category/delete?id=${c.cateId}"
						class="btn btn-delete">Xóa</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>