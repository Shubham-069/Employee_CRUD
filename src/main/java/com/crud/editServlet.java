package com.crud;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.EmpDao;
import com.crud.model.Employee;

/**
 * Servlet implementation class editServlet
 */
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	EmpDao empDao = new EmpDao();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public editServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String action = request.getParameter("action");
		out.print(action);
		if ("edit".equals(action)) {
			// Get employee ID and fetch employee data
			String idStr = request.getParameter("id");
			
			int id = Integer.parseInt(idStr);
			Employee employee = empDao.getEmployeeById(id);
			

			// Set employee object in request scope
			request.setAttribute("employee", employee);

			// Forward to JSP to display the form pre-filled with employee details
			RequestDispatcher dispatcher = request.getRequestDispatcher("editemployee.jsp");
			dispatcher.forward(request, response);
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		try {
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String contact = request.getParameter("contact");
			String address = request.getParameter("address");

			Employee emp = new Employee();
			emp.setId(id);
			emp.setName(name);
			emp.setEmail(email);
			emp.setContact(contact);
			emp.setAddress(address);

			empDao.updateEmployee(emp);
			
			response.sendRedirect("EmpListServlet");
		} catch (Exception e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
