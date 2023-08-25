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
<%--    <jsp:include page="SFA-Web/head.jsp"/>--%>
    <jsp:include page="mainFrame/head.jsp"></jsp:include>
    <script>

        var dmk = "";
        function test() {
            // AJAX_RequestMethod("https://192.168.51.183:8098/cloudManager/getAllKey", null, "json", "get", function (data) {
            AJAX_RequestMethod("https://192.168.51.174:8098/cloudManager/getAllKey", null, "json", "get", function (data) {

                dmk = data;
                console.log(data);
                if (data != null) {
                    for (var i = 0; i < data.length; i++) {
                        console.log("================================");
                        console.log(data);
                    }
                }

            });
        }

        function getData(url) {
            var param = {};
            param.roleIds = "1,2,3";
            // param.predTime = thisObj.predTime.Format("yyyyMMdd") + "000000";
            AJAX_RequestMethod(url, param, "json", "get", function (data) {


                console.log(data);
                // if (data != null) {
                //     for (var i = 0; i < data.length; i++) {
                //         console.log("================================");
                //         console.log(data);
                //     }
                // } else {
                //     console.log("1111111111111111111111")
                // }

            });
        }


        function insertDMK() {
            var param = {};
            param.url = "https://192.168.51.174:8098";
            param.data = JSON.stringify(dmk["data"]);
            // console.log("dmk:" + JSON.stringify(dmk["data"]));
            AJAX_RequestMethod("http://localhost:18099/CloudCMMS/noShiro/kmsBackUp", param, "json", "post", function (data1) {

            });
        }


    </script>
</head>
<body>
    <button onclick="test()">获取密码机秘钥</button>
    <button onclick="insertDMK()">保存密码机秘钥</button><br>
    <button onclick="getData('http://localhost:8080/sfa008/web/user/getAllUsers')">获取用户</button>
    <button onclick="getData('http://localhost:8080/sfa008/web/menu/getMenu')">获取菜单</button>
</body>
    <jsp:forward page="mainFrame/mainPage.jsp"></jsp:forward>
</html>
