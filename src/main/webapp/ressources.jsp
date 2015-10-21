<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Ressources list</h1>
<table id="table-ressources" class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Description</td>
        <td>Localisation</td>
        <td>Responsible</td>
        <td>Type</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="ressource" items="${requestScope.ressources}">
        <tr>
            <td class="id">${ressource.id}</td>
            <td>${ressource.name}</td>
            <td>${ressource.description}</td>
            <td>${ressource.localisation}</td>
            <td>${ressource.responsible.lastname} ${ressource.responsible.firstname}</td>
            <td>${ressource.type.name}</td>
            <td><a class="edit" href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
            <td><a class="delete" href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
        </tr>
    </c:forEach>
</table>
