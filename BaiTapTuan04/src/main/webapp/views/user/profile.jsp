v<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="vn.iotstar.models.UserModels"%>
<%
UserModels user = (UserModels) session.getAttribute("account");
if (user == null) {
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	return;
}
%>
<div class="container mt-4">
	<h2>Hồ sơ cá nhân</h2>
	<form method="post" action="${pageContext.request.contextPath}/profile"
		enctype="multipart/form-data">
		<div class="mb-3">
			<label>Họ và tên:</label> <input type="text" name="fullname"
				class="form-control" value="<%=user.getFullName()%>" required />
		</div>
		<div class="mb-3">
			<label>Số điện thoại:</label> <input type="text" name="phone"
				class="form-control" value="<%=user.getPhone()%>" required />
		</div>
		<div class="mb-3">
			<label>Ảnh đại diện:</label><br /> <img
				src="<%=request.getContextPath()%>/resources/images/<%=user.getImage()%>"
				class="rounded-circle mb-2" width="80" alt="Avatar" /><br /> <input
				type="file" name="image" accept="image/*" class="form-control" />
		</div>
		<button type="submit" class="btn btn-success">Lưu thay đổi</button>
	</form>
</div>
