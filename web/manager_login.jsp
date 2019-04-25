<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();

	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>管理员登录页面</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<style type="text/css">
			<!--
			@import url(css/manager_login.css);/*这里是通过@import引用CSS的样式内容*/
			-->
		</style>
	</head>

	<body style="background-color: aliceblue">

	<form action="doLogin.jsp">
	    
	    <br><br><hr>
			<%
				String failState = (String)session.getAttribute("state");
				if(failState == null){
				}
				else{
					System.out.println(failState);
			%>
			<%=failState%>
			<%
				}
				session.setAttribute("state",null);
			%>
	    <br>
	    <br>
			<div align="center">
				<%--<span style="font-family:等线;font-size: larger;color: gray">账号</span>--%>
				<input class="input_search" type="text" placeholder="账号" name="username" />
				<br>
				<%--<span style="font-family:等线;font-size: larger;color: gray">密码</span>--%>
					<input class="input_search" type="password" placeholder="密码" name="password" />
				<br>
				<input class="login" type="submit" value="登录">
                <br>
                    <a href="index.jsp">返回首页</a>
			</div>
		</form>
	</body>
</html>