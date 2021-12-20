<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/21
  Time: 21:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lml</title>
</head>
<body>
    <h3>开始的测试</h3>
    <a href="lml/hello">超链接</a>
    </br>
    <%--method的测试--%>
    <form action="lml/saveAccount" method="post">
        <input type="submit" value="保存账户，post 请求">
    </form>
    <!-- 请求参数的示例
    当我们点击第一个超链接时,可以访问成功。
    当我们点击第二个超链接时，无法访问
    -->

    <a href="lml/removeAccount?accountName=aaa&money>100">删除账户，金额 100</a>
    <br/>
    <a href="lml/removeAccount?accountName=aaa&money>150">删除账户，金额 150</a>
    <br/>
    <%--自定义类型转换器--%>
    <form action="lml/deleteAcc" method="post">
        姓名：<input type="text" name="uname"> <br/>
        密码：<input type="text" name="age"> <br/>
        生日：<input type="text" name="date"> <br/>
        <input type="submit" value="提交">
    </form>
    <br/>
</body>
</html>
