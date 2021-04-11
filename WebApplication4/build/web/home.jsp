<%-- 
 
    Document   : home
    Created on : Dec 2, 2019, 2:42:17 PM
    Author     : Tan Do
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" lang="vi">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">	
        <title>	</title>
        <%-- Latest compiled and minified CSS & JS --%>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <style>
            .banner{
                max-width: 100%;
            }
        </style>
    </head>
    <body>
        <%-- Thanh navbar hiển thị link đăng nhâp, tài khoản, đăng xuất--%>
        <nav class="navbar navbar-inverse top-menu">
            <div class="container">
                <a class="navbar-brand" href="#">Liên hệ Hotline: 19008198</a>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active">
                        <a href="login.jsp">${sessionScope.user==null?"Đăng nhập":sessionScope.user.getGreet()}</a>
                    </li>
                    <li>
                        <a href="DangXuat">Đăng xuất</a>
                    </li>
                </ul>
            </div>
        </nav>
        <header class="header">
            <div class="container">
                <div class="row">
                    <div class="col-md-3 header-logo">
                        <img src="images/logo1.png" alt="image">
                    </div>
                    <div class="col-md-9 header-form">
                        <form action="TimKiem?action=timkiemtheoten" method="POST" class="form-inline" role="form">
                            <div class="form-group">
                                <label class="sr-only" for="">label</label>
                                <input type="text" name="productName" class="form-control" id="" placeholder="Nhập thông tin cần tìm kiếm">
                            </div>
                            <button type="submit" class="btn btn-default"> <span class="glyphicon glyphicon-search"></span>
                            </button> <%-- default mau cau nut mau trang con primary sex la mau xanh --%>
                        </form>
                    </div>
                </div>
            </div>
        </header>
        <nav class="navbar navbar-default main-menu">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li class="active"><a href="TrangChu">Trang chủ</a></li>
                    <li><a href="TimKiem?action=phanloaidoituong&object=nam">Giày Nam</a></li>
                    <li><a href="TimKiem?action=phanloaidoituong&object=nu">Giày Nữ</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="text-align text-center">
                        <a href="cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span>  Giỏ Hàng</a>
                    </li>
                    <li class="text-align text-center">
                        <a href="LichSu?page=donhang">Đơn hàng của bạn</a>

                    </li>
                </ul>
            </div>
        </nav>
        <div class="banner">  <%-- Banner hiển thị thông tin cửa hàng và chạy quảng cáo --%>
            <div class="container-fluid">
                <div class="row">
                    <!-- <div class="col-md-12 banner-left">  -->
                    <div id="carousel-id" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#carousel-id" data-slide-to="0" class=""></li>
                            <li data-target="#carousel-id" data-slide-to="1" class=""></li>
                            <li data-target="#carousel-id" data-slide-to="2" class="active"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item">
                                <img src="images/banner/banner03.jpg" alt="a" style="max-width: 100%; max-height: 400px;">
                            </div>
                            <div class="item">
                                <img src="images/banner/banner02.jpg" alt="a" style="max-width: 100%; max-height: 400px;">
                            </div>
                            <div class="item active"> 
                                <%-- neu ko co item active nay la no ko hoat dong --%>
                                <img src="images/banner/banner01.jpg" alt="a" style="max-width: 100%; max-height: 400px;">
                            </div>
                        </div>
                        <a class="left carousel-control" href="#carousel-id" data-slide="prev"><span class="glyphicon glyphicon-chevron-left"></span></a>
                        <a class="right carousel-control" href="#carousel-id" data-slide="next"><span class="glyphicon glyphicon-chevron-right"></span></a>
                    </div>
                    <!-- </div> -->

                </div>
            </div>
        </div>
        <main class="main">
            <div class="products">
                <%-- chia ra 2 khung san pham --%>
                <div class="container">
                    <h2 class="title">${sessionScope.message}</h2>
                    <div class="row">
                        <c:forEach var="shoes" items="${sessionScope.list}">
                            <div class="col-sm-6 col-md-3 pro-item">
                                <div class="thumbnail">
                                    <img src="images/product/${shoes.getImage()}.jpg" alt="" style="max-width: 202.5px;max-height: 202.5px;" >
                                    <div class="caption">
                                        <h5 text-align>${shoes.getName()}</h5>
                                        <p><a href="HienThiSanPham?id=${shoes.getCode()}" class="btn btn-primary text-center">Chi tiết sản phẩm</a></p>
                                    </div>
                                </div>
                            </div>	
                            <!--prpItem-->
                        </c:forEach>		
                    </div>
                </div>
            </div>
        </main><br><br><br><br><br>
        <!-- j query -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
         <%@include file="/footer.jsp" %>
