<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.io.*, java.util.*, java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "css/confirmstyle.css" rel="stylesheet" type="text/css">
<title>Appointment Confirmation</title>
</head>
<body>
<div class="title"><h2>Manage Appointment</h2></div>

<div class="container">
	<form method="post" action="Confirmation">
	
	
		<div class="left">
		<h3>Personal Details</h3>
		<%
		Connection conn = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root", "root");
			stmt = conn.createStatement();
			
			String query = "SELECT a.PatientID, p.first_name, p.last_name FROM appointment a, person p WHERE a.ID='2' AND a.patientID=p.id";
			ResultSet rs = stmt.executeQuery(query);
						 
			while(rs.next())
			{
				%>
				<label>Patient ID: <%=rs.getString("PatientID")%></label><br><br>
				<label>Name: <%=rs.getString("first_name")%></label> <label><%=rs.getString("last_name")%></label>
				<%
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			out.println("Error" + ex.getMessage());
		}
		%>
		</div>
	
		<div class="right">
		<div class="formBox">
		<h3>Appointment Details</h3>
		<%
		Connection connect = null;
		Statement stamt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root", "root");
			stamt = connect.createStatement();
			
			String query = "SELECT a.Date, a.Remark, s.service, d.Name FROM appointment a, services s, doctors d WHERE ID='2'AND a.ServiceID=s.service_id AND a.DoctorsID=d.DoctorID";
			ResultSet rs = stmt.executeQuery(query);
						 
			while(rs.next())
			{
				%>
				<label>Services: <%=rs.getString("service")%></label>
				<label>Doctor: <%=rs.getString("Name")%></label>
				<label>When: <%=rs.getString("Date")%></label><br><br>
								
				 <label>Remark: <%=rs.getString("Remark")%></label><br><br>
				<%
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
			out.println("Error" + e.getMessage());
		}
		%>
				
		</div>
		</div>
	</div>	
	<div class="lower"></div>
	</form>
	</body>
</html>