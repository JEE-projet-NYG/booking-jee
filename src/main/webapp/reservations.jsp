<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1>Reservations list</h1>

<script>
    $(function() {
        $('#datetimepicker').datetimepicker();
    });
</script>

<p>Date: <input type="text" id="datetimepicker"></p>


<table id="table-reservations" class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Start</td>
        <td>End</td>
        <td>Borrower</td>
        <td>Resource</td>
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
            <td class="borrower">${reservation.borrower.login}</td>
            <td class="ressource">${reservation.ressource.name}</td>
        </tr>
    </c:forEach>
</table>
