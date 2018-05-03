package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		try {
			String email = request.getParameter("uname");
			String password = request.getParameter("paword");
			String databaseEmail = null;
			String databasePword = null;
			
			String newquery = "SELECT * FROM registration where Username= ? and Password =?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root","root");
			PreparedStatement pstmt = conn.prepareStatement(newquery);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			PrintWriter loginout = response.getWriter();
						
			if(rs.next())
			{
				databaseEmail = rs.getString("Username");
				databasePword = rs.getString("Password");

				
			}
			if(email.equals(databaseEmail) && password.equals(databasePword))
			{
									
				loginout.println("You are logged in");
				RequestDispatcher rd = request.getRequestDispatcher("appointment.jsp");
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("login.jsp");
				//RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				//rd.include(request, response);
			}
			} 
		catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
