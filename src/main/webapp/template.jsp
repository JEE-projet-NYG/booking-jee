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
        <!-- HEADER -->
        <%@ include file="WEB-INF/jspf/header.jspf" %>
    
        <div class="container-fluid">

            <!-- MENU -->
            <div class="row">
                <%@ include file="WEB-INF/jspf/menu.jspf" %>
            </div>

            <!-- BODY -->
            <jsp:include page="${requestScope.page}"/>

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

