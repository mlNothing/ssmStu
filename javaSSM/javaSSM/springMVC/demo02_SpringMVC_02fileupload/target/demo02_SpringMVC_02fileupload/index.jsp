<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/5/3
  Time: 18:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <form action="demo01/fileLoad1" method="post" enctype="multipart/form-data">
            选择文件 <input type="file" name="upload"><br/>
            <input type="submit" value="提交">
        </form>


        <form action="demo01/fileLoad2" method="post" enctype="multipart/form-data">
            选择文件 <input type="file" name="upload"><br/>
            <input type="submit" value="提交">
        </form>
</body>
</html>
