<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course contents</title>
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
	<div align="center">
		<a href="LogoutServlet">Logout</a>
			
	</div>
	<form method="post" action="CourseServlet">
		<table align="center">
			<div align="center">
				<h1>The course list</h1>
				Select to start quiz
			</div>
			<tr>
				<td><input type="radio" name="coursetype" value="c"> C</td>
			</tr>
			<tr>
				<td><input type="radio" name="coursetype" value="java">
					JAVA</td>
			</tr>
			<tr>
				<td><input type="radio" name="coursetype" value="html">
					HTML</td>
			</tr>
			<table>
				<table align="center">
					<tr>
						<td>
							<button type="submit" style="background-color:lightblue; color:black;">Click to Start</button>
						</td>
					</tr>
				</table>

				</form>
</body>
</html>