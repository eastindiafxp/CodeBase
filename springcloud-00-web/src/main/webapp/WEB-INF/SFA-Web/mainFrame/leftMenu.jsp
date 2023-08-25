<%--
  Created by IntelliJ IDEA.
  User: easti
  Date: 2023/8/18
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="head.jsp"/>
</head>
<!--APP-SIDEBAR-->
<div class="sticky">
  <div class="app-sidebar__overlay" data-bs-toggle="sidebar"></div>
  <div class="app-sidebar">
    <%--      左上角的图标 start --%>
    <div class="side-header">
        <a class="header-brand1" href="http://localhost:8080/sfa008/">
<%--        <img src="resources/images/brand/blackhole.jpeg" class="header-brand-img light-logo1" alt="logo">--%>
        <p style="font-size: 24px;">挖土豆的科罗廖夫</p>
      </a><!-- LOGO -->
    </div>
    <%--      左上角的图标 end --%>

    <%--        菜单 start --%>
    <div class="main-sidemenu">
<%--        <div class="slide-left disabled" id="slide-left">--%>
<%--            <svg xmlns="http://www.w3.org/2000/svg" fill="#7b8191" width="24" height="24" viewBox="0 0 24 24">--%>
<%--                <path d="M13.293 6.293 7.586 12l5.707 5.707 1.414-1.414L10.414 12l4.293-4.293z" />--%>
<%--            </svg>--%>
<%--        </div>--%>
        <ul class="side-menu" id="side-menu">
            <li>
              <h3>菜单</h3>
            </li>
<%--            <li class="slide">--%>
<%--                <a class="side-menu__item" data-bs-toggle="slide" href="#">--%>
<%--                    <svg xmlns="http://www.w3.org/2000/svg" class="side-menu__icon" enable-background="new 0 0 24 24" viewBox="0 0 24 24">--%>
<%--                        <path d="M19,2H9C7.3438721,2.0018311,6.0018311,3.3438721,6,5v1H5C3.3438721,6.0018311,2.0018311,7.3438721,2,9v10c0.0018311,1.6561279,1.3438721,2.9981689,3,3h10c1.6561279-0.0018311,2.9981689-1.3438721,3-3v-1h1c1.6561279-0.0018311,2.9981689-1.3438721,3-3V5C21.9981689,3.3438721,20.6561279,2.0018311,19,2z M17,19c-0.0014038,1.1040039-0.8959961,1.9985962-2,2H5c-1.1040039-0.0014038-1.9985962-0.8959961-2-2v-8h14V19z M17,10H3V9c0.0014038-1.1040039,0.8959961-1.9985962,2-2h10c1.1040039,0.0014038,1.9985962,0.8959961,2,2V10z M21,15c-0.0014038,1.1040039-0.8959961,1.9985962-2,2h-1V9c-0.0008545-0.7719116-0.3010864-1.4684448-0.7803345-2H21V15z M21,6H7V5c0.0014038-1.1040039,0.8959961-1.9985962,2-2h10c1.1040039,0.0014038,1.9985962,0.8959961,2,2V6z"/>--%>
<%--                    </svg>--%>
<%--                    <span class="side-menu__label">表格</span>--%>
<%--                    <i class="angle fa fa-angle-right"></i>--%>
<%--                </a>--%>
<%--                <ul class="slide-menu">--%>
<%--                    <li class="side-menu-label1"><a href="javascript:void(0)">Tables</a></li>--%>
<%--                    <li><a href="tables.html" class="slide-item">Default Table</a></li>--%>
<%--                    <li><a href="datatable.html" class="slide-item">Data Tables</a></li>--%>
<%--                    <li><a href="table-editable.html" class="slide-item">Editable Tables</a></li>--%>
<%--                </ul>--%>
<%--            </li>--%>
        </ul>
<%--        <div class="slide-right" id="slide-right">--%>
<%--            <svg xmlns="http://www.w3.org/2000/svg" fill="#7b8191" width="24" height="24" viewBox="0 0 24 24">--%>
<%--                <path d="M10.707 17.707 16.414 12l-5.707-5.707-1.414 1.414L13.586 12l-4.293 4.293z" />--%>
<%--            </svg>--%>
<%--        </div>--%>
    </div>
    <%--        菜单 end --%>
  </div>
</div>

<%--<script src="resources/myJavaScript/PublicFunction.js"></script>--%>
<script src="resources/myJavaScript/leftMenu.js"></script>
<!--/APP-SIDEBAR-->
</html>
