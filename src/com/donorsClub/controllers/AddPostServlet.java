package com.donorsClub.controllers;

import java.io.Console;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.Document;

import com.donorsClub.models.Category;
import com.donorsClub.models.User;
import com.donorsClub.services.CategoryService;
import com.donorsClub.services.ItemService;







@WebServlet("/add_post.do")
@MultipartConfig
public class AddPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddPostServlet() {
		super();
		System.out.println("here");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CategoryService cts = new CategoryService();
		request.setAttribute("Categories", cts.GetAllCategory());
		request.getRequestDispatcher("/WEB-INF/views/add_post.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String itemName = request.getParameter("item_name");
		String description = request.getParameter("description");
		String categoryId = request.getParameter("Myselect");
		String photo1 = request.getParameter("photo1");
		String photo2 = request.getParameter("photo2");
		String photo3 = request.getParameter("photo3");
		String photo4 = request.getParameter("photo4");
		String photo5 = request.getParameter("photo5");

		if (itemName.isEmpty()) {
			request.setAttribute("signupErrorMessages", "Item Name");
			request.setAttribute("description", description);
			request.setAttribute("photo1", photo1);
			request.setAttribute("photo2", photo2);
			request.setAttribute("photo3", photo3);
			request.setAttribute("photo4", photo4);
			request.setAttribute("photo5", photo5);

		}

		long userId = ((User) request.getSession().getAttribute("user")).getUserId();
		ItemService itemService = new ItemService();
		
		
		itemService.InsertItem(itemName, description, photo1, photo2, photo3, photo4, photo5,
				Long.parseLong(categoryId), userId);

		CategoryService cts = new CategoryService();
		request.setAttribute("Categories", cts.GetAllCategory());
		request.getRequestDispatcher("/WEB-INF/views/add_post.jsp").forward(request, response);

	}

}
