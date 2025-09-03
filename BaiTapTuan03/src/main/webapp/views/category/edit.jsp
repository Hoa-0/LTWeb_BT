<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<html>
<head>
<title>Sửa danh mục</title>
</head>
<body>
	<h2>Sửa danh mục</h2>
	<form action="${pageContext.request.contextPath}/category/edit"
		method="post" enctype="multipart/form-data">
		<input type="hidden" name="cateId" value="${cate.cateId}" /> <label>Tên
			danh mục:</label> <input type="text" name="cateName" value="${cate.cateName}"
			required /><br />
		<br /> <label>Ảnh hiện tại:</label>
		<c:if test="${not empty cate.icons}">
			<img src="${pageContext.request.contextPath}/uploads/${cate.icons}"
				alt="icon" width="80" height="80" />
		</c:if>
		<br /> <label>Chọn ảnh mới (nếu muốn đổi):</label> <input type="file"
			name="iconFile" accept="image/*" /><br />
		<br />

		<button type="submit">Cập nhật</button>
	</form>
</body>
</html>
