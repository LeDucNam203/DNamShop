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
            <td>Tên sản phẩm</td>
            <td>Tên dòng sản phẩm</td>
            <td>Tên nhà sản xuất</td>
            <td>Tên màu sắc</td>
            <td>Số lượng</td>
            <td>Giá bán</td>
            <td>Hành động</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${gioHangChiTiet}" var="sanPham">
            <tr>
                <td>${sanPham.tenSanPham}</td>
                <td>${sanPham.tenDongSP}</td>
                <td>${sanPham.tenNhaSanXuat}</td>
                <td>${sanPham.tenMauSac}</td>
                <td>${sanPham.soLuong}</td>
                <td>${sanPham.giaBan}</td>
                <td>
                    <a href="/chi-tiet-san-pham/edit/${sanPham.id}" class="btn btn-primary">Cập nhật</a>
                    <a href="/gio-hang/deleteCart/${sanPham.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/chi-tiet-san-pham/index" class="btn btn-primary">Quay lai</a>
    <a href="/createHoaDon" class="btn btn-primary">Thanh toán</a>
</div>
</body>
</html>