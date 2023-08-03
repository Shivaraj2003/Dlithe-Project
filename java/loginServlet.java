import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String dbDriver = "com.mysql.jdbc.Driver";
    	String url = "jdbc:mysql://localhost:3306/dlithe";
        String username = "root";
        String password = "root";
    	
        
        
        

        try {
            PrintWriter out=response.getWriter();
        	String usernameP = request.getParameter("username");
            String passwordP = request.getParameter("password");
            ResultSet rowsAffected;
           Class.forName(dbDriver);
           
           // Insert user data into the database
           Connection connection = DriverManager.getConnection(url, username, password);
           String sql = "SELECT * FROM admin where username=?";

           PreparedStatement statement = connection.prepareStatement(sql);
           
           statement.setString(1, usernameP);
           rowsAffected = statement.executeQuery();

           if (rowsAffected.next()) {
        	   if(rowsAffected.getString(2).equals(passwordP))
        		   		response.sendRedirect("adminActivity.jsp");
            else {
        	  out.print("Invalid Credentials");
           	 response.sendRedirect("login.jsp");
           	
           }
           }
           
           statement.executeUpdate();

           statement.close();
           connection.close();

//           response.sendRedirect("index.jsp");
       } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
          
           
       }
    }
}
