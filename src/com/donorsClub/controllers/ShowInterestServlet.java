package com.donorsClub.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import com.donorsClub.daos.InterestDao;
import com.donorsClub.daos.ItemDao;
import com.donorsClub.daos.UserDao;
import com.donorsClub.models.Interest;
import com.donorsClub.models.Item;
import com.donorsClub.models.User;
/**
 * @since 3/20/2018
 * @author Mafrel
 */
@WebServlet("/ShowInterestServlet.do")
public class ShowInterestServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public ShowInterestServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    response.getWriter().append("Served at: ").append(request.getContextPath());
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String itemId = request.getParameter("postId");
    Item item = (Item) new ItemDao().findById(Integer.parseInt(itemId));
    User user = (User) request.getSession().getAttribute("user");

    Interest interest = new InterestDao().getItemInterestByItemIdAndUserId(Long.parseLong(itemId),
        user.getUserId());

    boolean resp = false;
    if (interest == null) {
      Interest interestToBeAdded = new Interest();
      interestToBeAdded.setUserId((int) user.getUserId());
      interestToBeAdded.setItemId(Integer.parseInt(itemId));
      interestToBeAdded.setSeen((short) 0);
      interestToBeAdded.setCreatedAt(new Date());
      interestToBeAdded.setUpdatedAt(new Date());
      new InterestDao().insert(interestToBeAdded);
      user.addInterestList(interestToBeAdded);
      resp = true;
    } else {
      new InterestDao().delete(interest);
      User userToBeResessioned = (User) new UserDao().findById(user.getUserId());
      request.getSession().setAttribute("user", userToBeResessioned);
      resp = true;
    }

    response.setContentType("application/json");
    JSONObject jObj = new JSONObject();
    jObj.put("response", resp);
    PrintWriter writer = response.getWriter();
    writer.println(jObj);

  }

}
