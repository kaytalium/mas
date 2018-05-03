<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<div align="center">
<form action="Registration" method="post">
First Name  <input type="text" name="fname" placeholder="John" required="required">
Last Name  <input type="text" name="lname" placeholder="Doe" required="required">
Email  <input type="email" name="usname" placeholder="johndoe@email.com" required="required">
Password  <input type="password" name="pword" required="required">
<input type="submit" value="Register">
</form>

</div>

</body>
</html>