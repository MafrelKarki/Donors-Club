package com.donorsClub.controllers;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/ChangePassword.do")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/change_password.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user =(User) request.getSession().getAttribute("user");
		if (user==null) {
			request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);	
		}
		
		String oldPassword=request.getParameter("old_password");
		String newPassword=request.getParameter("new_password");
		String confirmPassword=request.getParameter("confirm_password");
	
		LoginService loginService= new LoginService();		
		List<String> ErrorMessages= loginService.checkPassword(user,oldPassword,newPassword,confirmPassword); 
		 if(ErrorMessages.size()>0) {		
	    	 request.setAttribute("ErrorMessages", ErrorMessages);	
			
		}else {
			if (loginService.UpdatePassword(user, newPassword, confirmPassword)) {
				 request.setAttribute("CorrerctMessages", "Done");	
					
			}else {
				ErrorMessages.add("Connection Error");
				 request.setAttribute("ErrorMessages", ErrorMessages);	
					
			}
			
		}
			request.getRequestDispatcher("/WEB-INF/views/change_password.jsp").forward(request, response);
	}

}
