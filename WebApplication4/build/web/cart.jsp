
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
                    <li class="active"> <a href="#">Giỏ hàng</a> </li>
                </ul>
            </div>
        </nav>
        <div class="cart main" style="width: 1000px;">
            <div class="container">
                <div class="row">
                    <div class="col-md-3"></div>
                    <div class="col-md-9">
                        <table class="table table-bordered table-hover" border="1" cellpadding="5" style="max-width: 100%;">
                            <tr>
                                <th>Số lượng</th>
                                <th>Giày</th>
                                <th>Size</th>
                                <th>Giá</th>
                                <th>Tổng tiền</th>
                            </tr>
                            <c:forEach var="item" items="${sessionScope.cart.getItems()}">
                                <tr valign="top">
                                    <td>
                                        <form action="GioHang" method="post" >
                                            <input type="hidden" name="id" value="${item.getShoes().getCode()}">
                                            <input type="hidden" name="size" value="${item.getItem().getSize()}">
                                            <input type="text" size="2" name="quantity" value="${item.getQuantity()}">
                                            <input class="btn" type="submit" value="Update" style="width: 100px;">
                                        </form>
                                    </td>
                                    <td>${item.getShoes().getName()}</td>
                                    <td>${item.getItem().getSize()}</td>
                                    <td>${item.getShoes().getPrice()} VNĐ</td>
                                    <td>${item.getTotalCurrencyFormat()} VNĐ</td>
                                    <td>
                                        <form action="GioHang" method="post">
                                            <input type="hidden" name="id" value="${item.getShoes().getCode()}">
                                            <input type="hidden" name="size" value="${item.getItem().getSize()}">
                                            <input type="hidden" name="quantity" value="0">
                                            <input class="btn" type="submit" value="Xóa" style="width: 50px;">
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                            <tr>
                                <td colspan="3">
                                    <p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>
                                </td>
                            </tr>
                        </table>
                        <br>
                        <br>
                        <form action="Checkout?action=" method="post">
                            <input class="btn" type="submit" value="Checkout" style="width: 200px;">
                        </form>
                    </div>
                </div>
            </div>
        </div><br><br><br><br><br><br><br><br><br><br><br>

        <!-- j query -->
        <script src="js/jquery.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <%@include file="/footer.jsp" %>