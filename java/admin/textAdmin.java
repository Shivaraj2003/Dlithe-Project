package admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class textAdmin extends HttpServlet {
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

//	        if (username.equals("admin") && password.equals("password")) {
//	            // Successful login
//	            response.sendRedirect("index.jsp");
//	        } else {
//	            // Invalid login
//	            response.sendRedirect("login.jsp");
//	           
//	        }
	    }
	
}
