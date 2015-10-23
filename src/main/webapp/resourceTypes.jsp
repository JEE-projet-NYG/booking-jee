<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/jspf/resourceTypesModals.jspf" %>
<h1>ResourceTypes list <button type="button" class="btn btn-primary btn-circle btn-lg createResourceType"><i class="glyphicon glyphicon-plus"></i></button></h1>
<table id="table-resourceTypes" class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="resourceType" items="${requestScope.resourceTypes}">
        <tr>
            <td class="id">${resourceType.id}</td>
            <td class="name">${resourceType.name}</td>
            <td><a class="edit" href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
            <td><a class="delete" href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
        </tr>
    </c:forEach>
</table>
