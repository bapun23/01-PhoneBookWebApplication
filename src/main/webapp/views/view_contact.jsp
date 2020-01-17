<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AllContactPage</title>
<script type="text/javascript">
		function confirmDelete() {
			return confirm("Are You Sure Want To Delete ??");
		}
	</script>
</head>
<body bgcolor="black">
	<h1 style="color: red; text-align: center;">All Contact Details</h1>

	<h3 style="text-align: center;">
		<a href="addContact" style="color: White;">+Add New Contact</a>
	</h3>
	<c:choose>
	<c:when test="${!empty contact }">
	
	<table border="09"
		style="border-color: yellow; align-content: center; width: 50%; height: 250%; border-style: inset"
		align="center">
		<thead>
			<tr style="background-color: purple; color: red;">
				<td align="center">sr.NO</td>
				<td align="center">Contact Name</td>
				<td align="center">Contact Email_Id</td>
				<td align="center">Contact Mobile No</td>
				<td align="center">Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contact }" var="c" varStatus="loop">
				<tr
					style="color: white; border-color: lime; background-color: teal; align-content: center;">
					<td align="center">${loop.index+1 }</td>
					<td align="center">${c.contactName }</td>
					<td align="center">${c.contactEmail }</td>
					<td align="center">${c.phoneNo }</td>
					<td align="center"><a href="editContact?cId=${c.contactId }"
						style="color: lime;">EDIT</a> &nbsp;&nbsp;&nbsp; <a
						onclick="return confirmDelete()"
						href="deleteContact?cId=${c.contactId }" style="color: red;">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:when>
	<c:otherwise>
			<h1 style="color: blue; text-align: center">No Contact Record's Found...!!</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>