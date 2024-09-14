package com.crud;



import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ValidationFilter
 */
public class ValidationFilter implements Filter {
    
    public ValidationFilter() {
        // Default constructor.
    }

    @Override
    public void init(FilterConfig fConfig) throws ServletException {
        // Initialization code, if needed.
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String servletPath = httpRequest.getServletPath();
        
        // Perform validation for registration and login
        if (servletPath.equals("/registerServlet") || servletPath.equals("/loginServlet")) {
            String email = httpRequest.getParameter("email");
            String password = httpRequest.getParameter("password");
            
            if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
                // Invalid data, redirect to an error page or show an error message
                httpRequest.setAttribute("errorMessage", "Email and Password are required.");
                httpRequest.getRequestDispatcher("error.jsp").forward(request, response);
                return;
            }
        }

        // Continue with the request
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup code, if needed.
    }
}

