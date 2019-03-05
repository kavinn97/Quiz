<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
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
	<h1>Welcome to signup</h1>
	<form action="SignupServlet" method="post">
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" autofocus></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><input type="number" name="age"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" value="male" name="gender">male
					<input type="radio" value="female" name="gender">female <input
					type="radio" value="other" name="gender">other</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" placeholder="Enter email">
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					placeholder="enter password"></td>
			</tr>
			<tr>
				<td>
					<button type="submit" style="background-color:lightblue; color:black;">signup</button>
				</td>
			</tr>
			</form>
</body>
</html>