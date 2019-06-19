<%@ page import="com.codeup.adlister.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <% if (session.getAttribute("user") == null){%>
            <li><a href="/register">Register</a></li>
            <li ><a href = "/login" > Login </a ></li >
            <%} else {%>
            <li><a href="/logout">Logout</a></li>
            <li><a href="/ads/create">Create Ad</a></li>
            <li><a href="/profile">Profile</a></li>
            <%} %>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>        