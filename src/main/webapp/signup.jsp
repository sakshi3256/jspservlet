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

<form action="sakshi">


Id:<input type="number" name="id"> <br>

name:<input type="text" name="name"><br>
email:<input type="email" name="email"><br>
address:<input type="text" name="address"><br>
password:<input type="password" name="pwd"><br>
phoneno:<input type="text" name="phone"><br>
Submit :<input type="submit"  value="submit" >

</form>
</body>
</html>
