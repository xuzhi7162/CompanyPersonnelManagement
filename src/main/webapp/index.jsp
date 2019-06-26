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

    <link rel="stylesheet" type="text/css" href="${ctx}/css/bootstrap.css">
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
                            <li mid="tab1" funurl="/dept/list"><a tabindex="-1" href="javascript:void(0);">部门管理</a></li>
                            <li mid="tab2" funurl="/emp/list"><a tabindex="-1" href="javascript:void(0);">员工管理</a></li>
                            <li mid="tab3" funurl="/history/list"><a tabindex="-1" href="javascript:void(0);">员工变更管理</a></li>
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
    </div>
</div>
</body>
</html>
