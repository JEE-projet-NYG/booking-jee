<%@ page import="config.Config" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h3 class="col-lg-3 col-lg-offset-5">Identification</h3>
<form id="loginForm" class="form-horizontal col-sm-10 col-sm-offset-1" method="post" action="${pageContext.request.contextPath}/<%= Config.APP_NAME %>/login">
    <div class="form-group">
        <label class="control-label" for="login">Login : </label>
        <input id="login" name="login" type="text" placeholder="Login" class="form-control" required/>
    </div>
    <div class="form-group">
        <label class="control-label" for="password">Password : </label>
        <input id="password" name="password" type="password" placeholder="Password" class="form-control" required/>
    </div>
    <p class="red-error col-xs-12">${requestScope.loginError}</p>
    <button class="btn btn-success col-xs-2 col-xs-offset-5" type="submit">Log in</button>
</form>