<%@ page import="com.wry.jdbc.domain.Food" %>
<%@ page import="com.wry.jdbc.dao.FoodRandomDao" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 2019/3/10
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html><head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>随机点餐</title>
    <style type="text/css">
        <!--
        @import url(../css/index.css);/*这里是通过@import引用CSS的样式内容*/
        -->
    </style>
</head>

<body>
<%@include file="../frame_tag.jsp"%>

<%
    int rand_num = (int)(Math.random()*7+1);
    FoodRandomDao foodRandomDao = new FoodRandomDao();
    Food food = foodRandomDao.find(rand_num);
%>
<%=food.getFoodname()%>
<%=food.getFoodloc()%>
<%=food.getFoodprice()%>




</body>
</html>
