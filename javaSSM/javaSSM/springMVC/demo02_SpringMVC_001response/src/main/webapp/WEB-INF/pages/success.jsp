<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/21
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <h4>成功了</h4>
    ${user}
    ${user.username}
    ${user.password}
        <br/>
    测试modelAndView ${requestScope.one}
</body>
</html>
