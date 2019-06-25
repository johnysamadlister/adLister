<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <style>
        .carousel-inner img {
            margin: auto;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1 id="awesome-headline" class="d-flex justify-content-center">Welcome to the Adlister!</h1>
        <h3 class="d-flex justify-content-center">Sell Stuffs. Find Treasures.</h3>

        <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
            <ol class="carousel-indicators">
                <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
                <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
            </ol>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="img/trombone2.jpg" class="d-block w-50 img-fluid" alt="trombone">
                </div>
                <div class="carousel-item">
                    <img src="img/possums.jpg" class="d-block w-50 img-fluid" alt="possum sculpture">
                </div>
                <div class="carousel-item">
                    <img src="img/whistles.jpg" class="d-block w-50 img-fluid" alt="whistle collection">
                </div>
                <div class="carousel-item">
                    <img src="img/child.jpg" class="d-block w-50 img-fluid" alt="rabbit cage">
                </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

    </div>



<%--    <div class="container">--%>
<%--        <h1>Let's all pat the bunny!</h1>--%>
<%--&lt;%&ndash;        <img  src="${pageContext.request.contextPath}img/default_profile.png">&ndash;%&gt;--%>
<%--    </div>--%>


<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
