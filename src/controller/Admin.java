package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FoodDaoImpl;
import model.food;

/**
 * Servlet implementation class Admin
 */
@WebServlet(urlPatterns= {"/Admin"})
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Admin() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Admin view");
		System.out.println("display food");
		FoodDaoImpl fooddao=new FoodDaoImpl();
		List<food> foodlist = null;
		try {
			foodlist=fooddao.selectAllfood();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(@SuppressWarnings("unused") food listfood:foodlist) {
			//display food in console
			/*
			 * System.out.println(listfood.getFid());
			 * System.out.println(listfood.getFname());
			 * System.out.println(listfood.getFprice());
			 * System.out.println(listfood.getFimage());
			 */
		}
		request.setAttribute("foodlist", foodlist);
		System.out.println("redirected to admin view");
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/AdminView.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
