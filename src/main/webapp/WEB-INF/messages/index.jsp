<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<jsp:include page="/WEB-INF/partials/body_top.jsp" />
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="jumbotron jumbotron-fluid">
        <div class="container">
            <h1 class="display-4">Here are all the ads</h1>
            <p class="lead">Browse ads, if you would like to create an ad register.</p>
        </div>

    <c:forEach var="ad" items="${ads}">
        <div class="card col" style="width: 18rem;">
            <ul class="list-group list group-flush">
                <li class="list-group-item">${ad.title}</li>
            </ul>
            <img src="${ad.img}" class="card-img-top" alt="...">
            <div class="card-body">
                <p class="card-text">${ad.description}</p>
            </div>
        </div>
    </c:forEach>

</div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</html>
