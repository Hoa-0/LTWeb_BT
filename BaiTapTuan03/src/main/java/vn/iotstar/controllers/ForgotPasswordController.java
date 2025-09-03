package vn.iotstar.controllers;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import vn.iotstar.models.UserModels;
import vn.iotstar.services.UserService;
import vn.iotstar.services.impl.UserServiceImpl;

@WebServlet("/forgot")
public class ForgotPasswordController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserService service = new UserServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        String username = req.getParameter("username");
        UserModels user = service.get(username);

        if (user != null) {
            req.setAttribute("alert", "Mật khẩu của bạn là: " + user.getPassword());
        } else {
            req.setAttribute("alert", "Không tìm thấy tài khoản!");
        }
        req.getRequestDispatcher("/forgotPassword.jsp").forward(req, resp);
    }
}
