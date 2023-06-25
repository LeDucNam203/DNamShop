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
            <td>Tên</td>
            <td>Hành động</td>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${danhSachSanPham}" var="sanPham" varStatus="stt">
            <tr>
                <td>${stt.count}</td>
                <td>${sanPham.ma}</td>
                <td>${sanPham.ten}</td>
                <td>
                    <a href="/san-pham/edit/${sanPham.id}" class="btn btn-primary">Cập nhật</a>
                    <a href="/san-pham/delete/${sanPham.id}" class="btn btn-danger">Xóa</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/san-pham/create" class="btn btn-primary">Thêm mới</a>
    <p></p>
    <nav aria-label="Page navigation example" class="text-center">
        <ul class="pagination text-center">
            <li>Trang: ${currentPage} / ${totalPages}</li>
            <c:if test="${currentPage > 1}"> <!-- Change the condition to currentPage > 1 -->
                <li><a href="/san-pham/index?page=${currentPage - 2}" class="btn btn-primary">Trang trước</a></li>
            </c:if>
            <c:forEach begin="0" end="${totalPages - 1}" varStatus="loop">
                <li>
                    <a href="/san-pham/index?page=${loop.index}" class="page-link">${loop.index + 1}</a>
                </li>
            </c:forEach>
            <c:if test="${currentPage < totalPages}"> <!-- Change the condition to currentPage < totalPages -->
                <li><a href="/san-pham/index?page=${currentPage}" class="btn btn-primary">Trang kế tiếp</a></li>
            </c:if>
        </ul>
    </nav>
</div>
</body>
</html>