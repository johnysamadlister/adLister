<%--
  Created by IntelliJ IDEA.
  User: johnnyruiz
  Date: 2019-06-24
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Your Profile" />
</jsp:include>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="row">
    <div class="col col-xs-12 col-sm-12 col-md-12 col-lg-10 col-xl-8">
        <h1 class="text-light d-flex justify-content-center">Users</h1>
        <table class="table table-hover table-dark">
                <thead>

                <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Username</th>
                    <th scope="col">Email</th>
                    <th scope="col">Delete</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="user" items="${allusers}">

                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.username}</td>
                    <td>${user.email}</td>

                    <td>
                            <c:choose>
                                <c:when test="${!user.banned}">
                                <form action="/admin/banUser" method="post">
                                    <input type="hidden" name="user_id" value="${user.id}">
                                    <button formaction="/admin/banUser" type="submit" name="unBan" value="${user.id}" class="btn btn-primary">Ban</button>
                                </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/admin/unBanUser" method="post">
                                        <input type="hidden" name="user_id" value="${user.id}">
                                        <button type="submit" name="ban" value="${user.id}" class="btn btn-danger">Reinstate</button>
                                    </form>
                                </c:otherwise>
                            </c:choose>
                        </form>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
