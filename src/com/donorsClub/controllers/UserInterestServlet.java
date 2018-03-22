package com.donorsClub.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;

/**
 * Servlet implementation class UserInterestServlet
 */
@WebServlet("/user_interest.do")
public class UserInterestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserInterestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User user =(User) request.getSession().getAttribute("user");
		request.setAttribute("user", user); 
		 User userToBeResessioned = (User) new UserDao().findById(user.getUserId());
	      request.getSession().setAttribute("user", userToBeResessioned);
		request.getRequestDispatcher("/WEB-INF/views/user_interest.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
