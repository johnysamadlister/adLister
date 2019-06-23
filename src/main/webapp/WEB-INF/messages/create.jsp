<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Message" />
    </jsp:include>
</head>
<jsp:include page="/WEB-INF/partials/body_top.jsp" />
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">

        <h3>Create a new Message</h3>

        <form action="/messages/create" method="post">

            <div class="form-group">
                <label for="title">Title</label>
                <input id="title" name="title" class="form-control" type="text">
            </div>

            <div class="form-group">
                <label for="description">Description</label>
                <textarea id="description" name="description" class="form-control" type="text"></textarea>
            </div>

            <input type="submit" class="btn btn-block btn-primary">

        </form>

    </div>
    <jsp:include page="/WEB-INF/partials/footer.jsp" />
</html>
