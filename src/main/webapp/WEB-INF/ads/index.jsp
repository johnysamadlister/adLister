<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ page import="com.codeup.adlister.models.User" %>
<%@ page import="com.codeup.adlister.models.Ad" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>



</head>
<body>

<jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="jumbotron jumbotron-fluid bg-dark text-light">
        <div class="container">
            <h1 class="display-4">Here are all the ads</h1>
            <p class="lead">Browse all ads or search an item specifically</p>
            <form action="/ads" method="post">
                <div class="input-group mb-3">
                    <input class="form-control" name="searchterm" type="text" placeholder="Search Ads" aria-label="Search">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="button">SEARCH</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
       <div class="container">
           <div class="row justify-content-center">
        <c:forEach var="ad" items="${ads}">
            <div class="card col col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 mx-3 my-4 shadow" style="width: 18rem;
            height: 25rem;">
                <ul class="list-group list group-flush mt-4">
                    <li class="list-group-item" style="text-align: center; font-weight: bold">Title: ${ad.title}</li>

                    <li class="list-group-item"> User: ${ad.user.username}</li>
                    <c:forEach var="category" items="${categories}">
                        <li class="list-group-item">
                            <span class="badge badge-pill badge-primary p-2">
                            ${ad.category}
                        </li>
                    </c:forEach>
                </ul>
                <div style="background-image: url(""${ad.img}"")">
                    <img src= class="card-text mx-auto" alt="..." style="height: 250px; width: 250px">
                </div>
                <p class="card-text"><span style="font-weight: bold">Description: </span>${ad.description}</p>
                <div class="row justify-content-between mx-2">

                    <button class="btn btn btn-danger col mx-2">Delete</button>
                    <button class="btn btn-primary col mx-2">Edit</button>
                    <button class="btn btn-dark col mx-2">Message</button>
                </div>
            </div>
        </c:forEach>
           </div>
       </div>
        <form action="/ads" method="GET">
            <div class="d-flex justify-content-center">
                <button id="load" class="btn btn-lg btn-primary shadow">Load More Ads</button>
            </div>
        </form>

<div class="" style></div>
<div class=""></div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>