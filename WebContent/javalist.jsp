<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java quiz</title>
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
<body><div align="center">
	<a href="LogoutServlet">Logout</a>
	</div>
	<form action="ResultServlet" method="post">
		<table>
			<c:forEach var="showquestions" items="${java}">
				<tr>
					<td>${showquestions.questions}</td>
					<td><input type="radio" name=${showquestions.quenum }
						value="a">${showquestions.option1 }</td>
					<td><input type="radio" name=${showquestions.quenum }
						value="b">${showquestions.option2}</td>
				</tr>
			</c:forEach>
		</table>
		<button type="submit" style="background-color:lightblue; color:black;">GetResult</button>
	</form>

</body>
</html>