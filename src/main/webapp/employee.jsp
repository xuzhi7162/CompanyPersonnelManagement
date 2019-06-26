<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <style>
        .page-header {
            text-align: center;
        }

        #add {
            margin: 0 auto;
            width: 850px;
            text-align: right;
        }

        #tab {
            background-color: #AAAAAA;
        }

        td {
            background-color: #ffffff;
        }
        #msg{color:#ff0000;}
    </style>
</head>
<body>

<div class="page-header">
    <h3>员工列表</h3>
</div>
<div id="add">
    <a href="/emp/addPage">新增员工</a>
</div>
<div id="contener">
    <table class="table table-bordered" id="tab" cellspacing="1" cellpadding="2" border="0" width="850" align="center">
        <thead>
            <tr style="background-color:#ffffff;">
                <th>员工编号</th>
                <th>部门名称</th>
                <th>员工姓名</th>
                <th>员工性别</th>
                <th>入职日期</th>
                <th>联系电话</th>
                <th>员工住址</th>
                <th>薪资</th>
                <th>离职日期</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${emps}" var="obj">
                <tr>
                    <td>${obj.empNo}</td>
                    <td>${obj.deptName}</td>
                    <td>${obj.empName}</td>
                    <td>
                        <c:if test="${obj.empSex == 0}">男</c:if>
                        <c:if test="${obj.empSex == 1}">女</c:if>
                    </td>
                    <td>${obj.entryDate}</td>
                    <td>${obj.empPhone}</td>
                    <td>${obj.empAddr}</td>
                    <td>${obj.salary}</td>
                    <td>${obj.leaveDate}</td>
                    <td>
                        <a href="/emp/info?empNo=${obj.empNo}">变更</a>&nbsp;&nbsp;
                        <a href="/emp/leaveinfo?empNo=${obj.empNo}">离职</a>&nbsp;&nbsp;
                        <a href="javascript:if(confirm('确认要减员吗？')){window.location='/emp/delete?empNo=${obj.empNo}'}">减员</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>


    </table>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
