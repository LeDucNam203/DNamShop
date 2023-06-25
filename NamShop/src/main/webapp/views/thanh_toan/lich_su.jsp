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
            <td>Mã hóa đơn</td>
            <td>Ngày tạo</td>
            <td>Tình trạng</td>
            <td>Hành động</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSachHoaDon}" var="lichSu">
            <tr>
                <td>${lichSu.ma}</td>
                <td>${lichSu.ngayTao}</td>
                <td>
                    <c:if test="${lichSu.tinhTrang == 1}">Hóa đơn chờ</c:if>
                    <c:if test="${lichSu.tinhTrang == 2}">Hóa đơn hoàn thành</c:if>
                    <c:if test="${lichSu.tinhTrang == 3}">Hóa đơn hủy</c:if>
                </td>
                <td>
                    <a href="/chi-tiet-don-hang/${lichSu.id}" class="btn btn-primary">Xem chi tiết</a>
                    <a href="#" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/chi-tiet-san-pham/index" class="btn btn-primary">Quay lai</a>
</div>
</body>
</html>