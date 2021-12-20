<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/5
  Time: 12:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h3>跨服务器上传 图片服务器</h3>
        <form action="demo01/upload" enctype="multipart/form-data" method="post">
            <input type="file" name="upload">
            <input type="submit" value="上传">
        </form>
</body>
</html>
