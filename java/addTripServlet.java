

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


@WebServlet("/addTripServlet")
public class addTripServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String dbDriver = "com.mysql.jdbc.Driver";
		   
        String url = "jdbc:mysql://localhost:3306/dlithe";
        String username = "root";
        String password = "root";
        try {
             String busId = request.getParameter("busId");
            String from = request.getParameter("from");
            String fromTime = request.getParameter("fromTime");
           String to=request.getParameter("to");
           String toTime=request.getParameter("toTime");
           String cost=request.getParameter("cost");
           
           
           
            Class.forName(dbDriver);
            int busIdInt=Integer.parseInt(busId);
            double costD = Double.parseDouble(cost);
            // Insert user data into the database
            Connection connection = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO trip(bus_id,from_loc,departure_time,to_loc,arrival_time,ticket_cost) VALUES (?,?,?,?,?,?)";
            

            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, busIdInt);
            statement.setString(2,from);
            statement.setString(3,fromTime);
            statement.setString(4,to);
            statement.setString(5,toTime);
            statement.setDouble(6,costD);
            
            statement.executeUpdate();
            

            
            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
            	 response.sendRedirect("index.jsp");
            } else {
            	 response.sendRedirect("error.jsp");
            }
            
            
            
            

            statement.close();
            
            connection.close();

            // Redirect to a success page
           
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");
           
            
        }
	}

}
