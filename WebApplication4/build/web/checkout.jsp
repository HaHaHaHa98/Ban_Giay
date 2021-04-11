<%-- 
    Document   : checkout
    Created on : Dec 3, 2019, 8:11:24 PM
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
                    <li class="active"> <a href="#">Phương thức vận chuyển và thanh toan</a> </li>
                </ul>
            </div>
        </nav>
        <div class="hinhanh">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">

                    </div>
                </div>
            </div>                  
        </div>
        <div class="main" style="max-width: 50%;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <h1>Phương thức vận chuyển và thanh toán</h1>
                        <form action="Checkout?action=confirm" method="post">
                            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%;">
                                <tr>
                                    <td>Địa chỉ</td>
                                    <td><input  type="text"  name="address" value="${sessionScope.user.getAddress()}"></td>
                                </tr>
                                <tr>
                                    <td>Đơn vị vận chuyển</td>
                                    <td>
                                        <select name="delevery">
                                            <option>Giao Hàng nhanh</option>
                                            <option>Giao Hàng tiết kiệm</option>
                                            <option>Viettel Post</option>
                                        </select>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Tài khoản ngân hàng</td>
                                    <td><input type="text" name="bark"></td>
                                </tr>
                            </table>
                            <br>
                            <br>
                            <input class="btn" type="submit" value="Xác nhận">
                        </form>
                    </div>
                </div>
            </div>
            <br><br><br><br><br><br><br><br><br><br><br>
            <!-- j query -->
            <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
            <%@include file="/footer.jsp" %>