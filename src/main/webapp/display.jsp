

<%@ page import="java.util.List" %>
<%@ page import="firstjsp.dto.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display</title>
</head>
<body bgcolor="yellow">
<%List<Student> students =(List) request.getAttribute("list"); %>
<table>
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Password</th>
<th>Address</th>
<th>PhoneNo</th>
<th>Fees</th>
</tr>

<%for(Student stu:students){ %>
<tr>
<td><%=stu.getStdid()%></td>
<td><%=stu.getName() %></td>
<td><%=stu.getEmail() %></td>
<td><%=stu.getPassword() %></td>
<td><%=stu.getAddress() %></td>
<td><%=stu.getPhone() %></td>
<td><%=stu.getFees() %></td>
<td> <a href="delete?id=<%=stu.getStdid() %>">DELETE</a></td>
<td><a href= "update?id=<%=stu.getStdid() %>">UPDATE</a></td>
</tr>
<%} %>

</table>
</body>
</html>