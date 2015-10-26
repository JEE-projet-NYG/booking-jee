<%@ page import="config.Config" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function() {
        $('#dateMin').datetimepicker({ format: 'Y-m-d H:i' });
        $('#dateMax').datetimepicker({ format: 'Y-m-d H:i' });
    });
</script>

<form id="fakeForm" class="row" method="get" action="/<%= Config.APP_NAME %>/reservation">
    <div class="form-group">
        <label for="selType" class="col-lg-2 col-sm-offset-1">Type de bien à réserver : </label>
        <select id="selType" name="selType" class="col-lg-8" required>
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
    <div class="form-group">
        <label for="dateMin" class="col-lg-2 col-sm-offset-1">Date de début : </label>
        <input type="text" name="dateMin" id="dateMin" value="${requestScope.dateMin}" class="col-lg-8" required>
    </div>
    <div class="form-group">
        <label for="dateMax" class="col-lg-2 col-sm-offset-1">Date de fin : </label>
        <input type="text" name="dateMax" id="dateMax" value="${requestScope.dateMax}" class="col-lg-8" required>
    </div>
    <p class="red-error">${requestScope.dateError}</p>
    <button type="submit" class="btn btn-default col-sm-2 col-sm-offset-6">Rechercher</button>
</form>
<form id="formReservation" method="post" action="/<%= Config.APP_NAME %>/reservation" class="row">
    <input type="hidden" name="dateStart" id="dateStart" value="${requestScope.dateMin}">
    <input type="hidden" name="dateEnd" id="dateEnd" value="${requestScope.dateMax}">
    <c:choose>
        <c:when test="${requestScope.avRes==null}">

        </c:when>
        <c:when test="${requestScope.avRes.size()==0}">
            <label class="col-lg-2 col-sm-offset-1">Ressource : </label>
            <p class="col-lg-8">Pas de ressource disponible pour ces paramètres</p>
        </c:when>
        <c:otherwise>
            <div class="form-group">
                <label for="resources" class="col-lg-2 col-sm-offset-1">Ressource : </label>
                <div id="resources" class="col-lg-8">
                    <c:forEach items="${requestScope.avRes}" var="resource">
                        <input type="radio" name="resourceId" value="${resource.id}" required>&nbsp <span class="resTitle">${resource.name}</span> : ${resource.description}</input>
                    </c:forEach>
                </div>
            </div>
            <button id="btnResa" type="submit" class="btn btn-success col-sm-3 col-sm-offset-4">Réserver</button>
        </c:otherwise>
    </c:choose>
</form>
