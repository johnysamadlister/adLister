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
        <div class="card shadow p-3 mt-5">
            <h1>Create a new Ad</h1>
            <form action="/ads/create" method="post">
                <div class="form-group">
                    <label for="title">Title</label>
                    <input id="title" name="title" class="form-control" type="text">
                </div>
                <div class="form-group d-flex justify-content-between">
                    <span class="badge badge-pill badge-primary p-2">
                        Electronics
                        <input type="checkbox" name="categories" value="Electronics">
                    </span>
                    <span class="badge badge-pill badge-primary p-2">
                         Automobile
                        <input type="checkbox" name="ccategories" value="Automobile">
                    </span>
                    <span class="badge badge-pill badge-primary p-2">
                         Tools
                        <input type="checkbox" name="categories" value="Tools">
                    </span>
                    <span class="badge badge-pill badge-primary p-2">
                         Jobs
                        <input type="checkbox" name="categories" value="Jobs">
                    </span>
                    <span class="badge badge-pill badge-primary p-2">
                         Games
                        <input type="checkbox" name="categories" value="Games">
                    </span>
                    <span class="badge badge-pill badge-primary p-2">
                         Toys
                        <input type="checkbox" name="categories" value="Toys">
                    </span>
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <textarea id="description" name="description" class="form-control" type="text"></textarea>
                </div>
                <input type="submit" class="btn btn-block btn-primary">
            </form>
        </div>
    </div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
