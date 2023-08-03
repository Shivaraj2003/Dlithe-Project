

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


@WebServlet("/addBusServlet")
public class addBusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String dbDriver = "com.mysql.jdbc.Driver";
		   
        String url = "jdbc:mysql://localhost:3306/dlithe";
        String username = "root";
        String password = "root";
        try {
             String busId = request.getParameter("busId");
            String busName = request.getParameter("busName");
            String busReg = request.getParameter("regNumber");
            String passwordp = request.getParameter("password");
          
            Class.forName(dbDriver);
            int busIdInt = Integer.parseInt(busId);
            // Insert user data into the database
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO bus(bus_id,busname,bus_reg_no) VALUES (?, ?,?)";
            String sql1="INSERT INTO bus_manager(bus_id,password) VALUES (?,?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, busIdInt);
            statement.setString(2,busName);
            statement.setString(3,busReg);
            
            statement.executeUpdate();
            
PreparedStatement statementA = connection.prepareStatement(sql1);
            
            statementA.setInt(1, busIdInt);
            statementA.setString(2,passwordp);
            
            
            statementA.executeUpdate();

            statement.close();
            statementA.close();
            connection.close();

            // Redirect to a success page
            response.sendRedirect("index.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
           
            
        }
		
	}

}
