<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container text-light">
        <h1>Welcome to the Adlister!</h1>
        <div>
            <div>
                <h2>A place you can...</h2>
            </div>
            <img width="200px" src="images/profile_icon.svg">
            <div>
                <h2>Browse ads from other users,</h2>
            </div>
            <div>
                <h2>post you own ads</h2>
            </div>
            <div>
                <h2>edit you existing ads</h2>
            </div>
        </div>
        <form action="/ads">
        <button>Get Started</button>
        </form>
    </div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
