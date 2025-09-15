<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	import="vn.iotstar.models.UserModels"%>
<%-- Đọc thông tin user từ session để hiển thị ở header --%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<%
UserModels user = (UserModels) session.getAttribute("account");
%>
<!DOCTYPE html>
<html lang="vi">
<head>
<meta charset="UTF-8">
<title><sitemesh:write property="title" /></title>
<!-- Liên kết CSS Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Cho phép chèn thêm <head> từ trang con -->
<sitemesh:write property="head" />
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/home.jsp">MyShop</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/home.jsp">Trang chủ</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/category/list">Danh mục</a></li>
					<li class="nav-item"><a class="nav-link"
						href="<%=request.getContextPath()%>/product/list">Sản phẩm</a></li>
				</ul>
				<ul class="navbar-nav ms-auto">
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle d-flex align-items-center"
						href="#" id="userMenu" role="button" data-bs-toggle="dropdown">
							<img
							src="<%=request.getContextPath()%>/resources/images/<%=user.getImage()%>"
							class="rounded-circle" width="30" height="30" alt="Avatar" /> <span
							class="ms-2"><%=user.getFullName()%></span>
					</a>
						<ul class="dropdown-menu dropdown-menu-end">
							<li><a class="dropdown-item"
								href="<%=request.getContextPath()%>/profile">Hồ sơ cá nhân</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item text-danger"
								href="<%=request.getContextPath()%>/logout">Đăng xuất</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- NỘI DUNG TRANG CON ĐƯỢC CHÉP VÀO ĐÂY -->
	<div class="container mt-4">
		<sitemesh:write property="body" />
	</div>

	<!-- Footer chung -->
	<footer class="bg-light text-center py-3 mt-4"> MyShop © 2025
	</footer>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
