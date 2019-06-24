<%--
  Created by IntelliJ IDEA.
  User: johnnyruiz
  Date: 2019-06-24
  Time: 12:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Your Profile" />
</jsp:include>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="row">
    <div class="col col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
       <h1>Users</h1>
    </div>
    <div class="col col-xs-12 col-sm-12 col-md-12 col-lg-6 col-xl-6">
        <h1>Ads</h1>
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
