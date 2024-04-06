<%@page import="in.co.rays.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
</head>
<body>
<%@ include file="Header.jsp" %>

	<h2>
		<a href="EmployeeListCtl">Back</a>
	</h2>
	<%
		EmployeeDTO dto = (EmployeeDTO) request.getAttribute("dto");
		String msg = (String) request.getAttribute("msg");
	%>
	<form action="EmployeeCtl" method="post">
		<center>
			<%
				if (dto != null) {
			%>
			<h1>Edit Employee</h1>
			<%
				} else {
			%>
			<h1>Add Employee</h1>
			<%
				}
			%>
			<%
				if (msg != null) {
			%>
			<%=msg%>
			<%
				}
			%>


			<table>
				<input type="hidden" name="id"
					value="<%=(dto != null) ? dto.getId() : ""%>">


				<tr>
					<th>Name:</th>
					<td><input type="text" name="name"
						value="<%=(dto != null) ? dto.getName() : ""%>"></td>
				</tr>

				<tr>
					<th>Date:</th>
					<td><input type="text" name="dob"
						value="<%=(dto != null) ? dto.getDob() : ""%>"></td>
				</tr>



				<tr>
					<th>Address:</th>
					<td><input type="text" name="address"
						value="<%=(dto != null) ? dto.getAddress() : ""%>"></td>
				</tr>

				<tr>
					<th>Salary:</th>
					<td><input type="text" name="salary"
						value="<%=(dto != null) ? dto.getSalary() : ""%>"></td>
				</tr>

				<tr>
					<th>Company:</th>
					<td><input type="text" name="company"
						value="<%=(dto != null) ? dto.getCompany() : ""%>"></td>
				</tr>


			</table>
			<table>
				<%
					if (dto != null) {
				%>
				<tr>
					<td><input type="submit" name="operation" value="update"></td>
					<td><input type="submit" name="operation" value="AddEmploye"></td>

				</tr>
				<%
					} else {
				%>
				<tr>
					<td><input type="submit" name="operation" value="save"></td>
					<td><input type="submit" name="operation" value="cancel"></td>
				</tr>
				<%
					}
				%>

			</table>
</body>
</html>