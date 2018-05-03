package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
 * Servlet implementation class Appointment
 */
@WebServlet("/Appointment")
public class Appointment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Appointment() {
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
		
		/*HttpSession session = request.getSession();
		String str = session.getAttribute("fname").toString();
		PrintWriter out = response.getWriter();
		out.println("Welcome" +str);*/
		
		try {
			String patientID = request.getParameter("p_id").toString();
			String firstName = request.getParameter("Fname");
			String lastName = request.getParameter("Lname");
			Date date = request.getParameter("adate");
			String remark = request.getParameter("remark");
			
			PrintWriter out2 = response.getWriter();
			out2.println(patientID);
			
			String sql = "insert into appointment(`PatientID`, `FirstName`, `LastName`, `Date`, `Remark`) values(?,?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas","root", "root");
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, patientID);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, date);
			ps.setString(5, remark);
			ps.executeUpdate();
			
			PrintWriter out = response.getWriter();
			out.println("You have successfully created your appointment");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
		
	}

}
