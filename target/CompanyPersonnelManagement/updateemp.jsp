<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>员工变更</title>
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
    <h3>员工变更</h3>
</div>
<form name="form1" method="post" action="/emp/update">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
        <input type="hidden" name="empNo" id="empno" value="${emp.empNo}"/>
        <tr>
            <td width="120">部门名称：</td>
            <td width="380">
                <select name="deptNo" id="deptno">
                    <c:forEach items="${depts}" var="obj">
                        <option value="${obj.deptNo}" <c:if test="${obj.deptNo == emp.deptNo}">selected</c:if>>${obj.deptName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td width="120">员工姓名：</td>
            <td width="380"><input type="text" name="empName" id="empname" value="${emp.empName}"  readonly="readonly"></td>
        </tr>
        <tr>
            <td width="120">员工性别：</td>
            <td width="380"><input type="radio" name="empSex" id="sex1" value="0" <c:if test="${emp.empSex == 0}">checked</c:if>  >男
                <input type="radio" name="empSex" id="sex1" value="1" <c:if test="${emp.empSex == 1}">checked</c:if> >女
            </td>
        </tr>
        <tr>
            <td width="120">入职日期：</td>
            <td width="380"><input class="Wdate" type="text" name="entryDate"  value="${emp.entryDate}" readonly="readonly"/></td>
        </tr>
        </tr>
        <tr>
            <td width="120">联系电话：</td>
            <td width="380"><input type="text" name="empPhone" id="empphone" value="${emp.empPhone}"></td>
        </tr>
        <tr>
            <td width="120">现住址：</td>
            <td width="380"><input type="text" size="40" name="empAddr" id="empaddr" value="${emp.empAddr}"></td>
        </tr>
        <tr>
            <td width="120">薪资：</td>
            <td width="380"><input type="text" name="salary" id="salary" value="${emp.salary}">￥</td>
        </tr>
        <tr>
            <td width="120">变更原因：</td>
            <td width="380">
                <textarea rows="3" cols="40" name="changeReason" id="schangereason"></textarea>
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center"><input type="submit" name="button" id="button" value="保存">
                &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="#">返回</a></td>
        </tr>
    </table>
</form>
</body>
</html>
