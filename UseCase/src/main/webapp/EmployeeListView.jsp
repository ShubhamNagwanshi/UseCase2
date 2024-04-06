<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="in.co.rays.dto.EmployeeDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee List</title>
</head>
<body>
<form action="EmployeeListCtl" method="post">
	<%
		EmployeeDTO dto = new EmployeeDTO();
		List list = (List) request.getAttribute("List");
		Iterator it = list.iterator();
	%>


	<table>
		<center>

			</tr>
	</table>
	<h1>Employee List</h1>
	<tr>
		<th>Name :</th>
		<td><input type="text" name="name"></td>
		<td><input type="submit" name="operation" value="search">
		</td>
	</tr>
	</table>
	</td>
	<tr>

		<table border="1" width="100%" align="center" cellpadding=6px>
			<tr style="background:">
				<th>SelectAll</th>
				<th>Id</th>
				<th>name</th>
				<th>Date</th>
				<th>Address</th>
				<th>Salary</th>
				<th>Company</th>
				<th>Edit</th>

			</tr>


			<%
				while (it.hasNext()) {
					dto = (EmployeeDTO) it.next();
			%>


			<tr>
				<td><input type="checkbox" name="ids" value="<%=dto.getId()%>"></td>
				<td><%=dto.getId()%></td>
				<td><%=dto.getName()%></td>
				<td><%=dto.getDob()%></td>
				<td><%=dto.getAddress()%></td>
				<td><%=dto.getSalary()%></td>
				<td><%=dto.getCompany()%></td>

				<td><a href="EmployeeCtl?id=<%=dto.getId()%>">edit</a></td>

				<%
					}
				%>
			</tr>

		</table>
	<table>
		<tr>
			<td><input type="submit" name="operation" value="delete">
			</td>
			</center>
		</tr>
		</center>
	</table>
	</form>
</body>
</html>