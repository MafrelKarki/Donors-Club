package com.donorsClub.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;



/**
 * @since 3/19/2018
 * @author Mafrel
 */
@WebServlet("/ProfileServlet.do")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProfileServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(false);
		User user = (User)session.getAttribute("user");
//		System.out.println(user);
	  
		JSONObject userJSON = new JSONObject();
		userJSON.put("user", user);
//	    System.out.println("inside profile's get method");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   User user = (User)request.getSession().getAttribute("user");
	   user.setFname(request.getParameter("fname"));
	   user.setLname(request.getParameter("lname"));
	   user.setEmail(request.getParameter("email"));
	   user.setAddress(request.getParameter("address"));
	   user.setPhoneNumber(request.getParameter("phoneNumber"));
	   user.setUpdatedAt(new Date());
	   
	   UserDao uDao = new UserDao();
	   boolean updateStatus = uDao.update(user);
	   
	   response.setContentType("application/json");
	   JSONObject res = new JSONObject();
	   res.put("response", updateStatus);
	   PrintWriter writer = response.getWriter();
	   writer.println(res);
	  
	}

}
