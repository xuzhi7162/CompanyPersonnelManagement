<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <style>
        .page-header ,.query{ text-align:center;margin:5px 0;}

        #tab{ background-color:#AAAAAA;}
        td{ background-color:#ffffff;}
    </style>
</head>

<body>
<div class="page-header">
    <h3>员工变更记录</h3>
</div>
<div class="query">
    <form method="post" action="/history/search">
        <input type="text" name="key" id="key" />&nbsp;&nbsp;<input type="submit" value="查询"/>
    </form>
</div>
<div id="contener">
    <table class="table table-bordered" id="tab" cellspacing="1" border="0"  width="800" align="center">
        <thead>
            <tr style="background-color:#ffffff;">
                <th>员工姓名</th>
                <th>部门名称</th>
                <th>薪水</th>
                <th>变更日期</th>
                <th>变更原因</th>
                <th>离职日期</th>
                <th>离职原因</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${historys}" var="obj">
                <tr>
                    <td>${obj.empName}</td>
                    <td>${obj.deptName}</td>
                    <td>${obj.salary}</td>
                    <td>${obj.changeDate}</td>
                    <td>${obj.changeReason}</td>
                    <td>${obj.dimissionDate}</td>
                    <td>${obj.dimissionReason}</td>
                </tr>
            </c:forEach>
        </tbody>



    </table>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
