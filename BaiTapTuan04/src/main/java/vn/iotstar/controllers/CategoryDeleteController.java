package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet("/category/delete")
public class CategoryDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		if (id != null) {
			service.delete(Integer.parseInt(id));
		}
		resp.sendRedirect(req.getContextPath() + "/category/list");
	}
}