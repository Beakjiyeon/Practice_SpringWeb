<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" import="java.util.*"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>
		백지연
		<c:out value="백지연">></c:out>
		<c:out value="${exception.getMessage()}"></c:out>
		<hr/>
		<ul>
		<!-- 예외객체에서 stack 항목을모두  꺼내와서 items에 담고 -->
		<!-- stack이라는 변수를 이용해서 하나씩 꺼내와서 처리해라 -->
		<c:forEach items="${exception.getStackTrace() }" var="stack">
		 <li><c:out value="${stack}"></c:out></li> 
		 </c:forEach>
		
	</h4>

</body>
</html>