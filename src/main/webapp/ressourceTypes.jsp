<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>RessourceTypes list</h1>
<table id="table-ressourceTypes" class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="ressourceType" items="${requestScope.ressourceTypes}">
        <tr>
            <td class="id">${ressourceType.id}</td>
            <td>${ressourceType.name}</td>
            <td><a class="edit" href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
            <td><a class="delete" href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
        </tr>
    </c:forEach>
</table>
