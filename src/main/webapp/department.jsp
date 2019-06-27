<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<c:if test="${msg!=null}">
    <script type="text/javascript">
        alert( "${msg}" );
    </script>
</c:if>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
    <style>
        .page-header{ text-align:center;}
        #add{ margin:0 auto;width:600px;text-align:right;}
        #tab{ background-color:#AAAAAA;}
        td{ background-color:#ffffff;}
    </style>
</head>
<body>

<div class="page-header">
    <h3>部门列表</h3>
</div>
<div id="add">
    <a href="/adddept.jsp">新增部门</a>
</div>
<div id="contener">
    <table class="table table-bordered" id="tab" cellspacing="1" border="0"  width="600" align="center">
        <thead>
            <tr style="background-color:#ffffff;">
                <th>部门编号</th>
                <th>部门名称</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${depts}" var="obj">
                <tr>
                    <td>${obj.deptNo}</td>
                    <td>${obj.deptName}</td>
                    <td>
                        <a href="/dept/info?deptNo=${obj.deptNo}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="javascript:if(confirm('确认要删除吗？')){window.location='/dept/delete?deptNo=${obj.deptNo}'}">删除</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>


    </table>
    <div id="msg">${msg}</div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</body>
</html>
