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
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/stylesheets/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />

<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/stylesheets/component.css" />

<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

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
            




    <div class="panel panel-default">
        <a href="#page-stats" class="panel-heading" data-toggle="collapse">Latest Stats</a>
        <div id="page-stats" class="panel-collapse panel-body collapse in">

                    <div class="row">
                        <div class="col-md-3 col-sm-6">
                            <div class="knob-container">
                                <input class="knob" data-width="200" data-min="0" data-max="3000" data-displayPrevious="true" value="2500" data-fgColor="#92A3C2" data-readOnly=true;>
                                <h3 class="text-muted text-center">Accounts</h3>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="knob-container">
                                <input class="knob" data-width="200" data-min="0" data-max="4500" data-displayPrevious="true" value="3299" data-fgColor="#92A3C2" data-readOnly=true;>
                                <h3 class="text-muted text-center">Subscribers</h3>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="knob-container">
                                <input class="knob" data-width="200" data-min="0" data-max="2700" data-displayPrevious="true" value="1840" data-fgColor="#92A3C2" data-readOnly=true;>
                                <h3 class="text-muted text-center">Pending</h3>
                            </div>
                        </div>
                        <div class="col-md-3 col-sm-6">
                            <div class="knob-container">
                                <input class="knob" data-width="200" data-min="0" data-max="15000" data-displayPrevious="true" value="10067" data-fgColor="#92A3C2" data-readOnly=true;>
                                <h3 class="text-muted text-center">Completed</h3>
                            </div>
                        </div>
                    </div>
        </div>
    </div>

<form action="upload.action" method="post" enctype="multipart/form-data">

					<div class="box">
						<input type="file" name="file" id="file-2" class="inputfile inputfile-2" data-multiple-caption="{count} files selected" multiple accept="application/pdf,video/mp4" />
						<label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>选择一个资料上传</span></label>
					</div>
					<input type="submit" value="上传"/>	
</form>
<div class="row">
    <div class="col-sm-* col-md-*">
        <div class="panel panel-default">
            <div class="panel-heading no-collapse">资料列表<span class="label label-warning">+10</span></div>
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