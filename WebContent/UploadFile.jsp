<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>html5文件上传输入框样式代码 - 代码笔记</title>

<!--可无视-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/stylesheets/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />

<!--必要样式-->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/stylesheets/component.css" />

<script>(function(e,t,n){var r=e.querySelectorAll("html")[0];r.className=r.className.replace(/(^|\s)no-js(\s|$)/,"$1js$2")})(document,window,0);</script>

</head>
<body>
<form action="upload.action" method="post" enctype="multipart/form-data">
		<div class="container">
			
				<div class="content">

					<div class="box">
						<input type="file" name="file" id="file-2" class="inputfile inputfile-2" data-multiple-caption="{count} files selected" multiple accept="application/pdf,video/mp4" />
						<label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>选择一个文件上传</span></label>
					</div>
					<input type="submit" value="上传"/>	
				</div>
			
		</div>
		
</form>
<!-- <form action="upload1.action" method="post" enctype="multipart/form-data">
		<div class="container">
			
				<div class="content">

					<div class="box">
						<input type="file" name="file" id="file-2" class="inputfile inputfile-2" data-multiple-caption="{count} files selected" multiple accept="application/vnd.ms-excel,application/vnd.openxmlformats-officedocument.spreadsheetml.sheet" />
						<label for="file-2"><svg xmlns="http://www.w3.org/2000/svg" width="20" height="17" viewBox="0 0 20 17"><path d="M10 0l-5.2 4.9h3.3v5.1h3.8v-5.1h3.3l-5.2-4.9zm9.3 11.5l-3.2-2.1h-2l3.4 2.6h-3.5c-.1 0-.2.1-.2.1l-.8 2.3h-6l-.8-2.2c-.1-.1-.1-.2-.2-.2h-3.6l3.4-2.6h-2l-3.2 2.1c-.4.3-.7 1-.6 1.5l.6 3.1c.1.5.7.9 1.2.9h16.3c.6 0 1.1-.4 1.3-.9l.6-3.1c.1-.5-.2-1.2-.7-1.5z"/></svg> <span>选择一个题库上传</span></label>
					</div>
					<input type="submit" value="上传"/>	
				</div>
			
		</div>
		
</form> -->
		<script src="${pageContext.request.contextPath }/js/custom-file-input.js"></script>
</body>
</html>