<%@page import="com.sudha.Customer" %>
<%!Customer customer = null;%>

<%
customer = (Customer)request.getAttribute("customer");
%>

<html>
<body>
	<h2>Sudha Java Real Time</h2>
	<h3>Customer Details</h3>
	<table border="1">
	
		<tr>
			<td>Customer Id</td>
			<td><%=customer.getCid()%></td>
		</tr>
		<tr>
			<td>Customer Name</td>
			<td><%=customer.getCname()%></td>
		</tr>
		<tr>
			<td>Customer Address</td>
			<td><%=customer.getCaddr()%></td>
		</tr>
		<tr>
			<td>Customer Email</td>
			<td><%=customer.getCemail()%></td>
		</tr>
		<tr>
			<td>Customer Mobile</td>
			<td><%=customer.getCmobile()%></td>
		</tr>
	</table>
	<h3>
		<a href="./searchform.html">|Customer Search Form|</a>
	</h3>
</body>
</html>