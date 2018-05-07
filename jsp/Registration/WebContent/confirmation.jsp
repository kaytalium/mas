<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="java.io.*, java.util.*, java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "css/style.css" rel="stylesheet" type="text/css">
<title>Appointment Confirmation</title>
</head>
<body>
<div class="outer">

	<form method="post" action="Confirmation">
	<div class="header"><h2>Manage Appointment</h2></div>
	
	<div class="inner">
	
	</div>
	
	<div class="container">
		<div class="left">
		<%
		Connection conn = null;
		Statement stmt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root", "root");
			stmt = conn.createStatement();
			
			String query = "SELECT PatientID, FirstName LastName FROM appointment";
			ResultSet rs = stmt.executeQuery(query);
						 
			while(rs.next())
			{
				%>
				<label>Patient ID:<%=rs.getString("PatientID")%></label><br><br>
				<label>Name:<%=rs.getString("FirstName")%><%=rs.getString("LastName")%></label>
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
		<h3>Appointment Details</h3>
		<%
		Connection connect = null;
		Statement stamt = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root", "root");
			stamt = connect.createStatement();
			
			String query = "SELECT Date, Remark FROM appointment";
			ResultSet rs = stmt.executeQuery(query);
						 
			while(rs.next())
			{
				%>
				<label>When:<%=rs.getString("Date")%></label><br><br>
								
				 <label>Remark:<%=rs.getString("Remark")%></label><br><br>
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
	<div class="lower"></div>
	</form>
</div>
</body>
</html>