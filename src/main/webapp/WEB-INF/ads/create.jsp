<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <div class="row d-flex justify-content-center">
            <div class="col col-xs-12 col-sm-12 col-md-8 col-lg-6 card shadow p-3 mt-5">
                <h1>Create a new Ad</h1>
                <form action="/ads/create" method="post">
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input id="title" name="title" class="form-control" type="text">
                    </div>
                    <div class="form-group d-flex justify-content-start">
                    <c:forEach var="category" items="${categories}">
                            <span class="badge badge-pill badge-primary p-2 mr-1">
                                ${category.category_name}
                                <input type="checkbox" name="category${category.id}" value="${category.id}">
                            </span>
                    </c:forEach>
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea id="description" name="description" class="form-control" type="text"></textarea>
                    </div>
                    <input type="submit" class="btn btn-block btn-primary">
                </form>
            </div>
        </div>
    </div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
