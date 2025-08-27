package vn.iotstar.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import vn.iotstar.models.UserModels;

@WebServlet("/WaitingController")
public class WaitingController extends HttpServlet {
    private static final long serialVersionUID = 1L; // ✅ thêm dòng này

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {

        HttpSession session = req.getSession(false); // không tạo session mới nếu chưa có
        UserModels user = (session != null) ? (UserModels) session.getAttribute("account") : null;

        if (user != null) {
            // Có tài khoản trong session
        	resp.sendRedirect(req.getContextPath() + "/views/home.jsp");
        } else {
            // Chưa login → quay về login
            resp.sendRedirect(req.getContextPath() + "/views/login.jsp");
        }
    }
}
