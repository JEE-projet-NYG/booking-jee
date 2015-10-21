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
            <div class="row">
                <%@ include file="WEB-INF/jspf/header.jspf" %>
            </div>

            <!-- MENU -->
            <div class="row">
                <%@ include file="WEB-INF/jspf/menu.jspf" %>
            </div>

            <!-- BODY -->
            <div class="row">
                <jsp:include page="${requestScope.page}"/>
            </div>

            <!-- MODALS -->
            <%@ include file="WEB-INF/jspf/modals.jspf" %>

            <!-- MESSAGE -->
            <div class="row">
                <%@ include file="WEB-INF/jspf/message.jspf" %>
            </div>

            <!-- FOOTER -->
            <div class="row">
                <%@ include file="WEB-INF/jspf/footer.jspf" %>
            </div>

        </div>
    </body>

</html>

