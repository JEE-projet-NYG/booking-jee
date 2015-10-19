<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<html>

    <head>
        <title>Over Booking</title>
        <link rel="stylesheet" href="bootstrap/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/style.css"/>
    </head>

    <body>
        <div class="container-fluid">
            <!-- HEADER -->
            <%@ include file="WEB-INF/jspf/header.jspf" %>

            <!-- MENU -->
            <%@ include file="WEB-INF/jspf/menu.jspf" %>

            <!-- BODY -->
            <jsp:include page="${requestScope.page}"/>

            <!-- MESSAGE -->
            <%@ include file="WEB-INF/jspf/message.jspf" %>

            <!-- FOOTER -->
            <%@ include file="WEB-INF/jspf/footer.jspf" %>
        </div>

        <script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/main.js"></script>
    </body>

</html>

