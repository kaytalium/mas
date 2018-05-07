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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
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
			 String firstName = request.getParameter("fname");
			 String lastName = request.getParameter("lname");
			String email = request.getParameter("usname");
			String password = request.getParameter("pword");
			
			
									
			String check = "SELECT * FROM registration where Username='"+email+"'";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root","root");
			PreparedStatement prestmt = conn.prepareStatement(check);
			ResultSet rs = prestmt.executeQuery();
			if(rs.next())
			{
				PrintWriter checkout= response.getWriter();
				checkout.println("This email already exists");
				RequestDispatcher rd = request.getRequestDispatcher("registration.jsp");
				rd.forward(request, response);
			}
			else
			{
				String query = "insert into registration (firstName, lastName, userName, password) values (?,?,?,?)";
				PreparedStatement prstmt = conn.prepareStatement(query);
				
				prstmt.setString(1, firstName);
				prstmt.setString(2, lastName);
				prstmt.setString(3, email);
				prstmt.setString(4, password);
				prstmt.executeUpdate();
				
				//Printing out to user
				PrintWriter out = response.getWriter();
				out.println("You are successfully registered");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
							
			}
				
			}
			catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
