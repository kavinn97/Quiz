<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Signup</title>
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
		<h2>
			<font color="red"> ${message}</font>
		</h2>
		<table align="center">
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" autofocus pattern="[a-zA-Z0-9]+"></td>
			</tr>
			<tr>
				<td>Date of birth:</td>
				<td><input type="date" name="dob" min="1970-01-01" max="2010-01-01"></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td><input type="radio" value="male" name="gender">male
					<input type="radio" value="female" name="gender">female <input
					type="radio" value="other" name="gender">other</td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" placeholder="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" 
				>
				</td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					placeholder="password" title="8-20 Characters,A-Z,a-z & Special characters only allowed"
			pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}" ></td>
			</tr>
			<tr>
				<td>
					<button type="submit" class="button" style="vertical-align: middle">
						<span>Signup </span>
					</button>
				</td>
			</tr>
			</form>
</body>
</html>