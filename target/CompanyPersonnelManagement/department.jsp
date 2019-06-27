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
    <div style="float: left">
        <span>共${page.rows}条数据</span>&nbsp;<span>当前${page.pageCurrent}/${page.pageNum}页</span>
    </div>
    <div class="btn-group" style="float: right" role="group" aria-label="...">
        <a  class="btn btn-default" href="/dept/list?currentPage=1">首页</a>
        <a id="prevBtn" onclick="return onclick_prevBtn()"  class="btn btn-default" href="/dept/list?currentPage=${page.pageCurrent - 1}">上一页</a>
        <select id="selectBtn" onchange="onchange_selectBtn(this.value)" class="btn btn-default">
            <c:forEach begin="1" end="${page.pageNum}" var="obj">
                <option value="${obj}" <c:if test="${obj == page.pageCurrent}">selected</c:if>>第${obj}页</option>
            </c:forEach>
        </select>
        <a id="nextBtn" onclick="return onclick_nextBtn()"  class="btn btn-default" href="/dept/list?currentPage=${page.pageCurrent + 1}">下一页</a>
        <a  class="btn btn-default" href="/dept/list?currentPage=${page.pageNum}">尾页</a>
    </div>
</div>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script>

    function onclick_prevBtn() {
        var current = ${page.pageCurrent};
        if(current <= 1){
            return false;
        }
        return true;
    }

    function onclick_nextBtn() {
        var pageNum = ${page.pageNum};
        var current = ${page.pageCurrent}
        if(current < pageNum) {
            return true;
        }else {
            return false;
        }
    }

    function onchange_selectBtn(selected) {
        var test = selected;
        window.location = '/dept/list?currentPage=' + test;
    }
</script>
</body>
</html>
