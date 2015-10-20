<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Over Booking</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>

    </head>

    <body>
        <div class="container-fluid">
            <!-- HEADER -->
            <%@ include file="WEB-INF/jspf/header.jspf" %>

            <!-- MENU -->
            <%@ include file="WEB-INF/jspf/menu.jspf" %>

            <!-- BODY -->
            <jsp:include page="${requestScope.page}"/>

            <!-- MODALES -->
            <%@ include file="WEB-INF/jspf/modals.jspf" %>

            <!-- MESSAGE -->
            <%@ include file="WEB-INF/jspf/message.jspf" %>

            <!-- FOOTER -->
            <%@ include file="WEB-INF/jspf/footer.jspf" %>
        </div>
    </body>

</html>

