# CompanyPersonnelManagement
企业人事管理系统

公司人事管理系统

部门管理：
部门信息的基本维护 （部门编号，部门名称） 1  销售部   2  人事部
雇员功能：
1：雇员的报到，向employee和employee_history表中插入数据，雇员编号自己生成，六位数字，不够六位前端补0 
2：雇员修改，修改employee表中的数据，可修改 部门，电话，地址，薪水，并说明修改原因 
	雇员编号 ， 雇员名称 ， 雇员所在部门编号 ， 电话 ， 地址 ， 薪水 ， 备注
	1001   张三 1 
	修改员工资料的时候，需要记录修改原因。
3：雇员离职，修改employee表中的离职日期，并向employee_history中插入离职日期和离职原因、		
	离职日期 ， 是否离职 
	
变更管理
模糊查询员工的变更记录

1.	创建数据库和数据库表
数据库名：company
表名：Dept
字段名	类型	注释	是否为空	备注
DEPTNO	INT	部门编号	NOT  NULL	pk
DEPTNAME	Varhcar(20)	部门名称	Not null  唯一的	

表名：Employee
字段名	类型	注释	是否为空	备注
EMPNO	Varchar（20）	雇员编号	Not null	pk
DEPTNO	Int	部门编号	Not null	Fk dept.deptno
EMPNAME	Varchar(30)	雇员姓名	Not null	
EMPSEX	CHAR(1)	雇员性别	Not null	只能输入0（男） ， 1（女）
ENTRYDATE	Date	入职日期	Not null	
EMPPHONE	Varchar(30)	联系电话	Not null	
EMPADDR	Varchar（50）	住址		
SALARY	Int 	雇员薪水	Not null	
LEAVEDATE	DATE	离职日期		
STATE	INT 	状态		默认1
表名： history
字段名	类型	注释	是否为空	备注
CHANGENO	int	Id	Not null	Pk 自增
EMPNO	Varchar（20）	雇员编号	Not null	Fk
DEPTNO	Int	部门编号	Not null	Fk
SALARY	INT	雇员薪水	Not null	
CHANGEDATE	Date	变更日期		
CHANGEREASON	Varchar（100）	变更原因		
DIMISSIONDATE	Date	离职日期		
DIMISSIONREASON	Varchar（100）	离职原因		
2、	创建WEB项目：文件组织结构
	 
文件 	说明
工具包，包含数据库连接及关闭类，其他系统工具类	
实体包，对应数据库中数据表	
数据访问接口及实现类  Model 层	
业务操作接口   Model 层	
业务操作实现类   Model 层	
请求处理    Controller 层	
系统需要的第三方 JAR 文件，本系统用到 MySQL 驱动类	
系统需要的第三方插件，js文件	
系统需要的样式文件	
部门添加页面	
员工添加页面	
部门管理显示页面	
员工管理显示页面	
员工变更管理页面	
部门修改页面	
员工修改页面	
员工离职页面	

3、	实现步骤：
3.1、静态页面设计
	（B/S 架构实现业务首要一步是先完成静态原型设计）
3.1.1设计首页
Index.jsp:
 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>后台管理</title>
<meta charset="UTF-8">

<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome.min.css">
<link rel="stylesheet" href="css/b.tabs.css" type="text/css">
<style type="text/css">
div.menuSideBar { }
div.menuSideBar li.nav-header { font-size: 14px; padding: 3px 15px; }
div.menuSideBar .nav-list > li > a, div.menuSideBar .dropdown-menu li a { -webkit-border-radius: 0px; -moz-border-radius: 0px; -ms-border-radius: 0px; border-radius: 0px; }
</style>

</head>
<body><script src="/demos/googlegg.js"></script>

<div class="content">
<div class="container">
<h3 class="page-header">公司人事后台管理系统</h3>
<div class="">
  <div class="row-fluid">
    <div class="col-md-2" style="padding-left: 0px;">
      <div class="well menuSideBar" style="padding: 8px 0px;">
        <ul class="nav nav-list" id="menuSideBar">
          <li class="nav-header">导航菜单</li>
          <li class="nav-divider"></li>
          <li mid="tab1" funurl="department.jsp"><a tabindex="-1" href="javascript:void(0);">部门管理</a></li>
          <li mid="tab2" funurl="employee.jsp"><a tabindex="-1" href="javascript:void(0);">员工管理</a></li>
          <li mid="tab3" funurl="history.jsp"><a tabindex="-1" href="javascript:void(0);">员工变更管理</a></li>
        </ul>
      </div>
    </div>
    <div class="col-md-10" id="mainFrameTabs" style="padding : 0px;"> 
      
      <!-- Nav tabs -->
      <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active noclose"><a href="#bTabs_navTabsMainPage" data-toggle="tab">首页</a></li>
      </ul>
      
      <!-- Tab panes -->
      <div class="tab-content">
        <div class="tab-pane active" id="bTabs_navTabsMainPage">
         <div class="page-header">
            <h2 style="font-size: 31.5px;text-align: center;font-weight: normal; line-height:60px;">欢迎使用
             <br>公司人事后台管理系统
            </h2>
          </div>
         
        </div>
      </div>
    </div>
  </div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script> 
<script type="text/javascript" src="js/bootstrap.min.js"></script> 
<script type="text/javascript" src="js/b.tabs.js" ></script> 
<script type="text/javascript" src="js/demo.js" ></script>

<div style="text-align:center;margin:100px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>

</div>
</body>
</html>



3.1.2、部门管理
     部门管理静态页面设计：
 
department.jsp：部门显示页面
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
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
   <a href="adddept.jsp">新增部门</a>
</div>
<div id="contener">
  <table id="tab" cellspacing="1" border="0"  width="600" align="center">
  <tr style="background-color:#ffffff;">
    <th>部门编号</th>
    <th>部门名称</th>
     <th>操作</th>
  </tr>
      <tr>
    <td>1</td>
    <td>研发部</td>
    <td>
    <a href="#">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="#">删除</a>
    </td>
  </tr> 
  
  
  </table>
<div id="msg">${msg }</div>   
</div>
</body>
</html>

Adddept.jsp 员工添加页面
 
   
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
  <div class="page-header">
<h3>新增部门</h3>
</div>
    <form name="form1" method="post" action="#">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="120">部门名称：</td>
        <td width="380"><input type="text" name="deptname" id="deptname"></td>
      </tr>
      
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="增加">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="#">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

Updatedept.jsp 部门修改页面
 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
    <div class="page-header">
<h3>修改部门</h3>
</div>
    <form name="form1" method="post" action="#">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
     <tr>
        <td width="120">部门编号：</td>
        <td width="380"><input type="text" name="deptno" id="deptno" value="4"></td>
      </tr>
      <tr>
        <td width="120">部门名称：</td>
        <td width="380"><input type="text" name="deptname" id="deptname" value="客服部"></td>
      </tr>
      
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="保存">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="#">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

3.1.3员工管理
Employee.jsp: 员工显示页面
 
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
	<a href="addemp.jsp">新增员工</a>
	</div>
	<div id="contener">
		<table id="tab" cellspacing="1" cellpadding="2" border="0" width="850" align="center">
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
					<tr>
				<td>001</td>
				<td>产品部</td>
				<td>刘宇</td>
				<td>男</td>
				<td> 2018-04-08 </td>
				<td>15543256789</td>
				<td>长清湖</td>
				<td>3000</td>
				<td> </td>
				<td>
				<a href="#">变更</a>&nbsp;&nbsp;
				<a href="#">离职</a>&nbsp;&nbsp;
				<a href="#">减员</a>
				</td>
			</tr>
			
			
		</table>  
	</div>
	
</body>
</html>

Addemp.jsp:员工添加页面
 
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
    <form name="form1" method="post" action="#">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="120">部门名称：</td>
        <td width="380">
        <select name="deptno" id="deptno">
         <option value="1">产品部</option>
<option value="2">市场部</option>
<option value="3">销售部</option>
<option value="4">客服部</option>
        </select>
        </td>
      </tr>
        <tr>
        <td width="120">员工姓名：</td>
        <td width="380"><input type="text" name="empname" id="empname"></td>
      </tr>
       <tr>
        <td width="120">员工性别：</td>
        <td width="380"><input type="radio" name="empsex" id="sex1" value="男" checked="checked">男
        <input type="radio" name="empsex" id="sex1" value="女">女
        </td>
      </tr>
      <tr>
        <td width="120">入职日期：</td>
        <td width="380"><input class="Wdate" type="text" name="entrydate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:'true'})"/></td>
      </tr>
      </tr>
        <tr>
        <td width="120">联系电话：</td>
        <td width="380"><input type="text" name="empphone" id="empphone"></td>
      </tr>
         <tr>
        <td width="120">现住址：</td>
        <td width="380"><input type="text" size="40" name="empaddr" id="empaddr"></td>
      </tr>
       <tr>
        <td width="120">薪资：</td>
        <td width="380"><input type="text" name="salary" id="salary">￥</td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="增加">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="#">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

Updateemp.jsp   员工修改页面
 
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
    <form name="form1" method="post" action="#">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
    <input type="hidden" name="empno" id="empno" value="006"/>
      <tr>
        <td width="120">部门名称：</td>
        <td width="380">
        <select name="deptno" id="deptno">
        <option value="4">客服部</option>
       
        </select>
        </td>
      </tr>
        <tr>
        <td width="120">员工姓名：</td>
        <td width="380"><input type="text" name="empname" id="empname" value="孙芸"  readonly="readonly"></td>
      </tr>
       <tr>
        <td width="120">员工性别：</td>
        <td width="380"><input type="radio" name="empsex" id="sex1" value="男" checked="checked">男
        <input type="radio" name="empsex" id="sex1" value="女">女
        </td>
      </tr>
      <tr>
        <td width="120">入职日期：</td>
        <td width="380"><input class="Wdate" type="text" name="entrydate"  value="2019-02-22" readonly="readonly"/></td>
      </tr>
      </tr>
        <tr>
        <td width="120">联系电话：</td>
        <td width="380"><input type="text" name="empphone" id="empphone" value="15543256789"></td>
      </tr>
         <tr>
        <td width="120">现住址：</td>
        <td width="380"><input type="text" size="40" name="empaddr" id="empaddr" value="大学城"></td>
      </tr>
       <tr>
        <td width="120">薪资：</td>
        <td width="380"><input type="text" name="salary" id="salary" value="3800">￥</td>
      </tr>
        <tr>
        <td width="120">变更原因：</td>
        <td width="380">
           <textarea rows="3" cols="40" name="changereason" id="schangereason"></textarea>
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

Dimission.jsp  员工离职页面
 
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
    <form name="form1" method="post" action="#e">
    <table id="tab" width="800" border="0" cellspacing="1" cellpadding="3">
    <input type="hidden" name="empno" id="empno" value="011"/>
    <input type="hidden" name="empname" id="empname" value="213"/>
    <input type="hidden" name="empsex" id="empsex" value="男"/>
    <input type="hidden" name="entrydate" id="entrydate" value="2019-04--8"/>
    <input type="hidden" name="empphone" id="empphone" value="12345678911"/>
    <input type="hidden" name="empaddr" id="empaddr" value="312"/>
    <input type="hidden" name="salary" id="salary" value="123"/>
    <input type="hidden" name="deptno" id="deptno" value="1"/>
    
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
        <td width="380">产品部</td>
        <td width="380">213</td>
         <td width="380">男</td>
        <td width="380">2019-04-08</td>
        <td width="380">12345678911</td>
         <td width="380">312</td>
          <td width="380">123￥</td>
      </tr>
      </table>
       
      
      
       离职原因：
        <textarea rows="3" cols="40" name="dimissionreason" id="dimissionreason"></textarea>
     
       <input type="submit" name="button" id="button" value="确定">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="#">返回</a>
    
    
  </form>
  </body>
</html>
 

3.1.4、员工变更管理
History.jsp
 
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
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
  <form method="post" action="<%=path%>/history.do?method=list">
     <input type="text" name="key" id="key" />&nbsp;&nbsp;<input type="submit" value="查询"/>
  </form>
</div>
<div id="contener">
  <table id="tab" cellspacing="1" border="0"  width="800" align="center">
  <tr style="background-color:#ffffff;">
    <th>员工姓名</th>
     <th>部门名称</th>
     <th>薪水</th>
      <th>变更日期</th>
      <th>变更原因</th>
      <th>离职日期</th>
       <th>离职原因</th>
  </tr>
    <tr>
    <td>刘宇</td>
    <td>产品部</td>
    <td>3000</td>
    <td>2019-04-08</td>
    <td>入职</td>
    <td></td>
    <td></td>
  </tr> 
  </table>
</div>
</body>
</html>

3.2 业务功能实现步骤
3.2.1 util包下工具类
日期工具类：DateUtil
package com.employee.util;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
public class DateUtil {
	public static Date toDate(String sdate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return new Date(sdf.parse(sdate).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static Date getNow(){
		java.util.Date now = new java.util.Date();
		return new Date(now.getTime());
	}
	public static void main(String[] args) {
		System.out.println(getNow());
	}
}

主键站位符工具类：EmpnoUtil
package com.employee.util;
import java.sql.SQLException;
import com.employee.service.IEmployeeBiz;
import com.employee.service.impl.EmployeeBizImpl;
public class EmpnoUtil {
	public static String createEmpno(String empno) {
		// 1如果第1位和第2位都是0，说明是个位数
		if (empno.charAt(0) == '0' && empno.charAt(1) == '0') {
			int no = Integer.parseInt(empno.substring(2)) + 1;
			if (no < 10) {
				return "00" + no;
			} else {
				return "0" + no;
			}
		}
		// 2如果只有第一位为0
		else if (empno.charAt(0) == '0') {
			int no = Integer.parseInt(empno.substring(1)) + 1;
			if (no < 100) {
				return "0" + no;
			} else {
				return "" + no;
			}
		}
		// 3如果第一位不为0
		else {
			int no = Integer.parseInt(empno) + 1;
			return "" + no;
		}
	}
}

连接数据库工具类：JDBCUtils
package com.employee.util;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;


/**
 * 
 * JDBC 的工具类
 *
 */
public class JDBCUtils {
/**通过数据源获得连接对象
 * 多用在WEB项目中
 */
   private static ComboPooledDataSource dataSource = null;
	
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	
	static {
		dataSource = new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return dataSource;
	}
	
	public static Connection getConnection(){
		Connection conn = tl.get();//首先从ThreadLocal中获得连接对象
		try {
			if(conn == null){
				conn = dataSource.getConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tl.set(conn);
		return conn;
	}
	
    
	/**
	 * 开始事务
	 * @throws SQLException
	 */
	public static void startTransaction(){
		Connection conn = getConnection();
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 回滚事务
	 * @throws SQLException
	 */
	public static void rollback(){
		Connection conn = getConnection();
		try {
			conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 提交事务
	 * @throws SQLException
	 */
	public static void commit(){
		Connection conn = getConnection();
		try {
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭Connection,并移除线程中的连接
	 * @throws SQLException
	 */
	public static void closeConnection(){
		try {
			getConnection().close();
			tl.remove();
		} catch (SQLException e) {
			e.printStackTrace();
		};
		
	}
	
	
	public static void close(Statement stm){
		try {
			if(stm != null){
				stm.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs){
		try {
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
3.2.2 数据库连接池
数据库连接池在src下：c3p0.xml
<?xml version="1.0" encoding="UTF-8"?>
<c3p0-config>
	<default-config>
		<property name="driverClass">com.mysql.jdbc.Driver</property>
		<property name="jdbcUrl">jdbc:mysql://localhost:3306/company</property>
		<property name="user">root</property>
		<property name="password">123456</property>
	</default-config>
</c3p0-config>
3.2.3 po包下实体类
Dept
package com.employee.po;

public class Dept {
	private int deptno;//部门编号 自动增长
	private String deptname;
	
    public Dept() {
		super();
	}

	public Dept(int deptno, String deptname) {
		super();
		this.deptno = deptno;
		this.deptname = deptname;
	
	}

	public Dept(String deptname) {
		super();
		this.deptname = deptname;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}

Employee
package com.employee.po;

import java.sql.Date;

/**
 * 雇员实体类
 * @author yhy
 *
 */
public class Employee {
	private String empno ;//员工编号
	private int deptno;//部门编号
	private String deptname;//部门名称
	private String empname;
	private String empsex;
	private Date entrydate;
	private String empphone;
	private String empaddr;
	private int salary; //薪水
	private Date leavedate;
	private int state;
	
	public Employee() {
		super();
	}
    //查询
	public Employee(String empno, int deptno, String deptname, String empname,
			String empsex, Date entrydate, String empphone, String empaddr,
			int salary, Date leavedate, int state) {
		super();
		this.empno = empno;
		this.deptno = deptno;
		this.deptname = deptname;
		this.empname = empname;
		this.empsex = empsex;
		this.entrydate = entrydate;
		this.empphone = empphone;
		this.empaddr = empaddr;
		this.salary = salary;
		this.leavedate = leavedate;
		this.state = state;
	}

	
    //增加 
	public Employee(int deptno, String empname, String empsex,
			Date entrydate, String empphone, String empaddr, int salary,
			int state) {
		super();
		this.deptno = deptno;
		this.empname = empname;
		this.empsex = empsex;
		this.entrydate = entrydate;
		this.empphone = empphone;
		this.empaddr = empaddr;
		this.salary = salary;
		this.state = state;
	}
	//修改
	public Employee(String empno, int deptno, String empphone, String empaddr, int salary) {
		super();
		this.empno = empno;
		this.deptno = deptno;
		this.empphone = empphone;
		this.empaddr = empaddr;
		this.salary = salary;
	}
	//离职
	public Employee(int deptno,String empno,String empname,String empsex,
			Date entrydate, String empphone, String empaddr, int salary,
			int state ){
		super();
		this.deptno = deptno;
		this.empno = empno;
		this.empname = empname;
		this.empsex = empsex;
		this.entrydate = entrydate;
		this.empphone = empphone;
		this.empaddr = empaddr;
		this.salary = salary;
		this.state = state;
	}
	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpsex() {
		return empsex;
	}

	public void setEmpsex(String empsex) {
		this.empsex = empsex;
	}

	public Date getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(Date entrydate) {
		this.entrydate = entrydate;
	}

	public String getEmpphone() {
		return empphone;
	}

	public void setEmpphone(String empphone) {
		this.empphone = empphone;
	}

	public String getEmpaddr() {
		return empaddr;
	}

	public void setEmpaddr(String empaddr) {
		this.empaddr = empaddr;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Date getLeavedate() {
		return leavedate;
	}

	public void setLeavedate(Date leavedate) {
		this.leavedate = leavedate;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}

History
package com.employee.po;

import java.sql.Date;

public class History {
   private int changeno;
   private String empno;
   private int deptno;
   private int salary;
   private Date changedate;
   private String changereason;
   private Date dimissiondate;
   private String dimissionreason;
   private String deptname;
   private String empname;
	public History() {
		super();
	}
	//查询
	public History(int changeno,String empname, String empno, int deptno, int salary,
			Date changedate, String changereason, Date dimissiondate,
			String dimissionreason, String deptname)
	{
		super();
		this.changeno = changeno;
		this.empname = empname;
		this.empno = empno;
		this.deptno = deptno;
		this.salary = salary;
		this.changedate = changedate;
		this.changereason = changereason;
		this.dimissiondate = dimissiondate;
		this.dimissionreason = dimissionreason;
		this.deptname = deptname;
	}
	//增加
	public History(int changeno,String empname, String empno, int deptno, int salary,
			Date changedate, String changereason, Date dimissiondate,
			String dimissionreason) {
		super();
		this.changeno = changeno;
		this.empname = empname;
		this.empno = empno;
		this.deptno = deptno;
		this.salary = salary;
		this.changedate = changedate;
		this.changereason = changereason;
		this.dimissiondate = dimissiondate;
		this.dimissionreason = dimissionreason;
	}
	public int getChangeno() {
		return changeno;
	}
	public void setChangeno(int changeno) {
		this.changeno = changeno;
	}
	public String getEmpname(){
		return empname;
	}
	public void setEmpname(String empname){
		this.empname = empname;
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Date getChangedate() {
		return changedate;
	}
	public void setChangedate(Date changedate) {
		this.changedate = changedate;
	}
	public String getChangereason() {
		return changereason;
	}
	public void setChangereason(String changereason) {
		this.changereason = changereason;
	}
	public Date getDimissiondate() {
		return dimissiondate;
	}
	public void setDimissiondate(Date dimissiondate) {
		this.dimissiondate = dimissiondate;
	}
	public String getDimissionreason() {
		return dimissionreason;
	}
	public void setDimissionreason(String dimissionreason) {
		this.dimissionreason = dimissionreason;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
}

3.2.4 bao包下数据访问
公共通用BaseDao
package com.employee.dao;

import java.sql.*;
import java.util.List;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.employee.util.JDBCUtils;

public class BaseDao<T> {
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// 数据库访问操作
	/**
	 * 返回单个对象
	 * @param <T>
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            如果没有参数就设为 Object[] params={}
	 * @return
	 */
	public <T> T get(String sql, Class<T> clazz, Object[] params) {
		T obj = null;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			QueryRunner qRunner = new QueryRunner();
			obj = qRunner.query(conn, sql, new BeanHandler<T>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}
	/**
	 * 返回单个对象 事务操作
	 * @param <T>
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            如果没有参数就设为 Object[] params={}
	 * @return
	 */
	public <T> T get(Connection conn,String sql, Class<T> clazz, Object[] params) throws SQLException {
		     T obj = null;
			QueryRunner qRunner = new QueryRunner();
			obj = qRunner.query(conn, sql, new BeanHandler<T>(clazz), params);		
		    return obj;
	}

	/**
	 * 返回多个对象
	 * 
	 * @param sql
	 * @param clazz
	 * @param params
	 *            如果没有参数就设为 Object[] params={}
	 * @return
	 */
	public <T> List<T> query(String sql, Class<T> clazz, Object[] params) {
		List beans = null;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			System.out.println(conn+"----------------");
			QueryRunner qRunner = new QueryRunner();
			beans = (List) qRunner.query(conn, sql, new BeanListHandler<T>(clazz), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beans;
	}

	/**
	 * 返回增删改是否成功
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean update(String sql, Object[] params) {
		Connection conn = null;
		boolean flag = false;
		try {
			conn = JDBCUtils.getConnection();
			QueryRunner qRunner = new QueryRunner();
			int i = qRunner.update(conn, sql, params);
			if (i > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
    /**
     * 需要进行事务操作时，在同一事务管理下操作
     * @param conn
     * @param sql
     * @param params
     * @return
     * @throws SQLException
     */
	public boolean update(Connection conn, String sql, Object[] params) throws SQLException {
		boolean flag = false;
		QueryRunner qRunner = new QueryRunner();
		int i = qRunner.update(conn, sql, params);
		if (i > 0) {
			flag = true;
		}
		return flag;
	}

	/***
	 * 批量操作，需要用到事务
	 * 
	 * @param conn
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean batchUpdate(Connection conn, String sql, Object[][] params) throws SQLException {
		QueryRunner qRunner = new QueryRunner();
		int result = 0;
		boolean flag = false;
		result = qRunner.batch(conn, sql, params).length;
		if (result > 0) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 返回统计单值,
	 * @param sql
	 * @param params
	 * @return
	 */
	public long getCount(String sql,Object[] params){
		long count =0L;
		Connection conn = null;
		try {
			conn = JDBCUtils.getConnection();
			QueryRunner qRunner = new QueryRunner();
			count  = qRunner.query(conn, sql, new ScalarHandler(), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	/**
	 * 返回主键,通常是执行insert语句时返回当前的主键值
	 * @param sql
	 * @param params
	 * @return
	 */
    public Long getCurrentKey(String sql,Object[] params){
    	Connection conn = null;
		Long key = 0l;
		try {
			conn = JDBCUtils.getConnection();
			QueryRunner qRunner = new QueryRunner();
			 key = (Long) qRunner.insert(conn,sql, new ScalarHandler(1), params);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return key;
    }
}

DeptDao：继承与通用BaseDao
package com.employee.dao;

import com.employee.po.Dept;

public class DeptDao extends BaseDao<Dept>{

}

EmployeeDao：
package com.employee.dao;

import com.employee.po.Employee;
/**
 * 实际访问类继承BaseDao,泛型参数传递给BaseDao
 * @author yhy
 *
 */
public class EmployeeDao extends BaseDao<Employee>{

}

HistoryDao：
package com.employee.dao;

import com.employee.po.History;

public class HistoryDao extends BaseDao<History> {

}

3.2.5 service包业务层接口和实现类
Service接口：
IDeptBiz
package com.employee.service;

import java.util.List;

import com.employee.po.Dept;
import com.employee.po.Employee;

public interface IDeptBiz {
	//
    public boolean add(Dept dept);
    //删除部门 ，
    public boolean deleteDept(int deptno); 
    //修改部门
    public boolean updateDept(Dept dept);
    //根据编号查找部门
    public Dept findByNo(int deptno);
    //查询所有部门
    public List<Dept> findAll();
    
}

IEmployeeBiz：
package com.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.employee.po.Employee;
import com.employee.po.History;

/**
 * 业务接口，向下调用Dao,向上返回操作是否成功
 * @author yhy
 *
 */
public interface IEmployeeBiz {
    //员工入职，报到
    public boolean entry(Employee emp);
    //离职   (修改离职时间)
    public boolean dimission(Employee emp,History history);
    //已离职员工允许删除，修改状态软删除，
    public boolean deleteEmployee(String empno); 
    //修改信息员工部门，电话，地址，薪水
    public boolean updateEmployee(Employee emp,History history);
    //根据编号查找员工
    public Employee findByNo(String empno);
    //查询所有员
    public List<Employee> findAll();
    //模糊查询，分页查询
}
IHistoryBiz;
package com.employee.service;

import java.sql.SQLException;
import java.util.List;

import com.employee.po.History;


public interface IHistoryBiz {
	//模糊查询
	public List<History> findByKey(String key);
	
	
}

实现类：
DeptBizImpl：
package com.employee.service.impl;

import java.sql.Connection;
import java.util.List;

import com.employee.dao.DeptDao;
import com.employee.po.Dept;
import com.employee.po.Employee;
import com.employee.po.History;
import com.employee.service.IDeptBiz;
import com.employee.util.JDBCUtils;

public class DeptBizImpl implements IDeptBiz{
    //引入Dao
	private DeptDao deptdao = new DeptDao();
	@Override
	public boolean add(Dept dept) {
		String sql = "insert into dept(deptname) values(?)";
		Object[] params = {dept.getDeptname()};
		return deptdao.update(sql, params);
	}

	@Override
	public boolean deleteDept(int deptno) {
		Connection conn = JDBCUtils.getConnection();
		
		
		boolean result = true;
		try {
			//开启事务
			JDBCUtils.startTransaction();
			String sql1 = "select * from dept left join employee on dept.deptno = employee.deptno where employee.deptno = ?";
			Object[] params1 = {deptno};
			Dept dept = deptdao.get(conn, sql1, Dept.class, params1);
			
			if(dept!=null){
				return result = false;
			}else{
				String sql2 = "delete from dept where deptno = ?";
				Object[] params2 = {deptno};
				deptdao.update(sql2, params2);
				JDBCUtils.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败---------");
			JDBCUtils.rollback();
			result = false;
		}finally{
			JDBCUtils.closeConnection();
		}
		return result;
	}

	@Override
	public boolean updateDept(Dept dept) {
		String sql = "update dept set deptname=? where deptno=?";
		Object[] params ={dept.getDeptname(),dept.getDeptno()};
		return deptdao.update(sql, params);
	}

	@Override
	public Dept findByNo(int deptno) {
		String sql ="select deptno,deptname from dept where deptno=?";
		Object[] params = {deptno};
		return deptdao.get(sql, Dept.class, params);
				
	}

	@Override
	public List<Dept> findAll() {
		String sql = "select deptno,deptname from dept";
		Object[] params = {};
		return deptdao.query(sql, Dept.class, params);
	}

	

}

EmployeeBizImpl：
package com.employee.service.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import com.employee.dao.BaseDao;
import com.employee.dao.EmployeeDao;
import com.employee.dao.HistoryDao;
import com.employee.po.Employee;
import com.employee.po.History;
import com.employee.service.IEmployeeBiz;
import com.employee.util.EmpnoUtil;
import com.employee.util.JDBCUtils;

public class EmployeeBizImpl implements IEmployeeBiz{
     private EmployeeDao empdao = new EmployeeDao();
     private HistoryDao hisdao = new HistoryDao();
	@Override
	public boolean entry(Employee emp)  {
		Connection conn = JDBCUtils.getConnection();
		System.out.println(conn+"-----------");
		boolean result = true;
		try {
			//开启事务
			JDBCUtils.startTransaction();
			String empno="";
			String sql0 = "select empno from employee order by empno desc limit 0,1";
	    	Object[] params0 = {};
	    	if(empdao.get(conn,sql0, Employee.class, params0) == null){
	    		System.out.println("000-------------");
	    		empno = "000";
	    	}else{
	    		System.out.println("实际编号--------------");
	    		empno = empdao.get(conn,sql0, Employee.class, params0).getEmpno();
	    	}
			empno = EmpnoUtil.createEmpno(empno);
			String sql = "insert into employee(empno,deptno,empname,empsex,entrydate,empphone,empaddr,salary,state)"
					+ "values(?,?,?,?,?,?,?,?,?)";
			Object[] params ={empno,
					          emp.getDeptno(),
					          emp.getEmpname(),
					          emp.getEmpsex(),
					          emp.getEntrydate(),
					          emp.getEmpphone(),
					          emp.getEmpaddr(),
					          emp.getSalary(),
					          1};

			empdao.update(conn, sql, params);
			//根据员工信息给历史对象赋值
			History history = new History();
			history.setDeptno(emp.getDeptno());
			history.setSalary(emp.getSalary());
			history.setChangedate(emp.getEntrydate());
			history.setChangereason("入职");
			String sql2 = "insert into history(empno,deptno,salary,changedate,changereason) values(?,?,?,?,?)";
			Object[] params2 = {empno,
					           history.getDeptno(),
					           history.getSalary(),
					           history.getChangedate(),
					           history.getChangereason()
					          };
			hisdao.update(conn, sql2, params2);
			JDBCUtils.commit();//提交事务
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败---------------");
			JDBCUtils.rollback();//回滚事务
			result = false;
		}finally{
			JDBCUtils.closeConnection();
		}
		
		return result;

	}

	@Override
	public boolean deleteEmployee(String empno) {
		Connection conn = JDBCUtils.getConnection();
		boolean result = true;
		try {
			//开启事务
			JDBCUtils.startTransaction();
			String sql1 = "select leavedate from employee where empno = ?";
			Object[] params1 = {empno};
			Employee emp = empdao.get(conn, sql1,Employee.class, params1);
			if(emp.getLeavedate() !=null){
				String sql = "update employee set state = 0 where empno=?";
				Object[] params = {empno};
				empdao.update(sql, params);
				JDBCUtils.commit();
				
			}else{
				System.out.println(emp.getLeavedate());
				return result = false;
			}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("失败---------");
				JDBCUtils.rollback();
				result = false;
			}
		return result;
	}
     /**
      * 修改员工部门，电话，地址，薪水
      */
	@Override
	public boolean updateEmployee(Employee emp,History history) {
		
		Connection conn = JDBCUtils.getConnection();
		boolean result = true;
		try {
			//开启事务
			JDBCUtils.startTransaction();
			String sql1 = "update employee set deptno=?,empphone=?,empaddr=?,salary=? where empno=?";
			Object[] params1 ={emp.getDeptno(),
					          emp.getEmpphone(),
					          emp.getEmpaddr(),
					          emp.getSalary(),
					          emp.getEmpno()};
		   empdao.update(conn,sql1, params1);
		   //历史记录的添加
		   //changedate changereason 必有-history
		   //
		   
		   String sql2 = "insert into history(empno,deptno,salary,changedate,changereason) values(?,?,?,?,?)"; 
		   Object[] params2 = {emp.getEmpno(),
				              emp.getDeptno(),
				              emp.getSalary(),
				              history.getChangedate(),
				              history.getChangereason(),};
		   hisdao.update(conn, sql2, params2);
		   JDBCUtils.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败---------");
			JDBCUtils.rollback();
			result = false;
		}finally{
			JDBCUtils.closeConnection();
		}
		return result;
		
	}

	@Override
	public Employee findByNo(String empno) {
		String sql = "select * from employee where empno = ?";
		Object[] params = {empno};
		return empdao.get(sql, Employee.class, params);
		
	}

	@Override
	public List<Employee> findAll() {
		//需要查询员工的外键信息
		String sql = "select empno,deptname,empname,empsex,entrydate,empphone,empaddr,salary,leavedate,state "
				+ " from employee,dept where employee.deptno = dept.deptno"
				+ " and state=1";
		     
		Object[] params = {};
		return empdao.query(sql, Employee.class, params);
				
	}
    /**
     * 修改离职时间
     * 插入离职记录
     */
	@Override
	public boolean dimission(Employee emp,History history1) {
		Connection conn = JDBCUtils.getConnection();
		boolean result = true;
		try {
			//开启事务
			JDBCUtils.startTransaction();
			String sql1 = "update employee set leavedate = now() where empno = ?";
			Object[] params1 ={emp.getEmpno()};
		   empdao.update(conn,sql1, params1);
		   //历史记录的添加
		   //changedate changereason 必有-history
		   //
//		   History history1 = new History();
//		   history.setDeptno(emp.getDeptno());
//			history.setSalary(emp.getSalary());
			
		   String sql2 = "insert into history(empno,deptno,salary,changedate,changereason,dimissiondate,dimissionreason) values(?,?,?,now(),?,now(),?)"; 
		   Object[] params2 = {emp.getEmpno(),
				              emp.getDeptno(),
				              emp.getSalary(),
				              history1.getChangereason(),
				              history1.getDimissionreason()};
		   hisdao.update(conn, sql2, params2);
		   JDBCUtils.commit();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("失败---------");
			JDBCUtils.rollback();
			result = false;
		}finally{
			JDBCUtils.closeConnection();
		}
		return result;
	}


}

HistoryBizImpl：
package com.employee.service.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import com.employee.dao.HistoryDao;
import com.employee.po.History;
import com.employee.service.IHistoryBiz;
import com.employee.util.JDBCUtils;

public class HistoryBizImpl implements IHistoryBiz{
    private HistoryDao hisdao = new HistoryDao();
	@Override
	public List<History> findByKey(String key) {
		String sql = "select history.empno,empname,history.deptno,deptname,employee.salary,changedate,changereason,dimissiondate,dimissionreason "
				+ "from employee,dept,history where employee.empno = history.empno and dept.deptno = history.deptno "
				+ " and concat(history.empno,empname,deptname) like ?";
		Object[] params = {"%"+key+"%"};
		return hisdao.query(sql, History.class, params);
				
	}

}

3.2.6 Servlet包下请求处理控制类
DeptServlet：
package com.employee.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.po.Dept;
import com.employee.po.Employee;
import com.employee.po.History;
import com.employee.service.impl.DeptBizImpl;

/**
 * Servlet implementation class DeptServlet
 */

public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DeptBizImpl deptBizImpl = new DeptBizImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = request.getParameter("method");
		if(method.equals("list")){
			this.listDept(request,response);
		}
		if(method.equals("add")){
			this.Add(request,response);
		}
		if(method.equals("finByNo")){
			this.FinByNo(request,response);
		}
		if(method.equals("update")){
			this.update(request,response);
		}
		if(method.equals("delete")){
			this.delete(request,response);
		}
	}
	
	/*
	 * 删除部门，如果部门内没有员工了则可以删除
	 * 否则不允许删除
	 */
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int deptno = Integer.parseInt(request.getParameter("id"));
		boolean result = deptBizImpl.deleteDept(deptno);
		String msg ;
		if(result){
			msg = "操作成功！";
		}else{
			msg = "操作失败！";
		}
		request.setAttribute("msg", msg);
		listDept(request,response);
		
	}
	/*
	 * 修改部门
	 */
	private void update(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String deptname = request.getParameter("deptname");
		Dept dept = new Dept(deptno,deptname);
		boolean result = deptBizImpl.updateDept(dept);
		String msg ;
		if(result){
			msg = "操作成功！";
		}else{
			msg = "操作失败！";
		}
		request.setAttribute("msg", msg);
		listDept(request,response);
		
		
	}
	/*
	 * 添加部门
	 */
	private void Add(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String deptname = request.getParameter("deptname");
		Dept dept = new Dept(deptname);
		boolean result  = deptBizImpl.add(dept);
		String msg ;
		if(result){
			msg = "操作成功！";
		}else{
			msg = "操作失败！";
		}
		request.setAttribute("msg", msg);
		listDept(request,response);
	}
	/*
	 * 修改根据id查询当前部门
	 */
	private void FinByNo(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		int deptno = Integer.parseInt(request.getParameter("id"));
		Dept dept = deptBizImpl.findByNo(deptno);
		request.setAttribute("dept", dept);
		try {
			request.getRequestDispatcher("/updatedept.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/*
	 * 插叙所有部门
	 */
	private void listDept(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		List<Dept> list = deptBizImpl.findAll();
		request.setAttribute("list", list);
		try {
			request.getRequestDispatcher("/department.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}

EmployeeServlet;
package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.po.Dept;
import com.employee.po.Employee;
import com.employee.po.History;
import com.employee.service.IDeptBiz;
import com.employee.service.IEmployeeBiz;
import com.employee.service.impl.DeptBizImpl;
import com.employee.service.impl.EmployeeBizImpl;
import com.employee.util.DateUtil;
import com.employee.util.EmpnoUtil;

public class EmployeeServlet extends HttpServlet {
    //引入业务类
	private IEmployeeBiz empbiz = new EmployeeBizImpl();
    private IDeptBiz deptbiz = new DeptBizImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //编码设置
		request.setCharacterEncoding("utf-8");
		//获取业务方法参数
		String method = request.getParameter("method");
		if(method.equals("list")){
			list(request,response);
		}else if(method.equals("add")){
			add(request,response);
		}else if(method.equals("delete")){
			delete(request,response);
		}else if(method.equals("get")){
			getById(request,response);
		}else if(method.equals("update")){
			update(request,response);
		}else if(method.equals("getDept")){
			getDeptforAdd(request,response);
		}else if(method.equals("leaveGetById")){
			this.leaveGetById(request,response);
		}else if(method.equals("leave")){
			this.leave(request, response);
		}
			
	}
	/*
	 * 离职操作
	 */
	private void leave(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取请求参数
				String empno = request.getParameter("empno");
				String empname = request.getParameter("empname");
				String empsex = request.getParameter("empsex");
				String sentrydate = request.getParameter("entrydate");
				Date entrydate = DateUtil.toDate(sentrydate);//类型转换
				String empphone = request.getParameter("empphone");
				String empaddr = request.getParameter("empaddr");
				int  salary = Integer.parseInt(request.getParameter("salary"));
				int deptno = Integer.parseInt(request.getParameter("deptno"));
				
				
				Employee emp = new Employee(deptno,empno,empname,empsex,entrydate,empphone,empaddr,salary,0);
				
				String dimissionreason = request.getParameter("dimissionreason");
				System.out.println(dimissionreason);
				String changereason = request.getParameter("changereason");
				System.out.println(changereason);
				History history = new History();
				history.setDimissionreason(dimissionreason);
				history.setChangereason(changereason);
				boolean result = empbiz.dimission(emp,history);
				String msg = "";
				if(result==true){
					msg = "操作成功！";
				}else{
					msg = "操作失败！";
				}
				request.setAttribute("msg", msg);
				list(request,response);
	}


	/*
	 * 离职查询
	 */
    private void leaveGetById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    	//获取请求参数
    			String empno = request.getParameter("empno");
    			Employee emp = empbiz.findByNo(empno);
    			List<Dept> deptlist = deptbiz.findAll();
    			request.setAttribute("deptlist", deptlist);//绑定部门
    			request.setAttribute("emp", emp);//绑定员工
    			//转发到修改页面
    			request.getRequestDispatcher("/dimission.jsp").forward(request, response);
	}


	/**
     * 增加员工时获取所有部门信息，给增加页面addemp.jsp添加部门
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	private void getDeptforAdd(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		  List<Dept> deptlist = deptbiz.findAll();
		  request.setAttribute("deptlist", deptlist);
		  request.getRequestDispatcher("/addemp.jsp").forward(request, response);
		
	}

   /**
    * 查询所有员工信息
    * @param request
    * @param response
    * @throws ServletException
    * @throws IOException
    */
	private void list(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		List<Employee> list = empbiz.findAll();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/employee.jsp").forward(request, response);		
	}

    /**
     * 增加员工
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//获取页面参数
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String empname = request.getParameter("empname");
		String empsex = request.getParameter("empsex");
		String sentrydate = request.getParameter("entrydate");
		Date entrydate = DateUtil.toDate(sentrydate);//类型转换
		String empphone = request.getParameter("empphone");
		String empaddr = request.getParameter("empaddr");
		int  salary = Integer.parseInt(request.getParameter("salary"));
		//组合对象
		Employee emp = new Employee(deptno,empname,empsex,entrydate,empphone,empaddr,salary,1);
		//调用业务层
		boolean result = empbiz.entry(emp);
		String msg = "";
		if(result==true){
			msg = "操作成功！";
		}else{
			msg = "操作失败！";
		}
		request.setAttribute("msg", msg);
		list(request,response);
	}

    /**
     * 删除员工，将员工状态state置为0
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
	private void delete(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//获取请求参数
		String empno = request.getParameter("empno");
		boolean result = empbiz.deleteEmployee(empno);
		String msg = "";
		if(result==true){
			msg = "操作成功！";
		}else{
			msg = "操作失败！";
		}
		request.setAttribute("msg", msg);
		list(request,response);
		
	}

   /**
    * 变更连接请求，获得部门集合和员工对象
    * @param request
    * @param response
    * @throws ServletException
    * @throws IOException
    */
	private void getById(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		//获取请求参数
		String empno = request.getParameter("empno");
		Employee emp = empbiz.findByNo(empno);
		List<Dept> deptlist = deptbiz.findAll();
		request.setAttribute("deptlist", deptlist);//绑定部门
		request.setAttribute("emp", emp);//绑定员工
		//转发到修改页面
		request.getRequestDispatcher("/updateemp.jsp").forward(request, response);
	}

   /**
    * 变更员工信息，同时插入历史记录
    * @param request
    * @param response
    * @throws ServletException
    * @throws IOException
    */
	private void update(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		//获取页面参数
	    String empno = request.getParameter("empno");
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		String empphone = request.getParameter("empphone");
		String empaddr = request.getParameter("empaddr");
		int salary =Integer.parseInt(request.getParameter("salary"));
		
		
		Date changedate = DateUtil.getNow();
		String changereason = request.getParameter("changereason");
		Employee emp = new Employee(empno,deptno,empphone,empaddr,salary);
		History history = new History();
		history.setChangedate(changedate);
		history.setChangereason(changereason);
		//调用业务层
		boolean result = empbiz.updateEmployee(emp, history);
		String msg = "";
		if(result==true){
			msg = "操作成功！";
		}else{
			msg = "操作失败！";
		}
		request.setAttribute("msg", msg);
		list(request,response);
	}

}

HistoryServlet:
package com.employee.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.employee.po.History;
import com.employee.service.IHistoryBiz;
import com.employee.service.impl.HistoryBizImpl;

public class HistoryServlet extends HttpServlet {
    private IHistoryBiz  hisbiz = new HistoryBizImpl();
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            String method = request.getParameter("method");
            if(method.equals("list")){
            	listHistory(request,response);
            }
	}

	private void listHistory(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		String key = request.getParameter("key");
		if(key == null){
			key="";
		}
		List<History> list = hisbiz.findByKey(key);
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("/history.jsp").forward(request, response);
	}
}
3.3、完善页面内容
department.jsp 
1) 先获取 list 数据显示到表格
 2) 给增加添加链接到增加页面 
3) 给”修改”添加请求链接，绑定编号到修改页面
4)给“删除”添加请求连接，绑定编号
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
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
   <a href="adddept.jsp">新增部门</a>
</div>
<div id="contener">
  <table id="tab" cellspacing="1" border="0"  width="600" align="center">
  <tr style="background-color:#ffffff;">
    <th>部门编号</th>
    <th>部门名称</th>
     <th>操作</th>
  </tr>
  <c:forEach items="${list}" var="list">
    <tr>
    <td>${list.deptno}</td>
    <td>${list.deptname}</td>
    <%-- <a href="<%=path%>/dept.do?method=getDeptName&deptno=${list.deptno}">$</a> --%>
    <td>
    <a href="<%=path %>/dept.do?method=finByNo&id=${list.deptno}">修改</a>&nbsp;&nbsp;&nbsp;&nbsp;
    <a href="<%=path %>/dept.do?method=delete&id=${list.deptno}">删除</a>
    </td>
  </tr> 
  </c:forEach>
  
  </table>
<div id="msg">${msg }</div>   
</div>
</body>
</html>

Adddept.jsp
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
  </head>
  
  <body>
  <div class="page-header">
<h3>新增部门</h3>
</div>
    <form name="form1" method="post" action="<%=path%>/dept.do?method=add">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="120">部门名称：</td>
        <td width="380"><input type="text" name="deptname" id="deptname"></td>
      </tr>
      
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="增加">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="<%=path %>/dept.do?method=list">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

UpdateDept.jsp:
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改部门</title>
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
<h3>修改部门</h3>
</div>
    <form name="form1" method="post" action="<%=path%>/dept.do?method=update">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
     <tr>
        <td width="120">部门编号：</td>
        <td width="380"><input type="text" name="deptno" id="deptno" value="${dept.deptno }"></td>
      </tr>
      <tr>
        <td width="120">部门名称：</td>
        <td width="380"><input type="text" name="deptname" id="deptname" value="${dept.deptname }"></td>
      </tr>
      
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="保存">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="<%=path %>/dept.do?method=list">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

Employee.jsp：
1) 先获取 list 数据显示到表格
 2) 给增加添加链接到增加页面 
3) 给”变更”添加请求链接，绑定编号到修改页面
4)给“减员”添加请求连接，绑定编号
5)给“离职”添加请求连接，绑定编号到离职页面
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
	<a href="<%=path%>/employee.do?method=getDept">新增员工</a>
	</div>
	<div id="contener">
		<table id="tab" cellspacing="1" cellpadding="2" border="0" width="900" align="center">
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
		<c:forEach items="${list }" var="emp">
			<tr>
				<td>${emp.empno }</td>
				<td>${emp.deptname }</td>
				<td>${emp.empname }</td>
				<td>${emp.empsex }</td>
				<td>${emp.entrydate }</td>
				<td>${emp.empphone }</td>
				<td>${emp.empaddr }</td>
				<td>${emp.salary }</td>
				<td>${emp.leavedate }</td>
				<td>
				
				<a href="<%=path%>/employee.do?method=get&empno=${emp.empno}">变更</a>&nbsp;&nbsp;
				<a href="<%=path%>/employee.do?method=leaveGetById&empno=${emp.empno}">离职</a>&nbsp;&nbsp;
				<a href="<%=path%>/employee.do?method=delete&empno=${emp.empno}">减员</a>
				</td>
			</tr>
			</c:forEach>	
			
		</table>
<div id="msg">${msg }</div>   
	</div>
	
</body>
</html>

addEmp.jsp：
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
    <form name="form1" method="post" action="<%=path%>/employee.do?method=add">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="120">部门名称：</td>
        <td width="380">
        <select name="deptno" id="deptno">
        <c:forEach items="${deptlist}" var="dept">
         <option value="${dept.deptno}">${dept.deptname}</option>
         </c:forEach>
        </select>
        </td>
      </tr>
        <tr>
        <td width="120">员工姓名：</td>
        <td width="380"><input type="text" name="empname" id="empname"></td>
      </tr>
       <tr>
        <td width="120">员工性别：</td>
        <td width="380"><input type="radio" name="empsex" id="sex1" value="男" checked="checked">男
        <input type="radio" name="empsex" id="sex1" value="女">女
        </td>
      </tr>
      <tr>
        <td width="120">入职日期：</td>
        <td width="380"><input class="Wdate" type="text" name="entrydate" onClick="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:'true'})"/></td>
      </tr>
      </tr>
        <tr>
        <td width="120">联系电话：</td>
        <td width="380"><input type="text" name="empphone" id="empphone"></td>
      </tr>
         <tr>
        <td width="120">现住址：</td>
        <td width="380"><input type="text" size="40" name="empaddr" id="empaddr"></td>
      </tr>
       <tr>
        <td width="120">薪资：</td>
        <td width="380"><input type="text" name="salary" id="salary">￥</td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="增加">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="<%=path%>/employee.do?method=list">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

Updateemp.jsp：
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
    <form name="form1" method="post" action="<%=path%>/employee.do?method=update">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
    <input type="hidden" name="empno" id="empno" value="${emp.empno }"/>
      <tr>
        <td width="120">部门名称：</td>
        <td width="380">
        <select name="deptno" id="deptno">
         <c:forEach items="${deptlist}" var="dept">
           <option value="${dept.deptno}" <c:if test="${dept.deptno eq emp.deptno}">selected="selected"</c:if>>${dept.deptname}</option>
         </c:forEach>
        </select>
        </td>
      </tr>
        <tr>
        <td width="120">员工姓名：</td>
        <td width="380"><input type="text" name="empname" id="empname" value="${emp.empname}"  readonly="readonly"></td>
      </tr>
       <tr>
        <td width="120">员工性别：</td>
        <td width="380"><input type="radio" name="empsex" id="sex1" value="男" checked="checked">男
        <input type="radio" name="empsex" id="sex1" value="女">女
        </td>
      </tr>
      <tr>
        <td width="120">入职日期：</td>
        <td width="380"><input class="Wdate" type="text" name="entrydate"  value="${emp.entrydate}" readonly="readonly"/></td>
      </tr>
      </tr>
        <tr>
        <td width="120">联系电话：</td>
        <td width="380"><input type="text" name="empphone" id="empphone" value="${emp.empphone }"></td>
      </tr>
         <tr>
        <td width="120">现住址：</td>
        <td width="380"><input type="text" size="40" name="empaddr" id="empaddr" value="${emp.empaddr }"></td>
      </tr>
       <tr>
        <td width="120">薪资：</td>
        <td width="380"><input type="text" name="salary" id="salary" value="${emp.salary}">￥</td>
      </tr>
        <tr>
        <td width="120">变更原因：</td>
        <td width="380">
           <textarea rows="3" cols="40" name="changereason" id="schangereason"></textarea>
        </td>
      </tr>
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="保存">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="<%=path%>/employee.do?method=list">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

Dimission.jsp:
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
<h3>新增部门</h3>
</div>
    <form name="form1" method="post" action="<%=path%>/employee.do?method=leave">
    <table id="tab" width="500" border="0" cellspacing="1" cellpadding="3">
    <input type="hidden" name="empno" id="empno" value="${emp.empno }"/>
      <tr>
        <td width="120">部门名称：</td>
        <td width="380">
        <select name="deptno" id="deptno">
         <c:forEach items="${deptlist}" var="dept">
           <option value="${dept.deptno}" <c:if test="${dept.deptno eq emp.deptno}">selected="selected"</c:if>>${dept.deptname}</option>
         </c:forEach>
        </select>
        </td>
      </tr>
        <tr>
        <td width="120">员工姓名：</td>
        <td width="380"><input type="text" name="empname" id="empname" value="${emp.empname}"  readonly="readonly"></td>
      </tr>
       <tr>
        <td width="120">员工性别：</td>
        <td width="380"><input type="radio" name="empsex" id="sex1" value="男" checked="checked">男
        <input type="radio" name="empsex" id="sex1" value="女">女
        </td>
      </tr>
      <tr>
        <td width="120">入职日期：</td>
        <td width="380"><input class="Wdate" type="text" name="entrydate"  value="${emp.entrydate}" readonly="readonly"/></td>
      </tr>
      </tr>
        <tr>
        <td width="120">联系电话：</td>
        <td width="380"><input type="text" name="empphone" id="empphone" value="${emp.empphone }"></td>
      </tr>
         <tr>
        <td width="120">现住址：</td>
        <td width="380"><input type="text" size="40" name="empaddr" id="empaddr" value="${emp.empaddr }"></td>
      </tr>
       <tr>
        <td width="120">薪资：</td>
        <td width="380"><input type="text" name="salary" id="salary" value="${emp.salary}">￥</td>
      </tr>
        <tr>
        <td width="120">变更原因：</td>
        <td width="380">
           <textarea rows="3" cols="40" name="changereason" id="schangereason"></textarea>
        </td>
      </tr>
      <tr>
        <td width="120">离职原因：</td>
        <td width="380"><textarea rows="3" cols="40" name="dimissionreason" id="dimissionreason"></textarea></td>
      </tr>
      
      <tr>
        <td colspan="2" align="center"><input type="submit" name="button" id="button" value="确定">
          &nbsp; <input type="reset" name="button2" id="button2" value="取消">&nbsp;&nbsp;<a href="<%=path %>/employee.do?method=list">返回</a></td>
      </tr>
    </table>
  </form>
  </body>
</html>

History.jsp:
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
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
  <form method="post" action="<%=path%>/history.do?method=list">
     <input type="text" name="key" id="key" />&nbsp;&nbsp;<input type="submit" value="查询"/>
  </form>
</div>
<div id="contener">
  <table id="tab" cellspacing="1" border="0"  width="800" align="center">
  <tr style="background-color:#ffffff;">
    <th>员工姓名</th>
     <th>部门名称</th>
     <th>薪水</th>
      <th>变更日期</th>
      <th>变更原因</th>
      <th>离职日期</th>
       <th>离职原因</th>
  </tr>
  <c:forEach items="${list }" var="history">
    <tr>
    <td>${history.empname }</td>
    <td>${history.deptname }</td>
    <td>${history.salary }</td>
    <td>${history.changedate }</td>
    <td>${history.changereason }</td>
    <td>${history.dimissiondate }</td>
    <td>${history.dimissionreason }</td>
  </tr> 
  </c:forEach>
  
  </table>

</div>
</body>
</html>


