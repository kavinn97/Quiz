<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invalid Login</title>
</head>
<style>
body {
background-image: url('pic.png');
background-size: 100%;
background-repeat: repeat-y;
background-attachment: fixed;
height: 100%;
width: 105%;
}
</style>
<body align="center" style="padding-top: 100px;">
	<form action="LoginServlet" method="post">
	<table align="center">
		<h1>Incorrect Email or password!!!</h1>
		<tr>
		<td>
		email: </td>
		<td><input type="email" autofocus name="email"
			placeholder="enter email"> </td>
			</tr>
			<tr></tr>
			<tr></tr>
			<tr>
			<td>
			password:</td>
			<td> <input type="password"
			name="password" placehoder="enter password"></td>
			</tr>
		<tr>
		<td>
		<button type="reset">reset</button></td>
		<td><button type="submit" style="background-color:lightblue; color:black;">submit</button></td>
		</table>
		<table align="center">
		<tr>
		<td>
		 Newuser??? <a href="signup.jsp">Signup!!!</a></td>
		 </tr>
		 </table>
	</form>
</body>
</html>