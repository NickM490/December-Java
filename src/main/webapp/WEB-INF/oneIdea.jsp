<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <!-- c:out ; c:forEach ; c:if -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
   <!-- Formatting (like dates) -->
 <%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
   <!-- form:form -->
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  
   <!-- for rendering errors on PUT routes -->
 <%@ page isErrorPage="true" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Title Here</title>
  <!-- Bootstrap -->
  <link rel="stylesheet"
    href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
    crossorigin="anonymous">
</head>
<body>
	<a href="/newIdea">New Idea</a>
	<a href="/editIdea">Edit Idea</a>
	<a href="/oneIdea">One Idea</a>
	<a href="/dashboard">Dashboard</a>
    <div class="container"> <!-- Beginning of Container -->
        <h1>See One Idea</h1>
        <h4> <c:out value="${idea.name}"></c:out> </h4>
        <br>
       	<h3>Location</h3>
       	<p> <c:out value="${idea.location}"></c:out></p>
       	<br>
       	<h4>Number of Days</h4>
       	<p> <c:out value="${idea.days}"></c:out></p>
       	<br>
       	<h4>Description</h4>
        <p> <c:out value="${idea.description}"></c:out></p>
    </div> <!-- End of Container -->
</body>
</html>
