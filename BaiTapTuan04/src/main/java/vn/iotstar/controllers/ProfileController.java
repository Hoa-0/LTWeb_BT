package vn.iotstar.controllers;

import java.io.File;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import vn.iotstar.models.UserModels;
import vn.iotstar.services.UserService;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet("/profile")
@MultipartConfig
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserServiceImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserModels user = (session != null) ? (UserModels) session.getAttribute("account") : null;
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}
		request.getRequestDispatcher("/views/user/profile.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		UserModels user = (UserModels) session.getAttribute("account");
		if (user == null) {
			response.sendRedirect(request.getContextPath() + "/login.jsp");
			return;
		}

		String fullname = request.getParameter("fullname");
		String phone = request.getParameter("phone");
		Part filePart = request.getPart("image");
		String fileName = null;
		if (filePart != null && filePart.getSize() > 0) {
			String uploadPath = request.getServletContext().getRealPath("/resources/images");
			File uploadDir = new File(uploadPath);
			if (!uploadDir.exists())
				uploadDir.mkdirs();
			fileName = new File(filePart.getSubmittedFileName()).getName();
			filePart.write(uploadPath + File.separator + fileName);
		}

		user.setFullName(fullname);
		user.setPhone(phone);
		if (fileName != null) {
			user.setImage(fileName);
		}
		userService.update(user);
		session.setAttribute("account", user);
		response.sendRedirect(request.getContextPath() + "/profile");
	}
}
