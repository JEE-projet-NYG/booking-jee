<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Users list</h1>
<table class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Login</td>
        <td>Password</td>
        <td>Lastname</td>
        <td>Firstname</td>
        <td>Mail address</td>
        <td>Phone number</td>
        <td>Admin</td>
    </tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td>${user.id}</td>
            <td>${user.login}</td>
            <td>${user.password}</td>
            <td>${user.lastname}</td>
            <td>${user.firstname}</td>
            <td>${user.mailAddress}</td>
            <td>${user.phoneNumber}</td>
            <td>${user.admin}</td>
        </tr>
    </c:forEach>
</table>
