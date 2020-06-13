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


@WebServlet(urlPatterns= {"/addfood"})
public class addfood extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public addfood() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("add food Item");
		
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
		
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/addfood.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int Fid=Integer.parseInt(request.getParameter("id"));
		String Fname=request.getParameter("name");
		int Fprice=Integer.parseInt(request.getParameter("price"));
		String Fimage="Curd_rice.jpg";
		
		System.out.println(Fid+" "+Fname+" "+Fprice+" "+Fimage);
		
		food food=new food();
		food.setFid(Fid);
		food.setFname(Fname);
		food.setFprice(Fprice);
		food.setFimage(Fimage);
		
		FoodDaoImpl FoodDao=new FoodDaoImpl();
		
		
		int checkFood = 0;
		try {
			checkFood = FoodDao.insertFood(food);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(checkFood!=0) {
			
			System.out.println(food.getFid());
			System.out.println(food.getFname());
			System.out.println(food.getFprice());
			System.out.println(food.getFimage());
			request.setAttribute("message", "Food Item Added Successfuly");
			
			response.sendRedirect("Admin");
		}
		
		else
		{
			request.setAttribute("message", "Check Your Data");
			response.sendRedirect("addfood");
		}
	

		
		
	}

}
