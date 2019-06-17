<%@page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
<h2>api Hello World!</h2>


<c:forEach items="${users}" var="user">
    <c:out value="${user.userName}"></c:out>
    <c:out value="${user.age}"></c:out>
</c:forEach>
</body>
</html>
