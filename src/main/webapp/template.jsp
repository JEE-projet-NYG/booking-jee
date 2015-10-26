<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Over Booking</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery.datetimepicker.css"/>

        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.datetimepicker.full.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
    </head>

    <body>

        <!-- MODALS -->
        <%@ include file="WEB-INF/jspf/modals.jspf" %>

        <!-- HEADER -->
        <%@ include file="WEB-INF/jspf/header.jspf" %>
    
        <div class="container-fluid">

            <!-- BODY -->
            <jsp:include page="${requestScope.page}"/>

            <!-- FOOTER -->
            <div class="row">
                <%@ include file="WEB-INF/jspf/footer.jspf" %>
            </div>

            <script type="text/javascript" src="${pageContext.request.contextPath}/js/main.js"></script>
        </div>
    </body>

</html>

