package com.crud;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.crud.dao.EmpDao;

/**
 * Servlet implementation class deleteServlet
 */
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EmpDao empDao=new EmpDao();
		 String idStr = request.getParameter("id");
	        
	        // Check if the ID is not null and not empty
	        if (idStr != null && !idStr.isEmpty()) {
	            try {
	                int id = Integer.parseInt(idStr);
	                empDao.deleteEmployee(id);
	                response.sendRedirect("EmpListServlet");
	            }catch (NumberFormatException e) {
	                response.getWriter().println("Invalid employee ID format.");
	            }
	        } else {
	            response.getWriter().println("Employee ID is missing or invalid.");
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
