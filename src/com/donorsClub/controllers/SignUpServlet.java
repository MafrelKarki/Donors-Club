package com.donorsClub.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.donorsClub.daos.UserDao;
import com.donorsClub.models.User;
import com.donorsClub.services.LoginService;
import com.donorsClub.services.SignUpService;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    String firstName = request.getParameter("first_name");
    String lastName = request.getParameter("last_name");
    String address = request.getParameter("address");
    String email = request.getParameter("email");
    String contactNo = request.getParameter("contact_no");
    String password = request.getParameter("password");
    String confirmPassword = request.getParameter("confirm_password");


    SignUpService sus = new SignUpService();

    List<String> signupErrorMessages = sus.validateSignUpForm(firstName, lastName, address,
        contactNo, email, password, confirmPassword);
    if (signupErrorMessages.size() > 0) {
      request.setAttribute("signupErrorMessages", signupErrorMessages);
      request.setAttribute("firstName", firstName);
      request.setAttribute("firstLast", lastName);
      request.setAttribute("address", address);
      request.setAttribute("email", email);
      request.setAttribute("contactNo", contactNo);



      request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    } else {
      User user = new User();
      user.setFname(firstName);
      user.setLname(lastName);
      user.setAddress(address);
      user.setEmail(email);
      user.setPhoneNumber(contactNo);
      user.setPassword(password);
      user.setCreatedAt(new Date());
      user.setUpdatedAt(new Date());
      user.setStatus((short) 1);
      user.setUserType(0);
      user.setPicture("");

      LoginService loginService = new LoginService();
      user.setPassword(loginService.hashMd5(user.getPassword()));

      long id = new UserDao().insert(user);

      if (id > 0) {
        User newUser = (User) new UserDao().findById(id);
        HttpSession session = request.getSession();
        session.setAttribute("user", newUser);

        if (newUser != null) {
          response.sendRedirect("./home");
        }
      } else
          request.getRequestDispatcher("/WEB-INF/views/signup.jsp").forward(request, response);
    }



  }

}
