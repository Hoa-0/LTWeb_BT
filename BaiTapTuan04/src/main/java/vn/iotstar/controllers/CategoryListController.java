package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import vn.iotstar.models.Category;
import vn.iotstar.models.UserModels;
import vn.iotstar.services.CategoryService;
import vn.iotstar.services.impl.CategoryServiceImpl;

@WebServlet("/category/list")
public class CategoryListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CategoryService service = new CategoryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		UserModels user = (session != null) ? (UserModels) session.getAttribute("account") : null;

		if (user == null) {
			resp.sendRedirect(req.getContextPath() + "/login.jsp");
			return;
		}

		List<Category> list = service.findByUser(user.getId());
		req.setAttribute("list", list);

		req.getRequestDispatcher("/views/category/list.jsp").forward(req, resp);
	}
}