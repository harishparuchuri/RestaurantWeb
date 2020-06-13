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

import utility.ConnectionManager;
import model.user;
import dao.UserDaoImpl;

@WebServlet(urlPatterns= {"/signup"})
public class SignUpController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public SignUpController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Sign up controller");
		
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
		
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUpView.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String name=request.getParameter("name");
		String Email=request.getParameter("email");
		String password=request.getParameter("password");
		String Etype=request.getParameter("usertype");
		user user=new user();
		user.setEmail(Email);
		user.setName(name);
		user.setPassword(password);
		user.setEmpType(Etype);
		
		UserDaoImpl userdao=new UserDaoImpl();
		int checkUser = 0;
		try {
			checkUser = userdao.signUp(user);
			System.out.println("check user "+checkUser);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		if(checkUser!=0)
		{
						
			//System.out.println(user.getName());
			System.out.println("mail test"+user.getEmail());
			System.out.println(user.getPassword());
			
			request.setAttribute("message", "Sign up Successfuly");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUpView.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("message", "Check your email and password");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/signUpView.jsp");
			rd.forward(request, response);
		}
		
		
		
	}

}
