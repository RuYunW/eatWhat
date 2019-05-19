<%--
  Created by IntelliJ IDEA.
  User: Ash
  Date: 2019/5/18
  Time: 23:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>邮箱验证页</title>
</head>
<body>
<br><br>
<%
    if(session.getAttribute("emailResult")==null){

    }else {
        out.println(session.getAttribute("emailResult"));
    }
%>

<hr>
<div style="font-family: '等线 Light';font-size: larger">

    <br>
邮件已发送，请注意查收并输入验证码：
</div>
<br>
<form action="MailRight" method="post">
    <input type="text" name="inputCode" placeholder="验证码">
    <input type="submit" value="提交">
</form>

</body>
</html>
