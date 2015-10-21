<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form id="loginForm" class="form-horizontal" method="post" action="/login">
    <div class="form-group">
        <label class="control-label" for="login">Login : </label>
        <input id="login" name="login" type="text" placeholder="Login" class="form-control"/>
    </div>
    <div class="form-group">
        <label class="control-label" for="password">Password : </label>
        <input id="password" name="password" type="password" placeholder="Password" class="form-control"/>
    </div>
    <button type="submit">Log in</button>
</form>