<%-- 
    Document   : Manage
    Created on : Dec 3, 2019, 8:09:07 PM
    Author     : Tan Do
--%>

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
                </div>
            </div>
        </header>
        <nav class="navbar navbar-default main-menu">
            <div class="container">
                <ul class="nav navbar-nav">
                    <li > <a href="TrangChu">Trang chủ</a> </li>
                    <li class="active"> <a href="#">Quản lý thông tin sản phẩm</a> </li>
                </ul>
            </div>
        </nav>
        <div class="main" style="width: 1000px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <h1>Bảng thông tin sản phẩm</h1>
                        <form action="QuanLySanPham?action=add" method="post">
                            <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%; align-content: center;">
                                <tr>
                                    <td>Hình ảnh</td>
                                    <td>Tên sản phẩm</td>
                                    <td>Nhãn hàng</td>
                                    <td>Giá sản phẩm</td>
                                    <td>Phân loại</td>
                                    <td>Đối tượng sử dụng</td>
                                    <td></td>
                                    <td></td>
                                </tr>
                                <c:forEach var="shoes" items="${sessionScope.list}">
                                    <tr>
                                        <td><img src="images/product/${shoes.getImage()}.jpg" alt="" style="max-width: 50px;max-height: 50px;" ></td>
                                        <td>${shoes.getName()}</td>
                                        <td>${shoes.getBrand()}</td>
                                        <td>${shoes.getPrice()}</td>
                                        <td>${shoes.getType()}</td>
                                        <td>${shoes.getObject()}</td>
                                        <td><a href="QuanLySanPham?action=edit&id=${shoes.getCode()}">Sửa</a></td>
                                        <td><a href="QuanLySanPham?action=delete&id=${shoes.getCode()}">Xóa</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                            <input class="btn" type="submit" value="Thêm Sản Phẩm">
                        </form>
                        <br>
                        <br>
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
</html>