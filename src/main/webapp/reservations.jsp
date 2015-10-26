<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3 class="col-lg-4 col-lg-offset-4">Reservations list</h3>

<script>
    $(function() {
        $('#timePickerMin').datetimepicker({ format: 'Y-m-d H:i' });
        $('#timePickerMax').datetimepicker({ format: 'Y-m-d H:i' });
    });
</script>

<form class="col-sm-12 col-lg-6 col-lg-offset-3">
    <p>From : <input type="text" name="timePickerMin" id="timePickerMin" value="${pageContext.request.getParameter("timePickerMin")}"> To : <input type="text" name="timePickerMax" id="timePickerMax" value="${pageContext.request.getParameter("timePickerMax")}"> <button type="submit" class="btn btn-default">Search</button></p>
</form>


<table id="table-reservations" class="table table-striped table-hover table-condensed">
    <tr>
        <td>Id</td>
        <td>Start</td>
        <td>End</td>
        <td>Borrower</td>
        <td>Resource</td>
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
            <td class="borrower">${reservation.borrower.login}</td>
            <td class="resource">${reservation.resource.name}</td>
            <td><a class="cancel" href="#"><i class="glyphicon glyphicon-remove-circle"></i></a></td>
        </tr>
    </c:forEach>
</table>