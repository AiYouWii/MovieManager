<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/public/Ali.ico">
    <link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminLogin.css"/>
    <script src="${pageContext.request.contextPath}/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/js/layer/layer.js"></script>
    <script src="${pageContext.request.contextPath}/js/adminLogin.js"></script>
    <title>Ali⊙Movie●Manage</title>
</head>
<body id="body-content">
	<div id="content">
		<div id="login-form">
			<h1 class="login-title">
				Ali⊙Manage
			</h1>
			<div class="input-group m-b-20">
				<span class="input-group-addon">
					<i class="fa fa-user" aria-hidden="true"></i>
				</span>
				<div>
					<input type="text" name="user" class="form-control" placeholder="Username">
				</div>
			</div>
			<div class="input-group m-b-20">
				<span class="input-group-addon">
					<i class="fa fa-unlock-alt" aria-hidden="true"></i>
				</span>
				<div>
					<input type="password" name="pass" class="form-control" placeholder="Password">
				</div>
			</div>
			<div class="login-btn">
				<i class="fa fa-paper-plane" aria-hidden="true"></i>
			</div>
		</div>
	</div>
</body>
</html>