<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/25
  Time: 15:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>常用注解</title>
</head>
<body>
    <a href="l/testRequestParam?name=test">equestParam 注解</a>
    <br/>
    <%--测试Body--%>
    <form action="l/testRequestBody" method="post">
        姓名：<input type="text" name="username"> <br/>
        密码：<input type="text" name="password"> <br/>
        金钱：<input type="text" name="money"> <br/>
        <input type="submit" value="提交">
    </form>
    <br/>
    <a href="l/testPathVariable/10">PathVariable 注解</a>
    <br/>
    <a href="l/testRequestHeader">RequestHeader 注解</a>
    <br/>
    <a href="l/testCookieValue">CookieValue 注解</a>
    <br/>
    <a href="l/testModelAttribute?uname=test">ModelAttribute 注解基于 POJO 属性的基本使用</a>
    <br/>

    <%--需求：
    修改用户信息，要求用户的密码不能修改
    jsp 的代码：--%>
    <!-- 1：ModelAttribute 修饰方法带返回值-->
    <form action="l/updateUser" method="post">
        用户名称：<input type="text" name="uname" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="保存">
    </form>
    <br/>
    <%--基于 Map 的应用场景示例 1：ModelAttribute 修饰方法不带返回值--%>
    <form action="l/testUpdateUser" method="post">
        用户名称：<input type="text" name="uname" ><br/>
        用户年龄：<input type="text" name="age" ><br/>
        <input type="submit" value="保存">
    </form>


    <!-- SessionAttribute 注解的使用 -->
    <a href="l/testPut">存入 SessionAttribute</a>
    <hr/>
    <a href="l/testGet">取出 SessionAttribute</a>
    <hr/>
    <a href="l/testClean">清除 SessionAttribute</a>
</body>
</html>
