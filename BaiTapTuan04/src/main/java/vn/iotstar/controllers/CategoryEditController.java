package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import vn.iotstar.models.Category;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet("/category/edit")
@MultipartConfig
public class CategoryEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Category cate = service.findById(id);
		req.setAttribute("cate", cate);
		req.getRequestDispatcher("/views/category/edit.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		int cateId = Integer.parseInt(req.getParameter("cateId"));
		String cateName = req.getParameter("cateName");

		Category cate = service.findById(cateId);

		Part part = req.getPart("iconFile");
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

		if (fileName != null && !fileName.isEmpty()) {
			String uploadPath = getServletContext().getRealPath("/uploads");
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdir();

			part.write(uploadPath + File.separator + fileName);
			cate.setIcons(fileName);
		}

		cate.setCateName(cateName);

		service.update(cate);
		resp.sendRedirect(req.getContextPath() + "/category/list");
	}
}