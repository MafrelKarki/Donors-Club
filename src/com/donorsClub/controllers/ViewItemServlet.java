package com.donorsClub.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;
import com.donorsClub.services.ViewItemService;


/**
 * 
 * 
 * @author Sherif
 *
 */

@WebServlet("/ViewItem.do")
public class ViewItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User user=(User) request.getSession().getAttribute("user");
		
		user = (User)new UserDao().findById(user.getUserId());
		request.setAttribute("user", user);
		request.getRequestDispatcher("/WEB-INF/views/view_item.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
