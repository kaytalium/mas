<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*, java.util.*, java.sql.*" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Appointment</title>
</head>
<body>
<h1>Create Appointment</h1>
<br><br><br>
<%
String Fname=(String)session.getAttribute("sess_fname"); 
String Lname=(String)session.getAttribute("sess_lname"); 
out.print("Welcome: " +" "+ Fname + " " + Lname); 

%>

<br><br>
<form action="Appointment" method="post">
<label>Patient ID</label> <input type="number" name="p_id" style= "width: 250px"><br><br>
<label>First Name</label> <input type="text" name="Fname" style= "width:250px"><br><br>
<label>Last Name</label> <input type="text" name="Lname"  style="width:250px"><br><br>
 <label>Services</label>
<select class = "form-control" name="services" style= "width: 250px">
<option value ="-1">Select a Service</option>
<%
Connection conn = null;
Statement stmt = null;
try {
	
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mas", "root","root");
	stmt= conn.createStatement();
	String squery = "SELECT * FROM services";
	ResultSet rs = stmt.executeQuery(squery);
	
	while(rs.next())
	{ 
		%>
		<option><%=rs.getInt("service_id")%> - <%=rs.getString("service")%></option>
		<%
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Error" + e.getMessage());
		
	}
%>

</select>
<br><br>
<label>Doctors</label> 
<select class = "form-control" name="doctors" style= "width: 250px">
<option value ="-1">Select a Doctor</option>
<%
try {
	
	Class.forName("com.mysql.jdbc.Driver");
	conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jspmas", "root","root");
	stmt= conn.createStatement();
	String dquery = "SELECT * FROM doctors";
	ResultSet rs = stmt.executeQuery(dquery);
	
	while(rs.next())
	{ 
		%>
		<option><%=rs.getInt("ID")%> - <%=rs.getString("Name")%></option>
		<%
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		out.println("Error" + e.getMessage());
		
	}
%>

</select> 
<br><br>
<label>Date</label> <input type="date" name="adate" style="width:250px">
<br><br>
<label>Remark</label><br><br>
<textarea rows="4" cols="50" name="remark"></textarea> <br><br>
<input type="submit" value="Make Appointment"> 

</form>

</body>
</html>