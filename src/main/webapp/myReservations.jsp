<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h2 class="col-lg-4 col-lg-offset-4">My reservations list</h2>

<table id="table-reservations" class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Start</td>
        <td>End</td>
        <td>Resource</td>
        <td>Resource type</td>
        <td>Cancel</td>
    </tr>
    <c:forEach var="reservation" items="${requestScope.reservations}">
        <tr>
            <td class="id">${reservation.id}</td>
            <td class=dateStart">
                <fmt:formatDate value="${reservation.dateStart}" type="date" pattern="yyyy-MM-dd HH:mm" />
            </td>
            <td class=dateEnd">
                <fmt:formatDate value="${reservation.dateEnd}" type="date" pattern="yyyy-MM-dd HH:mm" />
            </td>
            <td class="resource">${reservation.resource.name}</td>
            <td class="resourceType">${reservation.resource.type.name}</td>
            <td><a class="cancel" href="#"><i class="glyphicon glyphicon-remove-circle"></i></a></td>
        </tr>
    </c:forEach>
</table>
