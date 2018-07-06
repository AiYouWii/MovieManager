<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name=”viewport” content=”width=device-width, initial-scale=1″ />
    <link href="../css/bootstrap.min.css" rel="stylesheet">
    <link rel="icon" type="image/x-icon" href="../public/Ali.ico">
    <link href="../css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="../css/front-index.css"/>
    <link rel="stylesheet" href="../js/layui/css/layui.css"/>
    <script src="../js/jquery.js"></script>
    <script src="../js/flexisel.js"></script>
    <script src="../js/layui/layui.all.js"></script>
    <script src="../js/front-index.js"></script>
    <title>Ali⊙Movie●</title>
</head>
<body>
    <div id="head"></div>
    <div id="main">
        <div class="content" >
            <div id="top-body">
                <div id="top-header">
                    <div id="logo">
                        <p>Movie Theater</p>
                    </div>
                    <div id="user">
                        
                    </div>
                </div>
                
            </div>
            <div id="review-slider">
                <ul id="flexiselDemo1">
                    <li><img src="../other/img/r1.jpg" alt=""/></li>
                    <li><img src="../other/img/r2.jpg" alt=""/></li>
                    <li><img src="../other/img/r3.jpg" alt=""/></li>
                    <li><img src="../other/img/r4.jpg" alt=""/></li>
                    <li><img src="../other/img/r5.jpg" alt=""/></li>
                    <li><img src="../other/img/r6.jpg" alt=""/></li>
                </ul>
            </div>
            <div id="content-info">
                
            </div>
            
        </div>
        
        <!-- 列表 -->
        <div class="content-list" style="display: none;">
        	<c:forEach var="mv" items="${movieList }">
        		<div class="content-imgs cursor" data-index="${mv.id }">
	                <img src="${pageContext.request.contextPath}/images/${mv.img }" alt="">
	            </div>
        	</c:forEach>
            
        </div>

        <div class="footer">
            <div class="copyright">
                <p>Copyright &copy; 2015.Company name All rights reserved. -- Ali⊙Movie● </p>
            </div>  
        </div>  
    </div>
</body>
</html>