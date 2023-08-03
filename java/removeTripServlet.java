

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/removeTripServlet")
public class removeTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dbDriver = "com.mysql.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/dlithe";
        String username = "root";
        String password = "root";
        try {
             String busId = request.getParameter("busId");
             String tripId = request.getParameter("tripId");
             Class.forName(dbDriver);
             int busIdInt = Integer.parseInt(busId);
             int tripIdInt = Integer.parseInt(tripId);
            // Insert user data into the database
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "DELETE FROM trip where trip_id=?";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, tripIdInt);
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
            	 response.sendRedirect("index.jsp");
            } else {
            	 response.sendRedirect("error.jsp");
            }
            
            
            statement.executeUpdate(); //we use this when we use insert update delete

            statement.close();
            connection.close();

//            response.sendRedirect("index.jsp");
        	} catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
          
            response.sendRedirect("error.jsp");
            
        }
	}

}
