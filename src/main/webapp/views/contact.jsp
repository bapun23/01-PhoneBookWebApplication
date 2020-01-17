<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body bgcolor="black">
	<h1 style="color: Red; text-align: center; text-decoration: blink;">Phone
		Book Web Applications</h1>
		
	<form:form method="POST" modelAttribute="contact" action="saveContact">
	<br><br><br>
		<h3 style="color: green; text-align: center;">${result}</h3>
		<table border="9"
			style="border-style: inset; background-color: red; border-color: lime; color: white; width: 30%;"
			align="center">
			<form:hidden path="contactId" />
			<tr height="50">
				<td align="center">Enter Contact Name ::</td>
				<td align="center"><form:input path="contactName" /></td>
			</tr>
			<tr height="50">
				<td align="center">Enter Contact Email ID ::</td>
				<td align="center"><form:input path="contactEmail" /></td>
			</tr>
			<tr height="50">
				<td align="center">Enter Mobile Number ::</td>
				<td align="center"><form:input path="phoneNo" /></td>
			</tr>
			<tr height="50">
				<td align="center"><input type="reset" value="Reset"
					style="color: red; background-color: black; height: 100%; width: 50%"></td>
				<td align="center"><input type="submit" value="Save Contact"
					style="color: green; background-color: black; height: 100%; width: 50%"></td>
			</tr>
		</table>

	</form:form>
	<h3 style="text-align: center">
		<a href="findAllContact" style="color: fuchsia;">Show All Contact Details </a>
	</h3>
</body>
</html>