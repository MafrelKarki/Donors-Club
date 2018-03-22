package com.donorsClub.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.donorsClub.models.ItemInfo;
import com.donorsClub.services.ViewPostService;

/**
 * Servlet implementation class ViewPostServlet
 */
@WebServlet("/post")
public class ViewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ViewPostService vps = new ViewPostService();
		String id = request.getParameter("id");
		if(id!=null) {
			int itemId = Integer.parseInt(id);
			ItemInfo itf = vps.getItemInfo(itemId);
			request.setAttribute("item", itf.getItem());
			request.setAttribute("user", itf.getUser());
			request.setAttribute("interests", itf.getInterest());
			request.getRequestDispatcher("/WEB-INF/views/item_description.jsp").forward(request, response);
		}else {
			response.sendRedirect("./home");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
