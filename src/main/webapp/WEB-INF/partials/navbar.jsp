<%@ page import="com.codeup.adlister.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>
        <input class="form-control" type="text" placeholder="Search" aria-label="Search">
        <ul class="nav">
            <% if (session.getAttribute("user") == null){%>
            <li class="nav-item"><a class="nav-link" href="/register">Register</a></li>
            <li class="nav-item" ><a class="nav-link" href = "/login" > Login </a ></li >
            <%} else {%>
            <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
            <li class="nav-item"><a class="nav-link" href="/ads/create">Create Ad</a></li>
            <li class="nav-item"><a class="nav-link" href="/profile">Profile</a></li>
            <%} %>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>        