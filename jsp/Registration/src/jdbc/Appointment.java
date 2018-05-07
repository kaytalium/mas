package jdbc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
		
		HttpSession session = request.getSession();
		
		Boolean isAuth = (Boolean) session.getAttribute("isAuth");
		
		if(!isAuth) {
			RequestDispatcher ard = request.getRequestDispatcher("login.jsp");
			ard.forward(request, response);
		}
			
		String str = session.getAttribute("sess_fname").toString();
		PrintWriter out = response.getWriter();
		out.println("Welcome" +str);
		
		try {
			String email = (String) session.getAttribute("sess_email"); 
			String patientID = request.getParameter("p_id").toString();
			String firstName = request.getParameter("Fname");
			String lastName = request.getParameter("Lname");
			String serviceValue = request.getParameter("services");
			String doctorValue = request.getParameter("doctors");
			String date = request.getParameter("adate");
			String remark = request.getParameter("remark");
			
			SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date adate = sd.parse(date);
			java.sql.Date dbdate= new java.sql.Date(adate.getTime());
			
			String[] services = serviceValue.split(" - ");
			String[] doctors = doctorValue.split(" - ");
			
			
			
			String sql = "INSERT INTO appointment(`PatientID`, `FirstName`, `LastName`,`ServiceID`,`DoctorsID`,`Date`,`Remark`) VALUES(?,?,?,?,?,?,?)";
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas","root", "root");
			PreparedStatement ps = conn.prepareStatement(sql);
			
						
			ps.setString(1, patientID);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setInt(4, Integer.parseInt(services[0]));
			ps.setInt(5, Integer.parseInt(doctors[0]));
			ps.setDate(6, dbdate);
			ps.setString(7, remark);
			ps.executeUpdate();
			
			PrintWriter out2 = response.getWriter();
			out2.println("You have successfully created your appointment");
			
			response.sendRedirect("confirmation.jsp");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
					
		
	}

}
