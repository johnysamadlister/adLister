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
        <h1 class="text-light">Welcome, ${sessionScope.user.username}!</h1>
    </div>
    <h2 class="d-flex justify-content-center text-light">Here are your ads</h2>
    <div class="container">
        <div class="row justify-content-center">
            <c:forEach var="ad" items="${ads}">
                <div class="card col col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 mx-3 my-4 shadow" style="width: 18rem;
            height: 25rem;">
                    <form action="/profile" method="post">
                    <ul class="list-group list group-flush mt-4">
                        <li class="list-group-item" style="text-align: center; font-weight: bold">
                            <label for="title">Title: </label>
                            <input type="text" id="title" name="title" placeholder="${ad.title}">
                        </li>
                    </ul>
                    <div class="card-text h-40 w-90 mt-3 d-flex justify-content-center">
                        <p class="align-text-center">Description</p>
                        <br>
                         <textarea name="description" id="description" cols="30" rows="7"
                                   placeholder="${ad.description}"></textarea>
                    </div>
                    <button class="btn btn-dark col mx-auto mt-4 shadow">Update</button>
                    <button class="btn btn-danger col mx-auto mt-2 mb-2 shadow">Delete</button>
                    </form>
                </div>
            </c:forEach>
        </div>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />
    </body>
</html>
