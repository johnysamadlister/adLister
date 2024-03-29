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
       <div class="container justify-content-center">
           <div class="row">
        <c:forEach var="ad" items="${ads}">
            <div class="card col col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 mx-3 my-4 shadow" style="width: 18rem;
            height: 25rem;">
                <ul class="list-group list group-flush mt-4">
                    <li class="list-group-item" style="text-align: center; font-weight: bold"><a href="/profile">${ad.title}</a> </li>
                    <li class="list-group-item">Username: <a href="/profile">${ad.user.username}</a></li>
                    <div class="d-flex justify-content-start mt-2">
                    <c:forEach var="category" items="${ad.ad_categories}">
                        <span class="badge badge-pill badge-primary p-2 mr-1">
                                ${category.category_name}
                        </span>
                    </c:forEach>
                    </div>
                </ul>
                <div class="h-50 mt-3">
                    <p class="card-text"><span style="font-weight: bold">Description: </span>${ad.description}</p>
                </div>
                <div class="d-flex justify-content-center mb-2">
                    <h3><a href = "mailto: ${ad.user.email}?subject=${ad.title}">Email</a></h3>
                </div>
            </div>
        </c:forEach>
           </div>
       </div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>