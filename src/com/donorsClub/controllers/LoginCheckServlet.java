package com.donorsClub.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donorsClub.models.User;
import com.donorsClub.services.LoginService;


/**
 * 
 * 
 * @author Sherif
 *
 */
@WebServlet("/login")
public class LoginCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginCheckServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String  email =request.getParameter("email");
		String password=request.getParameter("password");
	
		if (email .isEmpty()||password.isEmpty()) {
			request.setAttribute("msgUnvalid", "Wrong Username or Password");
		}
		LoginService logservice=new LoginService();
		User user = logservice.authorization(email, password);
		if (user==null) {
			request.setAttribute("msgUnvalid", "username or password is incorrect");
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}else {
			request.getSession().setAttribute("user", user);
			request.setAttribute("user", user);
			response.sendRedirect("./home");
//			request.getRequestDispatcher("/WEB-INF/views/homepage.jsp").forward(request, response);
		}
		
	}

}
