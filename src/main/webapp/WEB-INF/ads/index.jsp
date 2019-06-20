<%@ page import="com.codeup.adlister.dao.DaoFactory" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>

<body style="background-image: url(&quot;https://images.iphonephotographyschool.com/11918/1120b/iPhone-Photos-Texture-67.jpg&quot;); background-repeat: no-repeat; background-size: cover">
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Here are all the ads</h1>
            <p class="lead">Browse ads, if you would like to create an ad register.</p>
        </div>
    </div>
       <div class="container">
           <div class="row justify-content-center">
        <c:forEach var="ad" items="${ads}">
            <div class="card col col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 mx-3 my-4 shadow" style="width: 18rem;
            height: 25rem;">
                <ul class="list-group list group-flush mt-4">
                    <li class="list-group-item"> ${ad.userId}</li>
                    <li class="list-group-item" style="text-align: center; font-weight: bold">Title: ${ad.title}</li>
                    <li class="list-group-item"> User: ${ad.user.username}</li>
                </ul>
                    <img src="${pageContext.request.contextPath}img/default_profile.png}" class="card-text mx-auto" alt="...">
                <p class="card-text"><span style="font-weight: bold">Description: </span>${ad.description}</p>
                <ul class="row">
                    <li class="col col-4"><button class="btn btn-danger">DELETE</button></li>
                    <li class="col col-4"><button class="btn btn-primary">EDIT</button></li>
                    <li class="col col-4"><button class="btn btn-dark">MESSAGE</button></li>
                </ul>
            </div>
        </c:forEach>
           </div>
       </div>
        <form action="/ads" method="GET">
            <button id="load" class="btn btn-lg btn-primary">Load More Ads</button>
        </form>

<div class="" style></div>
<div class=""></div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
