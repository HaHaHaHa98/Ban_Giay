<%-- 
    Document   : Update_Confirm
    Created on : Dec 4, 2019, 7:14:58 AM
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
                    <li class="active"> <a href="#">Xóa sản phẩm</a> </li>
                </ul>
            </div>
        </nav>
        <div class="hinhanh">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <img class="main" src="images/product/${requestScope.shoes.getImage()}.jpg" alt="" style="max-width: 500px;max-height: 500px;">
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
                        <form action="XoaSanPham?action=delete&id=${requestScope.id}" method="post">
                            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%;">
                                <tr>
                                    <td>Mã sản phẩm</td>
                                    <td>${requestScope.shoes.getCode()}</td>
                                </tr>
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
                                    <td>Phân Loại</td>
                                    <td>${requestScope.shoes.getType()}</td>
                                </tr>
                                <tr>
                                    <td>Đối tượng</td>
                                    <td>${requestScope.shoes.getObject()}</td>
                                </tr>
                                <tr>
                                    <td>Hình ảnh</td>
                                    <td>${requestScope.shoes.getImage()}</td>
                                </tr>
                            </table>
                            <input class="btn" type="submit" value="Xóa Sản phẩm">
                        </form>
                    </div>
                </div>
            </div>
            <br><br><br><br><br><br><br><br><br><br><br>
            <footer class="footer">
                <div class="container">
                    <div class="footer-top">
                        <div class="row">
                            <hr>
                            <div class="col-md-4">
                                <h2>Liên hệ chúng tôi trên</h2>
                                <p> <a href="https://www.facebook.com/profile.php?id=100005130123824">facebook</a></p>
                            </div>
                            <div class="col-md-4">
                                <h2>Đăng kí với chúng tôi để nhận thông tin mới nhất</h2>
                            </div>
                            <div class="col-md-4">
                                <form action="" method="post" class="form-inline" role="form">

                                    <div class="form-group">
                                        <input type="email" class="form-control" id="" placeholder="Nhập email">
                                    </div>
                                    <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-envelope"></span></button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <div class="footer-main"></div>
                </div>
                <hr>
            </footer>
            <br>
            <br>
            <br>
            <!-- j query -->
            <script src="js/jquery.js"></script>
            <script src="js/bootstrap.min.js"></script>
    </body>
</html