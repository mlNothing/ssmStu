<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/4/24
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <a href="lm/testParams?id=10">测试基本数据类型的绑定</a>
        <br/>
        <%--测试基本pojo的绑定--%>
        <form action="lm/testPojo" method="post">
            姓名：<input type="text" name="username"> <br/>
            密码：<input type="text" name="password"> <br/>
            金钱：<input type="text" name="money"> <br/>
            <input type="submit" value="提交">
        </form>
        <br/>
        <%--测试基本pojo关联的实体类--%>
        <form action="lm/testPojoUser" method="post">
            姓名：<input type="text" name="username"> <br/>
            密码：<input type="text" name="password"> <br/>
            金钱：<input type="text" name="money"> <br/>
            账户：<input type="text" name="user.uname"> <br/>
            年龄：<input type="text" name="user.age"> <br/>
            <input type="submit" value="提交">
        </form>
        <br/>
        <%--测试list和map集合--%>
        <form action="lm/testPojoListMap" method="post">
            姓名：<input type="text" name="username"> <br/>
            密码：<input type="text" name="password"> <br/>
            金钱：<input type="text" name="money"> <br/>

            账户：<input type="text" name="list[0].uname"> <br/>
            年龄：<input type="text" name="list[0].age"> <br/>
            账户：<input type="text" name="list[1].uname"> <br/>
            年龄：<input type="text" name="list[1].age"> <br/>


            账户：<input type="text" name="map['one'].uname"> <br/>
            年龄：<input type="text" name="map['one'].age"> <br/>
            账户：<input type="text" name="map['two'].uname"> <br/>
            年龄：<input type="text" name="map['two'].age"> <br/>
            <input type="submit" value="提交">
        </form>
        <br/>
</body>
</html>
