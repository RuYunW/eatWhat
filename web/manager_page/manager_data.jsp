<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.wry.jdbc.dao.FoodRandomDao,com.wry.jdbc.domain.Food" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">

    <title>网站管理界面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">

    <style type="text/css">
        @import "css/manager.css";
    </style>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body style="background:url(imgs/BG2018.jpg) no-repeat;background-size:100%;background-attachment:fixed;background-position-y: 90%; ">

<br>
<div class="manager_title">今天中午吃什么网站管理界面</div>
<a href="index.jsp" class="manager" style="text-align: center;float: right">返回首页</a>

<br>
<hr>
<br>
<div >
    <%--左边switch--%>
    <div class="tag_switch">

        <a class="manager" href="manager_page.jsp"><div class="tag_manager">管理主界面</div></a>
        <a class="manager" href="manager_page/manager_food.jsp"><div class="tag_manager">菜品管理</div></a>
        <a class="manager" href="manager_page/manager_link.jsp"><div class="tag_manager">相关链接管理</div></a>
        <a class="manager" href="manager_page/manager_ads.jsp"><div class="tag_manager">广告赞助管理</div></a>
        <a class="manager" href="manager_page/manager_diet.jsp"><div class="tag_manager">科学搭配管理</div></a>
        <a class="manager" href="manager_page/manager_newfood.jsp"><div class="tag_manager">新上菜品管理</div></a>
        <a class="manager" href="manager_page/manager_data.jsp"><div class="tag_manager_selected" >数据查看</div></a>
        <a class="manager" href="manager_page/manage_user.jsp"><div class="tag_manager">用户管理</div></a>

    </div>

    <%--中间主界面--%>
    <div class="main">

        <br>

        <table style="font-family: '等线 Light';font-size: x-large;text-align: left;margin-left: 5%;margin-top: 5%;">
            <tr>
                <%--<th>编号</th>--%>
                <th>名称</th>
                <th>地点</th>
                <th>具体位置</th>
                <th>价格</th>
            </tr>

        <%
            FoodRandomDao foodRandomDao = new FoodRandomDao();
            ArrayList<Food> list = foodRandomDao.findAll();
            for(int i=0;i<list.size();i++){
//                out.println(list.get(i).getFoodname()+"   "+list.get(i).getFoodloc()+"   "+list.get(i).getFoodprice()+"<br>");
                out.print("<tr>"
//                        +"<td>"+list.get(i).getId()+"</td>"
                        +"<td>"+list.get(i).getFoodname()+"</td>"
                        +"<td>"+list.get(i).getFoodloc()+"</td>"
                        +"<td>"+list.get(i).getDetailloc()+"</td>"
                        +"<td>"+list.get(i).getFoodprice()+"</td>"
                        +"</tr>");
            }
//            for(int a:list)System.out.println(a);


        %>
        </table>


    </div>
</div>

</body>
</html>
