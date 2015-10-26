<%@ page import="config.Config" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function() {
        $('#dateMin').datetimepicker({ format: 'Y-m-d H:i' });
        $('#dateMax').datetimepicker({ format: 'Y-m-d H:i' });
    });
</script>

<div class="row">
    <h3 class="col-sm-12">Réserver une ressource</h3>
</div>

<form id="fakeForm" class="form-horizontal" method="get" action="/<%= Config.APP_NAME %>/reservation">
    <div class="row">
    <div class="form-group col-md-8">
        <label for="selType" class="col-md-offset-3">Type de bien à réserver : </label>
        <select id="selType" name="selType" class="form-control col-md-8 col-md-offset-3" required>
            <c:forEach items="${requestScope.resType}" var="type">
                <c:choose>
                    <c:when test="${type.name.equals(requestScope.selType)}">
                        <option value="${type.name}" selected="selected">${type.name}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${type.name}">${type.name}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <div class="form-group col-md-8">
        <label for="dateMin" class="col-md-offset-3">Date de début : </label>
        <input type="text" name="dateMin" id="dateMin" value="${requestScope.dateMin}" class="form-control col-md-offset-3"  required>
    </div>
    <div class="form-group col-md-8">
        <label for="dateMax" class="col-md-offset-3">Date de fin : </label>
        <input type="text" name="dateMax" id="dateMax" value="${requestScope.dateMax}" class="form-control col-md-offset-3" required>
    </div>
    <p id="dateError">${requestScope.dateError}</p>
        </div>
    <div class="row">
        <button type="submit" class="btn btn-default col-md-2 col-md-offset-5">Rechercher</button>
    </div>
</form>
<form id="formReservation" method="post" action="/<%= Config.APP_NAME %>/reservation" class="form-horizontal">
    <div class="row">
        <input type="hidden" name="dateStart" id="dateStart" value="${requestScope.dateMin}">
        <input type="hidden" name="dateEnd" id="dateEnd" value="${requestScope.dateMax}">
        <c:choose>
            <c:when test="${empty requestScope.avRes}">
                <label class="col-md-5 col-md-offset-3">Ressource : </label>
                <p class="col-md-5 col-md-offset-3">Pas de ressource disponible pour ces paramètres</p>
            </c:when>
            <c:otherwise>
                <div class="form-group col-md-8">
                    <label for="resources" class="col-md-offset-3">Ressource : </label>
                    <select id="resourceId" name="resourceId" class="col-md-offset-3 form-control">
                        <c:forEach items="${requestScope.avRes}" var="resource">
                            <option value="${resource.id}" required><span class="resTitle">${resource.name}</span> : ${resource.description}</option>
                        </c:forEach>
                    </select>
                </div>
                <button id="btnResa" type="submit" class="btn btn-success col-md-2 col-md-offset-5">Réserver</button>
            </c:otherwise>
        </c:choose>
    </div>
</form>
