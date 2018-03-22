package com.donorsClub.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;
import com.donorsClub.services.SignUpService;



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
	  
	  String fname = request.getParameter("fname");
	  String lname = request.getParameter("lname");
	  String email = request.getParameter("email");
	  String address = request.getParameter("address");
	  String phoneNumber = request.getParameter("phoneNumber");
//	  String 
	  
	   
	   SignUpService signUpService = new SignUpService();
	   List<String> errors = signUpService.validateSignUpForm(fname, lname, address, phoneNumber, email, "MyDummyPassword", "MyDummyPassword");
	   
	   response.setContentType("application/json");
	   JSONObject res = new JSONObject();
	   
	   
	   if(errors.isEmpty()){
	       User user = (User)request.getSession().getAttribute("user");
	       user.setFname(fname);
	       user.setLname(lname);
	       user.setEmail(email);
	       user.setAddress(address);
	       user.setPhoneNumber(phoneNumber);
	       user.setUpdatedAt(new Date());
	       
//	       System.out.println(errors);
//	       System.out.println(errors.size());
    	   UserDao uDao = new UserDao();
    	   boolean updateStatus = uDao.update(user);
//    	   user = (User)new UserDao().findById(user.getUserId());
    	   res.put("response", updateStatus);
	   }else{
	       res.put("response", errors);
	   }
	   
	   PrintWriter writer = response.getWriter();
	   writer.println(res);
	  
	}

}
