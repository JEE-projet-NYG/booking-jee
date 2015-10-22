<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/jspf/resourcesModals.jspf" %>
<h1>Resources list <button type="button" class="btn btn-primary btn-circle btn-lg createResource"><i class="glyphicon glyphicon-plus"></i></button></h1>
<table id="table-resources" class="table table-striped table-hover table-condensed">
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
    <c:forEach var="resource" items="${requestScope.resources}">
        <tr>
            <td class="id">${resource.id}</td>
            <td>${resource.name}</td>
            <td>${resource.description}</td>
            <td>${resource.localisation}</td>
            <td>${resource.responsible.lastname} ${resource.responsible.firstname}</td>
            <td>${resource.type.name}</td>
            <td><a class="edit" href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
            <td><a class="delete" href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
        </tr>
    </c:forEach>
</table>
