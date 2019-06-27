<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>添加部门</title>
    <base href="<%=basePath%>">
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
    <script type="application/javascript">
        function onclick_button(){
            var deptname = document.getElementById("deptname").value;
            if(deptname == "") {
                alert("部门名称不能为空");
                return false;
            }
            return true;
        }
        function onsubmit_form1() {
            var deptname = document.getElementById("deptname").value;
            if(deptname == "") {
                alert("部门名称不能为空");
                return false;
            }
            return true;
        }
    </script>
</head>

<body>
<div class="page-header">
    <h3>新增部门</h3>
</div>
<form name="form1" method="post" action="/dept/add" onsubmit=" return onsubmit_form1()">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
        <tr>
            <td width="120">部门名称：</td>
            <td width="380"><input type="text" name="deptName" id="deptname" value="${param.deptName}"></td>
        </tr>

        <tr>
            <td colspan="2" align="center">
                <input type="submit"  name="button" id="button" value="增加">
                &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="/dept/list">返回</a></td>
        </tr>
    </table>
</form>
</body>
</html>
