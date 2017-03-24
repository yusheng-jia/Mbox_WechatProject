<%--
  Created by IntelliJ IDEA.
  User: Jia
  Date: 2017/3/9
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<html style="background: #f0eff5;" lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0">
    <title>识别二维码</title>
</head>
<body>
<div align="center" class="wx_pair_main">
    <br>
    <br>
    <br>
    <p class="wx_msg">长按识别二维码，并选择
        <span style="color: #1aac19;">"配置设备网络"</span>
        <br>
    </p>
    <img  src="img/product_qrcode.jpg" width="65%">
    <br>
    <br>
    <br>
    <br>
    <p style="color: #999;">提示：扫面设备底部二维码可以跳过此前步骤</p>
</div>
</body>
</html>
