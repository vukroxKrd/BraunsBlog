<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 11.02.2021
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <title>Blog template</title>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link rel="stylesheet" type="text/css" href="/static/css/foundation.css">
    <link rel="stylesheet" type="text/css" href="/static/css/foundation-icons.css">
    <link rel="stylesheet" type="text/css" href="/static/css/app.css">
</head>
<body>
<header>
    <jsp:include page="fragment/header.jsp"/>
</header>
<div class="row">
    <nav role="navigation" class="large-12 small-6 medium-8 columns">
        <jsp:include page="fragment/breadcrumbs.jsp"/>
    </nav>
    <div class="small-6 medium-4 columns">
        <jsp:include page="fragment/categories-dropdown.jsp"/>
    </div>
</div>
<section class="row">
    <div id="mainContent" class="large-10 columns" style="min-height:600px;">
        <jsp:include page="${currentPage}"/>
    </div>
    <div class="columns large-2 show-for-large right" data-sticky-container>
        <div class="sticky categories show-for-large" data-sticky data-anchor="mainContent">
            <jsp:include page="fragment/categories-table.jsp"/>
        </div>
    </div>
</section>
<footer class="footer">
    <jsp:include page="fragment/footer.jsp"/>
</footer>
<script src="/static/js/jquery.js"></script>
<script src="/static/js/what-input.js"></script>
<script src="/static/js/foundation.js"></script>
<script src="/static/js/app.js"></script>
</body>
</html>