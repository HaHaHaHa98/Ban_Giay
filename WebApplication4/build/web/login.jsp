<%-- 
    Document   : login
    Created on : Dec 3, 2019, 4:36:08 PM
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
                    <li class="active"> <a href="#">Đăng Nhập</a> </li>
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
        <div class="main"style="max-height: 500px;">
            <div class="container" >

                <div style="border: groove;align-self: center;">
                    <form action="DangNhap?action=login" method="post">
                        <table cellpadding="5" align="center" style="height: 300px;">
                            <tr>
                                <td></td>
                                <td><h1>Đăng Nhập </h1></td>
                            </tr>
                            <tr>
                                <td><b>Tài Khoản </b><br></td>
                                <td><input type="text" name="userName" size="30" placeholder="Nhập tên đăng nhập" value="${requestScope.userName}"></td>
                            </tr>
                            <tr>
                                <td><b>Mật khẩu</b><br></td>
                                <td><input type="password" name="passWord" size="30" placeholder="Nhập mật khẩu đăng nhập" value="${requestScope.passWord}"></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><input class="btn" type="submit" value="Đăng nhập" style="width: 200px;"></td>
                            </tr>  
                            <tr>
                                <td></td>
                                <td><a href="DangNhap?action=register" style="">Đăng ký tài khoản mới</a></td>
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