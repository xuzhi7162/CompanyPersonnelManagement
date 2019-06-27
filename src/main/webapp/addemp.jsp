<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加部门</title>
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
    <script type="text/javascript" src="js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div class="page-header">
    <h3>新增员工</h3>
</div>
<form name="form1" method="post" action="/emp/add">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
        <tr>
            <td width="120">部门名称：</td>
            <td width="380">
                <select name="deptNo" id="deptno">
                    <c:forEach items="${depts}" var="obj">
                        <option value="${obj.deptNo}" >${obj.deptName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td width="120">员工姓名：</td>
            <td width="380"><input type="text" name="empName" id="empname" value="${param.empName}"></td>
        </tr>
        <tr>
            <td width="120">员工性别：</td>
            <td width="380">
                <input type="radio" name="empSex" id="sex1" value="0"  checked>男
                <input type="radio" name="empSex" id="sex1" value="1" >女
            </td>
        </tr>
        <tr>
            <td width="120">入职日期：</td>
            <td width="380"><input class="Wdate" type="date" name="entryDate" value="${param.entryDate}" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:'true'})"/></td>
        </tr>
        </tr>
        <tr>
            <td width="120">联系电话：</td>
            <td width="380"><input type="text" name="empPhone" id="empphone" value="${param.empPhone}"></td>
        </tr>
        <tr>
            <td width="120">现住址：</td>
            <td width="380"><input type="text" size="40" name="empAddr" id="empaddr" value="${param.empAddr}"></td>
        </tr>
        <tr>
            <td width="120">薪资：</td>
            <td width="380"><input type="text" name="salary" id="salary" value="${param.salary}">￥</td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="button" id="button" value="增加">
                &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="#">返回</a></td>
        </tr>
    </table>
</form>
</body>
</html>
