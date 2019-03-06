<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Invalid Login</title>
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
		</table>
		<button type="submit" class="button" style="vertical-align:middle"><span>Submit </span></button>
		
		<table align="center">
		<tr>
		<td>
		 <a href="signup.jsp" class="button" style="vertical-align:middle"><span>Signup</span></a></td>
		 <td><td ><a href="forgetpassword.jsp" class="button" style="vertical-align:middle"><span>forgetpassword</span></a> </td>
		 	</td>
		 </tr>
		 </table>
	</form>
</body>
</html>