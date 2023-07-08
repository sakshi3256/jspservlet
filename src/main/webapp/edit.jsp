
<%@ page import="firstjsp.dto.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Student student = (Student)request.getAttribute("student"); %>
<form action="edit" method="post">
Id:<input type= "number" name="id" value= "<%=student.getStdid()%>"  readonly= "readonly"> 
<br>
Name:<input type="text" name= "name">
<br>
Email:<input type= "email" name= "email">
<br>
Password:<input type= "password" name= "password">
<br>
Phone:<input type= "text" name= "phone">
<br>
Address:<input type= "text" name= "address">
<br>
<br>

<input type= "submit" value= "EDIT">



</form>
</body>
</html>