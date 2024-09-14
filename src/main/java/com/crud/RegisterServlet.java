package com.crud;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.EmpDao;
import com.crud.model.Employee;


/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public RegisterServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// if registered successfully then add to database

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		
		Employee emp=new Employee();
		emp.setName(name);
		emp.setEmail(email);
		emp.setPassword(password);
		emp.setContact(contact);
		emp.setAddress(address);
		
		
		EmpDao empDao=new EmpDao();
		try {
			
			empDao.addEmployee(emp);
			response.sendRedirect("login.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		doGet(request, response);
	}
}
