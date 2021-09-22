<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>JSP - User Details</title>
</head>
<body>

<br/>
<table>
    <thead>
    <tr>
        <th>User ID</th>
        <th>User Name</th>
        <th>Salary</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${userList}">
        <tr>
            <td> <c:out value="${user.userId}" /></td>
            <td> <c:out value="${user.userName}" /></td>
            <td> <c:out value="${user.salary}" /></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>