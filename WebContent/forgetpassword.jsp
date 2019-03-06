<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Password Reset</title>
<style>
.button {
  display: inline-block;
  border-radius: 4px;
  background-color: #3C37DC;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 15px;
  padding: 15px;
  width: 100px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
</head>
<body align="center" style="padding-top:130px;">
<form action="ForgetpasswordServlet" method="post">

<h1>Forget Password</h1>
<table align="center">
<tr>
<td>Email:</td>
				<td><input type="email" name="email" placeholder="Enter email"></td></tr>
<tr><td>Date of birth:</td>			
				<td><input type="date" name="dob"></td></tr>
<tr><td>New Password:</td>
				<td><input type="password" name="newpassword" placeholder="new password"></td></tr>
				
</table>
<br>
<button type="submit"> submit</button>
</form>
</body>
</html>