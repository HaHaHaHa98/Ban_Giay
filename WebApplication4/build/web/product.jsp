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
                    <li>
                        <a href="login.html">Đăng nhập</a>
                    </li>
                    <li>
                        <a href="#">Đăng xuất</a>
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
                    <li class="active"><span class="glyphicon glyphicon-shopping-cart" width="100px"></span></li>
                    <li class="text-align text-center"><a href="#">Giỏ hàng</a></li>
                </ul>
            </div>
        </nav>
        <div class="hinhanh">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <img class="main" src="images/product/${shoes.getImage()}.jpg" alt="" style="max-width: 500px;max-height: 500px;">
                    </div>
                </div>
            </div>                  
        </div>
        <div class="main" style="max-width: 50%;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <h1>Thông tin chi tiết của sản phẩm</h1>
                        <form action="<c:url value='/GioHang?id=${requestScope.shoes.getCode()}' />" method="post">
                            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%;">
                                <tr>
                                    <td>Tên sản phẩm</td>
                                    <td>${requestScope.shoes.getName()}</td>
                                </tr>
                                <tr>
                                    <td>Nhãn hàng</td>
                                    <td>${requestScope.shoes.getBrand()}</td>
                                </tr>
                                <tr>
                                    <td>Giá sản phẩm</td>
                                    <td>${requestScope.shoes.getPrice()}</td>
                                </tr>
                                <tr>
                                    <td>Loại</td>
                                    <td>${requestScope.shoes.getType()}</td>
                                </tr>
                                <tr>
                                    <td>Đối tượng</td>
                                    <td>${requestScope.shoes.getObject()}</td>
                                </tr>
                                <tr>
                                    <td>Size</td>
                                    <td>
                                        <select name="size" style="width: 100px;">
                                            <c:forEach var="item" items="${requestScope.listItem}">
                                                <option value="${item.getSize()}">${item.getSize()}</option>
                                            </c:forEach>
                                        </select>

                                    </td>
                                </tr>
                            </table>
                            <br>
                            <br>

                            <input class="btn" type="submit" value="Thêm vào giỏ">
                        </form>
                    </div>
                </div>
            </div>
            <br><br><br><br><br><br><br><br><br><br><br>

            <!-- j query -->
            <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <%@include file="/footer.jsp" %>