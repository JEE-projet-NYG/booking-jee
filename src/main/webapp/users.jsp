<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Users list <button type="button" class="btn btn-primary btn-circle btn-lg create"><i class="glyphicon glyphicon-plus"></i></button>
</h1>
<table id="table-users" class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Login</td>
        <td>Password</td>
        <td>Lastname</td>
        <td>Firstname</td>
        <td>Mail address</td>
        <td>Phone number</td>
        <td>Admin</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="user" items="${requestScope.users}">
        <tr>
            <td class="id">${user.id}</td>
            <td class="login">${user.login}</td>
            <td class="password">${user.password}</td>
            <td class="lastname">${user.lastname}</td>
            <td class="firstname">${user.firstname}</td>
            <td class="mailAddress">${user.mailAddress}</td>
            <td class="phoneNumber">${user.phoneNumber}</td>
            <td class="admin">
                <i class="glyphicon
                    <c:choose>
                        <c:when test="${user.admin == 'true'}">
                            glyphicon-check
                        </c:when>
                        <c:otherwise>
                            glyphicon-unchecked
                        </c:otherwise>
                    </c:choose>
                "></i>
            </td>

            <td><a class="edit" href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
            <td><a class="delete" href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
        </tr>
    </c:forEach>
</table>
