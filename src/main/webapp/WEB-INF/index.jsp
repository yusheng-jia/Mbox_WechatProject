<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Mbox管理</title>
    <script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery-json/2.6.0/jquery.json.min.js"></script>
    <script>
        function updateMenu() {
            alert("updateMenu");
//            $.ajax({
//                type:'GET',
//                url :'/createMenu',
//                contentType : 'application/json',
//                dataType : 'json',
//                success : function () {
//                    alert("success");
//                },
//                error: function () {
//                    alert("error");
//                }
//
//            });
        }
    </script>
</head>
<body>
<br/>
<br/>
<br/>
<button onclick="updateMenu()">更新菜单</button>

</body>
</html>