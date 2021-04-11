<%-- 
    Document   : product
    Created on : Dec 2, 2019, 3:25:20 PM
    Author     : Tan Do
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">	
        <title>	</title>
        <%-- Latest compiled and minified CSS & JS --%>
        <link rel="stylesheet" href="css/bootstrap.min.css">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <nav class="navbar navbar-inverse top-menu">
            <div class="container">
                <a class="navbar-brand" href="#">Hotline: 19008198</a>
                <ul class="nav navbar-nav navbar-right">
                    <li class="active">
                        <a href="#">Tài khoản</a>
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
                </div>
            </div>
        </header>
        <nav class="navbar navbar-default main-menu">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li > <a href="TrangChu">Trang chủ</a> </li>
                    <li class="active"> <a href="#">Chi tiết sản phẩm</a> </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="text-align text-center">
                        <a href="cart.jsp"><span class="glyphicon glyphicon-shopping-cart"></span>  Giỏ Hàng</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="main" style="max-width: 50%;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <h1>Đơn Hàng Của Bạn</h1>
                        <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%;">
                            <tr>
                                <td>Mã đơn hàng</td>
                                <td>Hình ảnh</td>
                                <td>Sản phẩm</td>
                                <td>Giá</td>
                                <td>Thời gian</td>
                                <td>Số lượng</td>
                                <td>Tổng tiền</td>
                            </tr>
                            <c:forEach var="order" items="${requestScope.listOrder}">
                                <tr>
                                    <td>${order.getId()}</td>
                                    <td><img src="images/product/${order.getShoes().getImage()}.jpg" alt="" style="max-width: 50px;max-height: 50px;" ></td>
                                    <td>${order.getShoes().getName()}</td>
                                    <td>${order.getUnitPrice()}</td>
                                    <td>${order.getCheckoutDate()}</td>
                                    <td>${order.getQuantity()}</td>
                                    <td>${order.getTotalCurrencyFormat()} VNĐ</td>
                                </tr>
                            </c:forEach>
                        </table>
                        <br>
                        <br>
                    </div>
                </div>
            </div>
            <br><br><br><br><br><br><br><br><br><br><br>

            <!-- j query -->
            <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <%@include file="/footer.jsp" %>