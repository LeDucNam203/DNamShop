<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <td>Ma hoa don</td>
            <td>Tên sản phẩm</td>
            <td>Số lượng</td>
            <td>Giá bán</td>
            <td>Don gia khi giam</td>
            <td>Hành động</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${lichSuMuaHang}" var="sanPham">
            <tr>
                <td>${sanPham.id.hoaDon.ma}</td>
                <td>${sanPham.id.chiTietSanPham.sanPham.ten}</td>
                <td>${sanPham.soLuong}</td>
                <td>${sanPham.soLuong}</td>
                <td>${sanPham.donGia}</td>
                <td>
                    <a href="#" class="btn btn-primary">Mua lại</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="#" class="btn btn-primary">Thanh toán</a>
</div>
</body>
</html>