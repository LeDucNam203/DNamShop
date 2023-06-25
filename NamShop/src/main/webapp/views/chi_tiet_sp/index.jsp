<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="">
    <table class="table">
        <thead>
        <tr>
            <td>Tên sản phẩm</td>
            <td>Tên nhà sản xuất</td>
            <td>Tên màu sắc</td>
            <td>Tên dòng sản phẩm</td>
            <td>Năm bán hàng</td>
            <td>Mô tả</td>
            <td>Số lượng tồn</td>
            <td>Giá nhập</td>
            <td>Giá bán</td>
            <td>Hành động</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSachChiTietSP.content}" var="sanPham">
            <tr>
                <td>${sanPham.sanPham.ten}</td>
                <td>${sanPham.nsx.ten}</td>
                <td>${sanPham.mauSac.ten}</td>
                <td>${sanPham.dongSP.ten}</td>
                <td>${sanPham.namBH}</td>
                <td>${sanPham.moTa}</td>
                <td>${sanPham.soLuongTon}</td>
                <td>${sanPham.giaNhap}</td>
                <td>${sanPham.giaBan}</td>
                <td>
                    <a href="/chi-tiet-san-pham/edit/${sanPham.id}" class="btn btn-primary">Cập nhật</a>
                    <a href="/chi-tiet-san-pham/delete/${sanPham.id}" class="btn btn-danger">Xóa</a>
                    <a href="/gio-hang/store/${sanPham.id}" class="btn btn-primary">Thêm giỏ hàng</a>
<%--                    <a href="/gio-hang/cart/add/${sanPham.id}" class="btn btn-primary">Giỏ hàng DB</a>--%>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/chi-tiet-san-pham/create" class="btn btn-primary">Thêm mới</a>
    <a href="/gio-hang/viewCart" class="btn btn-primary">Giỏ hàng</a>
    <p></p>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/chi-tiet-san-pham/index?page=${loop.begin - loop.count}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="0" end="${danhSachChiTietSP.totalPages - 1}" varStatus="loop">
                <a href="/chi-tiet-san-pham/index?page=${loop.begin + loop.count-1}"
                   class="page-link">${loop.begin + loop.count}</a>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/chi-tiet-san-pham/index?page=${loop.begin + loop.count+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>