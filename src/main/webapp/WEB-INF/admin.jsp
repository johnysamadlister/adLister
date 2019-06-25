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
    <div class="col col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
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
                <c:forEach var="user" items="${users}">
                <tr>
                    <th scope="row">${user.id}</th>
                    <td>${user.userName}</td>
                    <td>${user.email}</td>
                    <td>
                            <c:choose>
                                <c:when test="${user.banned == true}">
                                <form action="/admin/banUser" method="post">
                                    <input type="hidden" name="user_id" value="${user.id}">
                                    <button name="unBan" value="${user.id}" class="btn btn-primary">Reinstate</button>
                                </form>
                                </c:when>
                                <c:otherwise>
                                    <form action="/admin/unBanUser" method="post">
                                        <input type="hidden" name="user_id" value="${user.id}">
                                        <button name="ban" value="${user.id}" class="btn btn-danger">Ban</button>
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
    <div class="col col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6 d-flex justify-content-center">
        <h1 class="text-light">Ads</h1>
        <c:forEach var="ad" items="${ads}">
            <div class="card col col-xs-12 col-sm-12 col-md-4 col-lg-3 col-xl-3 mx-3 my-4 shadow" style="width: 18rem;
            height: 25rem;">
                <ul class="list-group list group-flush mt-4">
                    <li class="list-group-item" style="text-align: center; font-weight: bold"><a href="/profile">${ad.title}</a> </li>
                    <li class="list-group-item">Username: <a href="/profile">${ad.user.username}</a></li>
                    <c:forEach var="category" items="${categories}">
                        <li class="list-group-item">
                            <span class="badge badge-pill badge-primary p-2">${ad.category}
                        </li>
                    </c:forEach>
                </ul>
                <div class="h-50 mt-3">
                    <p class="card-text"><span style="font-weight: bold">Description: </span>${ad.description}</p>
                </div>
                <form action="/profile/deleteAd" method="post">
                    <input type="hidden" name="ad_id" value="${ad.id}">
                    <button class="btn btn-danger col mx-auto mt-2 mb-2 shadow">Delete</button>
                </form>
            </div>
        </c:forEach>
    </div>
</div>
<div class="row">
        <form action="/manager" method="POST">
            <label for="categoryName">Category</label>
            <input type="text" id="categoryName" name="categoryName" placeholder="Category">
            <input type="text" id="catDesc" name="catDesc" placeholder="Description">
            <label for="catDesc">Description</label>
        </form>
</div>

<jsp:include page="/WEB-INF/partials/footer.jsp" />
</body>
</html>
