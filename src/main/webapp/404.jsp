<%@ page import="config.Config" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="error-template">
                <h1>
                    Oops!</h1>

                <h2>
                    404 Not Found</h2>

                <div class="error-details">
                    Sorry, an error has occurred, Requested page not found!
                </div>
                <div class="error-actions">
                    <a href="${pageContext.request.contextPath}/<%= Config.APP_NAME %>/"
                       class="btn btn-primary btn-lg"><span class="glyphicon glyphicon-home"></span>
                        Take Me Home </a>
                </div>
            </div>
        </div>
    </div>
</div>

