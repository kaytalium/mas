<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href = "css/style.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
 <div class="loginbox">
 <img src="img/avatar_icon.png" class="avatar"/>
 <h2>Log In</h2>
	<form action="Login" method="post">
					
		<label>Email</label>
	    <p><input type="email" name="uname" placeholder="johndoe@email.com" required="required"></p>
	
		<label>Password</label>
 		<p><input type="password" name="paword" required="required"></p>
 				
 		<p><input type="submit" value="Login"></p>
 		
 		<p class="memlink"><a href="registration.jsp">Become a member today</a></p>
 		
 				
 </form>

</div>
<div class="footer">
	<p class="company_name">Code <strong>Zero</strong></p>
	<p class="copyright">All Rights Reserved @copy @ 2018 CODE ZERO Inc. </p>
	<p class="owners">Ovel Heslop . Tajhna McCourtie . Ruel Andrews . Cordel Reid</p>
</div>
</body>
</html>