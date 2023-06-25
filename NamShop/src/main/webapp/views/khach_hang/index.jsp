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
            <td>Mã</td>
            <td>Họ và tên</td>
            <td>Ngày sinh</td>
            <td>Số điện thoại</td>
            <td>Địa chỉ</td>
            <td>Thành phố</td>
            <td>Quốc gia</td>
            <td>Mật khẩu</td>
            <td>Hành động</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSachKhachHang.content}" var="khachHang">
            <tr>
                <td>${khachHang.ma}</td>
                <td>${khachHang.ho} ${khachHang.tenDem} ${khachHang.ten} </td>
                <td>${khachHang.ngaySinh}</td>
                <td>${khachHang.sdt}</td>
                <td>${khachHang.diaChi}</td>
                <td>${khachHang.thanhPho}</td>
                <td>${khachHang.quocGia}</td>
                <td>${khachHang.matKhau}</td>
                <td>
                    <a href="/khach-hang/edit/${khachHang.id}" class="btn btn-primary">Cập nhật</a>
                    <a href="/khach-hang/delete/${khachHang.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/khach-hang/create" class="btn btn-primary">Thêm mới</a>
    <p></p>
    <nav aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="/khach-hang/index?page=${loop.begin - loop.count}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <c:forEach begin="0" end="${danhSachKhachHang.totalPages - 1}" varStatus="loop">
                <a href="/khach-hang/index?page=${loop.begin + loop.count-1}"
                   class="page-link">${loop.begin + loop.count}</a>
            </c:forEach>
            <li class="page-item">
                <a class="page-link" href="/khach-hang/index?page=${loop.begin + loop.count+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>
</body>
</html>