<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register For Our Site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
        <div class="card shadow p-3 mt-5">
            <h1 style="text-align: center">Please fill in your information</h1>
            <form action="/register" method="post">
                <div class="form-group">
                    <% if (session.getAttribute("error") != null) { %> <div class="alert alert-danger"><%= request.getSession().getAttribute("error") %></div> <% }%>
                    <label for="username">Username</label>
                    <input id="username" name="username" class="form-control" type="text" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" name="email" class="form-control" type="text" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input id="password" name="password" class="form-control" type="password" required>
                </div>
                <div class="form-group">
                    <label for="confirm_password">Confirm Password</label>
                    <input id="confirm_password" name="confirm_password" class="form-control" type="password" required>
                </div>
                <input type="submit" class="btn btn-primary btn-block">
            </form>
            </div>
    </div>

    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
