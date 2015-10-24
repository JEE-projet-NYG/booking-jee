<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script>
    $(function() {
        $('#dateMin').datetimepicker({ format: 'Y-m-d H:i' });
        $('#dateMax').datetimepicker({ format: 'Y-m-d H:i' });
    });
</script>

<form id="fakeForm">
    <div class="form-group">
        <label for="resType" class="col-lg-2 col-sm-offset-1">Type de bien à réserver : </label>
        <select id="resType" name="resType" class="col-lg-8">
            <c:forEach items="${requestScope.resType}" var="type">
                <c:if test="${type.name==pageContext.request.getAttribute('resType')}">
                    <option value="${type.name}" selected="selected">${type.name}</option>
                </c:if>
                <option value="${type.name}">${type.name}</option>
            </c:forEach>
        </select>
    </div>
    <div class="form-group">
        <label for="dateMin">Date de début : </label>
        <input type="text" name="dateMin" id="dateMin" value="${pageContext.request.getAttribute("dateMin")}">
    </div>
    <div class="form-group">
        <label for="dateMax">Date de fin : </label>
        <input type="text" name="dateMax" id="dateMax" value="${pageContext.request.getAttribute("dateMax")}">
    </div>
</form>
<form id="formReservation" method="post" action="/form/reservation">
    <input type="hidden" name="dateStart" id="dateStart" value="${pageContext.request.getAttribute("dateMin")}">
    <input type="hidden" name="dateEnd" id="dateEnd" value="${pageContext.request.getAttribute("dateMax")}">
    <div class="form-group">
        <label for="resourceId" class="col-lg-2 col-sm-offset-1">Ressource : </label>
        <select id="resourceId" name="resourceId" class="col-lg-8">

        </select>
    </div>
</form>
