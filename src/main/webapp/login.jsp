
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%String message=(String)request.getAttribute("message"); %>
<%if(message!=null){ %>
<%=message %>
<%} %>


<br>
<h1>Login page</h1>

<form action="login"  method ="post" >
Email:<input type="text" name= "email">
password:<input type="password" name="pwd">
Submit :<input type="submit"  value="submit" >


</form>

</body>
</html>