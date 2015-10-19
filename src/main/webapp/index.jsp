<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>YO ! </h1>
<table>
    <tr>
        <td>Id</td>
        <td>Date</td>
        <td>Nom</td>
        <td>Ville</td>
        <td>Adresse</td>
        <td>Département</td>
    </tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
