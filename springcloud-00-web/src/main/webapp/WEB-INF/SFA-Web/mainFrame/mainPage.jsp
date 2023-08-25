<%--
  Created by IntelliJ IDEA.
  User: easti
  Date: 2023/7/11
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科罗廖夫的网站</title>
    <jsp:include page="head.jsp"/>
</head>

<body class="ltr app sidebar-mini">

<!-- GLOBAL-LOADER -->
    <div id="global-loader">
        <img src="${pageContext.request.contextPath}/sfa008/resources/images/loader.svg" class="loader-img" alt="Loader">
    </div>
    <!-- /GLOBAL-LOADER -->

    <!-- PAGE -->
    <div class="page">
        <div class="page-main" style="height: 100%;background-color: lightgreen">
            <jsp:include page="header.jsp"/>
            <jsp:include page="leftMenu.jsp"/>
            <div class="app-content main-content mt-0" style="position: absolute;height:100%;width:100%;background-color: lightskyblue">

                <div id="content" class="side-app">
                    <%--        主页面内容--%>
                    <iframe id="contentIFrame" name="content" src="${pageContext.request.contextPath}/sfa008/main/mainPage?pageName=dashboard/dashboard" width="100%" height="100%"/>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>

    <!-- BACK-TO-TOP -->
    <a href="#top" id="back-to-top"><i class="fa fa-long-arrow-up"></i></a>

    <!-- SIDE-MENU JS-->
<%--    <script src="resources/plugins/sidemenu/sidemenu.js"></script>--%>

</body>
</html>
