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
    <div style="float: left">
        <span>共${page.rows}条数据</span>&nbsp;<span>当前${page.pageCurrent}/${page.pageNum}页</span>
    </div>
    <div class="btn-group" style="float: right" role="group" aria-label="...">
        <a  class="btn btn-default" href="/history/list?currentPage=1">首页</a>
        <a id="prevBtn" onclick="return onclick_prevBtn()"  class="btn btn-default" href="/history/list?currentPage=${page.pageCurrent - 1}">上一页</a>
        <select id="selectBtn" onchange="onchange_selectBtn(this.value)" class="btn btn-default">
            <c:forEach begin="1" end="${page.pageNum}" var="obj">
                <option value="${obj}" <c:if test="${obj == page.pageCurrent}">selected</c:if>>第${obj}页</option>
            </c:forEach>
        </select>
        <a id="nextBtn" onclick="return onclick_nextBtn()"  class="btn btn-default" href="/history/list?currentPage=${page.pageCurrent + 1}">下一页</a>
        <a  class="btn btn-default" href="/history/list?currentPage=${page.pageNum}">尾页</a>
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
        window.location = '/history/list?currentPage=' + test;
    }
</script>
</body>
</html>
