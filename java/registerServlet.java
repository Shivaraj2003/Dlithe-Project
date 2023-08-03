

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String dbDriver = "com.mysql.jdbc.Driver";
	   
	        String url = "jdbc:mysql://localhost:3306/dlithe";
	        String username = "root";
	        String password = "root";

	        try {
	            String usernameParam = request.getParameter("username");
	            String passwordParam = request.getParameter("password");
	          
	            Class.forName(dbDriver);

	            // Insert user data into the database
	            Connection connection = DriverManager.getConnection(url, username, password);
	            String sql = "INSERT INTO admin(username,password) VALUES (?, ?)";

	            PreparedStatement statement = connection.prepareStatement(sql);
	            
	            statement.setString(1, usernameParam);
	            statement.setString(2, passwordParam);
	            
	            statement.executeUpdate();

	            statement.close();
	            connection.close();

	            // Redirect to a success page
	            response.sendRedirect("index.jsp");
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	            
	        }
		

	}

}
