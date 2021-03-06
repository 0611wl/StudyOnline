<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"><head>
    <meta charset="utf-8">
    <title>Bootstrap Admin</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" type="text/css" href="lib/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">

    <script src="lib/jquery-1.11.1.min.js" type="text/javascript"></script>

        <script src="lib/jQuery-Knob/js/jquery.knob.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(function() {
            $(".knob").knob();
        });
    </script>


    <link rel="stylesheet" type="text/css" href="stylesheets/theme.css">
    <link rel="stylesheet" type="text/css" href="stylesheets/premium.css">

</head>
<body class=" theme-blue">

    <!-- Demo page code -->

    <script type="text/javascript">
        $(function() {
            var match = document.cookie.match(new RegExp('color=([^;]+)'));
            if(match) var color = match[1];
            if(color) {
                $('body').removeClass(function (index, css) {
                    return (css.match (/\btheme-\S+/g) || []).join(' ')
                })
                $('body').addClass('theme-' + color);
            }

            $('[data-popover="true"]').popover({html: true});
            
        });
    </script>
    <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .navbar-default .navbar-brand, .navbar-default .navbar-brand:hover { 
            color: #fff;
        }
    </style>

    <script type="text/javascript">
        $(function() {
            var uls = $('.sidebar-nav > ul > *').clone();
            uls.addClass('visible-xs');
            $('#main-menu').append(uls.clone());
        });
    </script>

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="../assets/ico/favicon.ico">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="../assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="../assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="../assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="../assets/ico/apple-touch-icon-57-precomposed.png">
  

  <!--[if lt IE 7 ]> <body class="ie ie6"> <![endif]-->
  <!--[if IE 7 ]> <body class="ie ie7 "> <![endif]-->
  <!--[if IE 8 ]> <body class="ie ie8 "> <![endif]-->
  <!--[if IE 9 ]> <body class="ie ie9 "> <![endif]-->
  <!--[if (gt IE 9)|!(IE)]><!--> 
   
  <!--<![endif]-->

    <div class="navbar navbar-default" role="navigation">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="" href="index.html"><span class="navbar-brand"><span class="fa fa-paper-plane"></span> Aircraft</span></a></div>

        <div class="navbar-collapse collapse" style="height: 1px;">
          <ul id="main-menu" class="nav navbar-nav navbar-right">
            <li class="dropdown hidden-xs">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user padding-right-small" style="position:relative;top: 3px;"></span>
                    <c:if test="${not empty course }">
                    	${course.courseName }
                    </c:if>
                    <c:if test="${empty course }">
                    	暂时没有选择课程
                    </c:if>
                    <i class="fa fa-caret-down"></i>
                </a>
          </ul>

        </div>
      </div>
    </div>
    

    <div class="sidebar-nav">
    <ul>
    <li><a href="#" data-target=".dashboard-menu" class="nav-header" data-toggle="collapse"><i class="fa fa-fw fa-dashboard"></i> 选择课程<i class="fa fa-collapse"></i></a></li>
    <li><ul class="dashboard-menu nav nav-list collapse in">
    		<c:forEach items="${sessionScope.teacher.courses }" var="course">
    			<li><a href="${pageContext.request.contextPath }/webGetCourseChapters.action?courseId=${course.courseId}"> ${course.courseName }</a></li>
    		</c:forEach>
    </ul></li>
	<c:if test="${not empty chapters }">
		<li data-popover="true" data-content="Items in this group require a <strong><a href='http://portnine.com/bootstrap-themes/aircraft' target='blank'>premium license</a><strong>." rel="popover" data-placement="right"><a href="#" data-target=".premium-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-fighter-jet"></i> 章节列表<i class="fa fa-collapse"></i></a></li>
        <li><ul class="premium-menu nav nav-list collapse">
        <c:forEach items="${chapters }" var="chapter">
        	<li ><a href="webChapterInfo.action?chapterId=${chapter.chapterId }"><span class="fa fa-caret-right"></span> ${chapter.chapterName }</a></li>
    	</c:forEach>
    	</ul></li>
	</c:if>
    
	<c:if test="${not empty course }">
		<li><a href="#" data-target=".legal-menu" class="nav-header collapsed" data-toggle="collapse"><i class="fa fa-fw fa-legal"></i>查看题库<i class="fa fa-collapse"></i></a></li>
        <li><ul class="legal-menu nav nav-list collapse">
            <li ><a href="privacy-policy.html"><span class="fa fa-caret-right"></span> 选择题</a></li>
            <li ><a href="terms-and-conditions.html"><span class="fa fa-caret-right"></span> 填空题</a></li>
            <li ><a href="terms-and-conditions.html"><span class="fa fa-caret-right"></span> 解答题</a></li>
    </ul></li>
	<li><a href="materials.action" class="nav-header"><i class="fa fa-fw fa-question-circle"></i> 查看资料库</a></li>
	</c:if>
        
    </ul>
    </div>

    <div class="content">
        <div class="header">
            <div class="stats">
    
</div>

            <h1 class="page-title">课程信息</h1>
                    <ul class="breadcrumb">
        </ul>

        </div>
        <div class="main-content">
            

<div class="row">
    <div class="col-sm-* col-md-*">
        <div class="panel panel-default">
            <div class="panel-heading no-collapse">学生列表<span class="label label-warning">+10</span></div>
            <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>学号</th>
                  <th>姓名</th>
                  <th>学习时间</th>
                  <th>题目正确率</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${students }" var="student">
              		<tr>
						<td>${student.studentId }</td>
						<td>${student.name }</td>
						<td>0</td>
						<td>0</td>
              		</tr>
              	</c:forEach>
              </tbody>
            </table>
        </div>
    </div>
    
</div>
<div class="panel panel-default">
        <a href="#page-stats" class="panel-heading" data-toggle="collapse">本课程所有资料,点击收起</a>
        <div id="page-stats" class="panel-collapse panel-body collapse in">
              <table class="table table-bordered table-striped">
              <thead>
                <tr>
                  <th>序号</th>
                  <th>材料</th>
                  <th>删除</th>
                </tr>
              </thead>
              <tbody>
              	<c:forEach items="${materials }" var="material" varStatus="stu">
              		<tr>
              			<td>${stu.count }</td>
              			<td>${material.materialName }</td>
              			<td><a href="deleteStudent.action">删除</td>
              		</tr>
              	</c:forEach>
              </tbody>
            </table>
        </div>
    </div>


            <footer>
                <hr>

                <!-- Purchase a site license to remove this link from the footer: http://www.portnine.com/bootstrap-themes -->
                <p class="pull-right">A <a href="http://www.portnine.com/bootstrap-themes" target="_blank">Free Bootstrap Theme</a> by <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
                <p>© 2014 <a href="http://www.portnine.com" target="_blank">Portnine</a></p>
            </footer>
        </div>
    </div>


    <script src="lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  
</body></html>