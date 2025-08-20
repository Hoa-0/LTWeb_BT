package vn.iotstar.controller;

import java.io.IOException;
//import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServletSession
 */

@WebServlet("/Login-Session")
public class LoginServletSession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServletSession() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if ("Hoa".equals(username) && "123".equals(password)) {
			HttpSession session = request.getSession();
			session.setAttribute("name", username);
			response.sendRedirect("Profile");
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("loginSession.html");
			rd.include(request, response);
		}
		doGet(request, response);
	}

}
