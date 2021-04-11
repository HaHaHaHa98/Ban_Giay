<%-- 
    Document   : register
    Created on : Dec 3, 2019, 10:43:49 PM
    Author     : Tan Do
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
                    <li class="active"> <a href="#">Ký tài khoản</a> </li>
                </ul>
            </div>
        </nav>
        <div class="hinhanh">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <img class="main" src="images/product/${shoes.getImage()}.jpg" alt="" style="max-width: 500px;max-height: 600px;">
                    </div>
                </div>
            </div>                  
        </div>
        <div class="main"style="max-height: 500px;">
            <div class="container" >

                <div style="border: groove;align-self: center;">
                    <form action="DangKy" method="post">
                        <table align="center" style="height: 500px;">
                            <tr>
                                <td></td>
                                <td><h1>Đăng Ký</h1></td>
                            </tr>
                            <tr>
                                <td><b>Tài Khoản</b><br></td>
                                <td><input type="text" name="userName" size="30" placeholder="Nhập tên đăng nhập" value="${requestScope.userName}"></td>
                            </tr>
                            <tr>
                                <td><b>Mật khẩu</b><br></td>
                                <td><input type="password" name="passWord" size="30" placeholder="Nhập mật khẩu đăng nhập" value="${requestScope.passWord}"></td>
                            </tr>
                            <tr>
                                <td><b>Mật khẩu nhập lại</b><br></td>
                                <td><input type="password" name="passWordAgain" size="30" placeholder="Nhập mật khẩu đăng nhập" value="${requestScope.passWordAgain}"></td>
                            </tr>
                            <tr>
                                <td><b>Tên</b><br></td>
                                <td><input type="text" name="firstName" size="30" placeholder="Nhập tên của bạn" value="${requestScope.firstName}"></td>
                            </tr>
                            <tr>
                                <td><b>Họ</b><br></td>
                                <td><input type="text" name="lastName" size="30" placeholder="Nhập họ của bạn" value="${requestScope.lastName}"></td>
                            </tr>
                            <tr>
                                <td><b>Địa chỉ</b><br></td>
                                <td><input type="text" name="address" size="30" placeholder="Nhập địa chỉ của bạn" value="${requestScope.address}"></td>
                            </tr>
                            <tr>
                                <td><b>Sđt</b><br></td>
                                <td><input type="text" name="phone" size="30" placeholder="Nhập sdt của bạn" value="${requestScope.phone}"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="btn" type="submit" value="Đăng Ký"></td>
                            </tr>      
                        </table>
                    </form>                    
                </div>
                <br><br>
            </div>
        </div>
        <br><br><br><br><br><br><br><br><br><br><br>

        <!-- j query -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <%@include file="/footer.jsp" %>