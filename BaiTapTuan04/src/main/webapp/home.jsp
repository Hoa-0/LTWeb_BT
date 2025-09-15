<%@ page import="vn.iotstar.models.UserModels" language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserModels user = (UserModels) session.getAttribute("account");
if (user == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return;
}
%>
<div class="card">
	<h2 class="card-header">Thông tin tài khoản</h2>
	<div class="card-body">
		<p>
			<strong>Tên đăng nhập:</strong>
			<%=user.getUsername()%></p>
		<p>
			<strong>Email:</strong>
			<%=user.getEmail()%></p>
		<p>
			<strong>Họ và tên:</strong>
			<%=user.getFullName()%></p>
		<p>
			<strong>Số điện thoại:</strong>
			<%=user.getPhone()%></p>
	</div>
</div>
<div class="card mt-4">
	<h2 class="card-header">Chức năng</h2>
	<div class="card-body">
		<a href="<%=request.getContextPath()%>/category/list"
			class="btn btn-primary">📂 Quản lý Danh mục</a> <a
			href="<%=request.getContextPath()%>/logout" class="btn btn-danger">🚪
			Đăng xuất</a>
	</div>
</div>
