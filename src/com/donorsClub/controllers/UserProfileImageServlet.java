package com.donorsClub.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;
import com.donorsClub.services.ImageService;

/**
 * @since 3/20/2018
 * @author Mafrel
 */
@WebServlet("/UserProfileImageServlet.do")
@MultipartConfig
public class UserProfileImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserProfileImageServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Part profilePicturePart = request.getPart("userImage");
      String imageUrl = new ImageService().imageUploader("", profilePicturePart);
      
      System.out.println(imageUrl);
      
      User user = (User)request.getSession().getAttribute("user");
      
      user.setPicture(imageUrl);
      new UserDao().insert(user);
      
//      User sessionUser = (User)new UserDao().findById(user.getUserId());
      
//      request.getSession().setAttribute("user", sessionUser);
      
      response.sendRedirect("./home");
	}

}
