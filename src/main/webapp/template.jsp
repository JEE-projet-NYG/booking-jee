<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<html>
<head>
    <title>Judo web application</title>
</head>

<!-- HEADER -->
<table>
    <tr>
        <td class="header" colspan="2">
            <%@ include file="WEB-INF/jspf/header.jspf" %>
        </td>
    </tr>
</table>

<!-- HEADER2 -->
<table>
    <tr>
        <td class="header" colspan="2">
            <%@ include file="WEB-INF/jspf/header2.jspf" %>
        </td>
    </tr>
</table>


<!-- MENU -->
<table>
    <tr>
        <td class="menu" colspan="2">
            <%@ include file="WEB-INF/jspf/menu.jspf" %>
        </td>
    </tr>
</table>

<!-- BODY -->
<table>
    <tr>
        <td class="page" colspan="2">
            <jsp:include page="${requestScope.page}"/>
        </td>
    </tr>
</table>

<!-- MESSAGE -->
<table>
    <tr>
        <td class="message" colspan="2">
            <%@ include file="WEB-INF/jspf/message.jspf" %>
        </td>
    </tr>
</table>

<!-- FOOTER -->
<table>
    <tr>
        <td class="footer" colspan="2">
            <%@ include file="WEB-INF/jspf/footer.jspf" %>
        </td>
    </tr>
</table>

</html>

