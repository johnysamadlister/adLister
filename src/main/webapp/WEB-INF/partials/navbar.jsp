<%@ page import="com.codeup.adlister.models.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand text-dark" href="/ads">Adlister</a>
        </div>
        <form action="/ads" method="post">
        <input class="form-control" name="searchterm" type="text" placeholder="Search Ads" aria-label="Search">
        </form>
        <ul class="nav">
            <% if (session.getAttribute("user") == null){%>
            <li class="nav-item"><a class="nav-link text-dark" href="/register">Register</a></li>
            <li class="nav-item" ><a class="nav-link text-dark" href = "/login" > Login </a ></li >
            <%} else {%>
            <li class="nav-item"><a class="nav-link text-dark" href="/logout">Logout</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/ads/create">Create Ad</a></li>
            <li class="nav-item"><a class="nav-link text-dark" href="/profile">Profile</a></li>
            <%} %>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>        