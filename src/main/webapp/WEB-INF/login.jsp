<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Please Log In" />
    </jsp:include>
</head>
    <jsp:include page="/WEB-INF/partials/body_top.jsp" />
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <div class="card p-3 mt-5 shadow">
            <h1>Please Log In</h1>
            <form action="/login" method="POST">
                <div class="form-group">
                    <label for="username">Username</label>
                    <input id="username" name="username" class="form-control" type="text"
                           placeholder="enter your username or email">
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" class="form-control" type="password">
                </div>
                <input type="submit" class="btn btn-primary btn-block" value="Log In">
            </form>
    </div>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</html>
