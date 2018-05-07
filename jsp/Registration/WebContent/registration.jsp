<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
<link href = "css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="Regbox">
<img src="img/avatar_icon.png" class="avatar"/>
<h1>Register Here</h1>
<form action="Registration" method="post">

	<label>Patient ID</label>
	<p>
		<input type ="number" name="patid" placeholder ="Patient ID" disabled>
		<input type="checkbox" name="patient" value="id">
		<label style="padding: 0;
    margin-left: -10px;
    margin-top: -5px;
    font-size: 13px;
    color: #999;">Have Patient ID?</label>
	</p>
	

	<label>First Name</label>  
	<p><input type="text" name="fname" placeholder="John" required="required"></p>

	<label>Last Name</label>
  	<p><input type="text" name="lname" placeholder="Doe" required="required"></p>
	
	<label>Email </label> 
	<p><input type="email" name="usname" placeholder="johndoe@email.com" required="required"></p>
	
	<label>Password</label>  
	<p><input type="password" name="pword" required="required"></p>
	
	<p><input type="submit" value="Register"></p>
	
	<p class="memlink"><a href="login.jsp">Already a Member</a></p>
</form>

</div>
<div class="footer">
	<p class="company_name">Code <strong>Zero</strong></p>
	<p class="copyright">All Rights Reserved @copy @ 2018 CODE ZERO Inc. </p>
	<p class="owners">Ovel Heslop . Tajhna McCourtie . Ruel Andrews . Cordel Reid</p>
</div>
</body>
</html>