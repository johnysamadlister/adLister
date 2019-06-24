<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
    <body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <h2 class="d-flex justify-content-center">Here are your ads</h2>
    <div class="container">
        <div class="row justify-content-center">
            <c:forEach var="ad" items="${ads}">
                <div class="card col col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 mx-3 my-4 shadow" style="width: 18rem;
            height: 25rem;">
                    <ul class="list-group list group-flush mt-4">
                        <li class="list-group-item" style="text-align: center; font-weight: bold">Title: ${ad.title}</li>
                    </ul>
                    <p class="card-text h-50 mt-3"><span style="font-weight: bold">Description:
                    </span>${ad.description}</p>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />
    </body>
</html>
