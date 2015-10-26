<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h3 class="col-lg-4 col-lg-offset-4">
<c:if test="${not empty user}">
    Hello ${user.firstname} ${user.lastname} !
</c:if>
</h3>

<p class="col-xs-12 col-lg-4 col-lg-offset-4">Welcome in the Overbooking website !</p>
