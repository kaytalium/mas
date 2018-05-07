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
		
//		HttpSession session = request.getSession();
//		String str = session.getAttribute("fname").toString();
		PrintWriter out = response.getWriter();
//		out.println("Welcome" +str);
		
		try {
			String email = request.getParameter("uname");
			String password = request.getParameter("paword");
			String firstname = null;
			String lastname = null;
			
			String passwordquery = "SELECT * FROM registration where Username= ? and Password =?";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root","root");
			PreparedStatement pstmt = conn.prepareStatement(passwordquery);
			
			pstmt.setString(1, email);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			
			PrintWriter loginout = response.getWriter();
						
			if(rs.next())
			{
				 firstname = rs.getString("firstName");
				 lastname = rs.getString("lastName");
				 
				 HttpSession session = request.getSession();
				 session.setAttribute("sess_fname",firstname); 
				 session.setAttribute("sess_lname",lastname); 
				 session.setAttribute("isAuth", true);//This is to be used in all other pages 

				 
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
