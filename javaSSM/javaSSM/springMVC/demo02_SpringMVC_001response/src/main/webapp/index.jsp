<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lml</title>
    <script src="js/jquery.min.js"></script>
    <script>
        $(function(){
            //绑定点击事件
            $("#bt1").click(function () {
                $.ajax({
                    url:"demo01/testJson",
                    contentType:"application/json;charset=UTF-8",
                    data:'{"username":"aa","password":"123","money":"100"}',
                    type:"post",
                    success:function (data) {
                            alert(data);
                            alert(data.username)
                    }
                })
            })
        }
        )
    </script>
</head>
<body>
<a href="demo01/testVoid">测试</a>
<a href="demo01/testReturnVoid">测试无返回值</a>
<br/>
<a href="demo01/testReturnModelAndView">测试模型视图</a>
<br/>
<a href="demo01/testForward">测试转发</a>
<a href="demo01/testRedirect">测试重定向</a>
<br/>
<button id="bt1">测试响应json,发送json请求</button>
</body>
</html>

