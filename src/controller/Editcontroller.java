package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FoodDaoImpl;

import model.food;
import utility.ConnectionManager;


@WebServlet(urlPatterns= {"/edit"})
public class Editcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public Editcontroller() {
		super();

	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Connection con=null;
		try {
			con=ConnectionManager.getConnection();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(con!=null) {
			System.out.println("connection established");
		}
		else
		{
			System.out.println("Check your connection");
		}
		
		
		
		
		
		System.out.println("edit blog");
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println(id);

		FoodDaoImpl fooddao = new FoodDaoImpl();

		food existingfood=new food();
		try {
			existingfood = fooddao.orderFood(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("foodlist", existingfood);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/editfood.jsp");
		dispatcher.forward(request, response);



	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("display");
		int Fid=Integer.parseInt(request.getParameter("id"));
		String Fname=request.getParameter("name");
		int Fprice=Integer.parseInt(request.getParameter("price"));

		System.out.println(Fid+""+Fname+" "+Fprice);

		food food=new food();
		food.setFid(Fid);
		food.setFname(Fname);
		food.setFprice(Fprice);

		FoodDaoImpl FoodDao=new FoodDaoImpl();


		int checkFood = 0;
		try {
			checkFood = FoodDao.updateFood(food);;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		if(checkFood!=0) {

			System.out.println(food.getFid());
			System.out.println(food.getFname());
			System.out.println(food.getFprice());
			
			request.setAttribute("message", "Food Item Updated Successfuly");
			response.sendRedirect("Admin");
			/*
			 * RequestDispatcher rd=this.getServletContext().getRequestDispatcher(
			 * "/WEB-INF/views/AdminView.jsp"); rd.forward(request, response);
			 */
		}

		else
		{
			request.setAttribute("message", "Check Your Data");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView.jsp");
			rd.forward(request, response);
		}

	}




}
