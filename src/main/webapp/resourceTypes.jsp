<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>ResourceTypes list</h1>
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
            <td>${resourceType.name}</td>
            <td><a class="editResourceType" href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
            <td><a class="deleteResourceType" href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
        </tr>
    </c:forEach>
</table>
