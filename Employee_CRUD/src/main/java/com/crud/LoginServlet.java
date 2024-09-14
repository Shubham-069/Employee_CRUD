package com.crud;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.crud.dao.EmpDao;



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 
	        
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();

		String email=request.getParameter("email");
		String password=request.getParameter("password");

		
		EmpDao empDao=new EmpDao();
		boolean isRegistered=empDao.isUserRegistered(email, password);
		
		
		
		if(isRegistered) {
//			to get all registered emp list from database after login
			 // Create a session
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setMaxInactiveInterval(5);
			response.sendRedirect("EmpListServlet");
		}else {
			out.println("Login Failed !! Try Again!!");
			RequestDispatcher reqdis=request.getRequestDispatcher("login.jsp");
			reqdis.forward(request, response);
		}
	}
		

}
