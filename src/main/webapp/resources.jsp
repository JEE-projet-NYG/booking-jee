<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="WEB-INF/jspf/resourcesModals.jspf" %>
<h2 class="col-lg-4 col-lg-offset-4">Resources list <button type="button" class="btn btn-primary btn-circle btn-lg createResource"><i class="glyphicon glyphicon-plus"></i></button></h2>
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
            <input name="responsibleId" name="responsibleId" type="hidden" value="${resource.responsible.id}"/>
            <input name="resourceTypeId" name="resourceTypeId" type="hidden" value="${resource.type.id}"/>
            <td class="id">${resource.id}</td>
            <td class="name">${resource.name}</td>
            <td class="description">${resource.description}</td>
            <td class="localisation">${resource.localisation}</td>
            <td class="responsible">${resource.responsible.login}</td>
            <td class="resourceType">${resource.type.name}</td>
            <td><a class="edit" href="#"><i class="glyphicon glyphicon-pencil"></i></a></td>
            <td><a class="delete" href="#"><i class="glyphicon glyphicon-trash"></i></a></td>
        </tr>
    </c:forEach>
</table>
