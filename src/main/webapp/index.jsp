<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
</head>
    <jsp:include page="/WEB-INF/partials/body_top.jsp" />
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>Welcome to the Adlister!</h1>
        <img  src="${pageContext.request.contextPath}img/default_profile.png">
    </div>
<jsp:include page="/WEB-INF/partials/footer.jsp" />

    </html>
