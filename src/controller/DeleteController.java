package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.FoodDaoImpl;


@WebServlet(urlPatterns={"/delete"})
			//urlPatterns= {"/addfood"}
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public DeleteController() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Delete Blog");
		try {
			deleteBlog(request, response);
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

	private void deleteBlog(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		
		FoodDaoImpl FoodDao = new FoodDaoImpl();
        FoodDao.deleteFood(id);
		response.sendRedirect("Admin");
	}
	
	
}
