<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<c:if test="${msg != null}">
    <script>
        alert('${msg}');
    </script>
</c:if>
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
                        <c:if test="${obj.state == 1}" >
                            <a href="/emp/info?empNo=${obj.empNo}">变更</a>&nbsp;&nbsp;
                            <a href="/emp/leaveinfo?empNo=${obj.empNo}">离职</a>&nbsp;&nbsp;
                        </c:if>
                        <a href="javascript:if(confirm('确认要减员吗？')){window.location='/emp/delete?empNo=${obj.empNo}'}">减员</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div style="float: left">
        <span>共${page.rows}条数据</span>&nbsp;<span>当前${page.pageCurrent}/${page.pageNum}页</span>
    </div>
    <div class="btn-group" style="float: right" role="group" aria-label="...">
        <a  class="btn btn-default" href="/emp/list?currentPage=1">首页</a>
        <a id="prevBtn" onclick="return onclick_prevBtn()"  class="btn btn-default" href="/emp/list?currentPage=${page.pageCurrent - 1}">上一页</a>
        <select id="selectBtn" onchange="onchange_selectBtn(this.value)" class="btn btn-default">
            <c:forEach begin="1" end="${page.pageNum}" var="obj">
                <option value="${obj}" <c:if test="${obj == page.pageCurrent}">selected</c:if>>第${obj}页</option>
            </c:forEach>
        </select>
        <a id="nextBtn" onclick="return onclick_nextBtn()"  class="btn btn-default" href="/emp/list?currentPage=${page.pageCurrent + 1}">下一页</a>
        <a  class="btn btn-default" href="/emp/list?currentPage=${page.pageNum}">尾页</a>
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
        window.location = '/emp/list?currentPage=' + test;
    }
</script>
</body>
</html>
