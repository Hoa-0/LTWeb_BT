package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import vn.iotstar.models.Category;
import vn.iotstar.models.UserModels;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet("/category/add")
@MultipartConfig
public class CategoryAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/category/add.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String cateName = req.getParameter("cateName");

		// Xử lý file upload
		Part part = req.getPart("iconFile");
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

		String uploadPath = getServletContext().getRealPath("/uploads");
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}

		if (fileName != null && !fileName.isEmpty()) {
			part.write(uploadPath + File.separator + fileName);
		}

		// Lấy user từ session
		HttpSession session = req.getSession(false);
		UserModels user = (session != null) ? (UserModels) session.getAttribute("account") : null;

		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		// Tạo Category
		Category c = new Category();
		c.setCateName(cateName);
		c.setIcons(fileName); // chỉ lưu tên file
		c.setUserId(user.getId());

		service.insert(c);

		resp.sendRedirect(req.getContextPath() + "/category/list");
	}
}