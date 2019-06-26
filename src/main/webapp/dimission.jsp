<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>员工离职</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <style>
        .page-header{ width:500px;text-align:center;}
        #tab{ background-color:#AAAAAA;}
        td{ background-color:#ffffff;}
    </style>
</head>

<body>
<div class="page-header">
    <h3>员工离职</h3>
</div>
<form name="form1" method="post" action="/emp/leave">
    <table id="tab" width="800" border="0" cellspacing="1" cellpadding="3">
        <input type="hidden" name="empNo" id="empno" value="${emp.empNo}"/>
        <input type="hidden" name="empName" id="empname" value="${emp.empName}"/>
        <input type="hidden" name="empSex" id="empsex" value="${emp.empSex}"/>
        <input type="hidden" name="entryDate" id="entrydate" value="${emp.entryDate}"/>
        <input type="hidden" name="empPhone" id="empphone" value="${emp.empPhone}"/>
        <input type="hidden" name="empAddr" id="empaddr" value="${emp.empAddr}"/>
        <input type="hidden" name="salary" id="salary" value="${emp.salary}"/>
        <input type="hidden" name="deptNo" id="deptno" value="${emp.deptNo}"/>

        <tr>
            <td width="120">部门名称：</td>
            <td width="120">员工姓名：</td>
            <td width="120">员工性别：</td>
            <td width="120">入职日期：</td>
            <td width="120">联系电话：</td>
            <td width="120">现住址：</td>
            <td width="120">薪资：</td>

        </tr>
        <tr>
            <td width="380">${emp.deptName}</td>
            <td width="380">${emp.empName}</td>
            <td width="380">
                <c:if test="${emp.empSex == 0}">男</c:if>
                <c:if test="${emp.empSex == 1}">女</c:if>
            </td>
            <td width="380">${emp.entryDate}</td>
            <td width="380">${emp.empPhone}</td>
            <td width="380">${emp.empAddr}</td>
            <td width="380">${emp.salary}</td>

        </tr>
    </table>



    离职原因：
    <textarea rows="3" cols="40" name="dimissionReason" id="dimissionreason"></textarea>

    <input type="submit" name="button" id="button" value="确定">
    &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="#">返回</a>


</form>
</body>
</html>
