package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDaoImpl;

import model.user;

@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginController() {
        super();
           }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Login controller");
		
		RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		rd.forward(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		System.out.println("email"+password);
		System.out.println("role"+role);
		
		//user object
		user user = new user();
		user.setEmail(email);
		user.setPassword(password);
		user.setEmpType(role);
		
		UserDaoImpl userdao=new UserDaoImpl();

		
		boolean validateUser = false;
		validateUser = userdao.loginUser(user);
		System.out.println("valid user type"+validateUser);
		
		if(validateUser) {
			System.out.println("testing"+role);
			if(role.equalsIgnoreCase("admin"))
			{
			System.out.println("Admin portal");
			
			response.sendRedirect(request.getContextPath()+"/Admin");
				 
		}
		else  {
			System.out.println("employee portal");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/blogView.jsp");
			rd.forward(request, response);
		}
		}
		
		
		else
		{
			System.out.println("else part redirected to login");
			RequestDispatcher rd=this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			rd.forward(request, response);
		}
	}

}
