<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <sf:form action="${ action }" method="post" modelAttribute="data">
        <div class="row mt-3">
            <div class="col-6">
                <label>Sản phẩm</label>
                <sf:select path="sanPham.id" cssClass="form-select">
                    <c:forEach items="${listSanPham}" var="sanPham">
                        <sf:option value="${sanPham.id}">${sanPham.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="sanPham"/>
            </div>
            <div class="col-6">
                <label>Nhà sản xuất</label>
                <sf:select path="nsx.id" cssClass="form-select">
                    <c:forEach items="${listNsx}" var="nsx">
                        <sf:option value="${nsx.id}">${nsx.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="nsx"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Màu sắc</label>
                <sf:select path="mauSac.id" cssClass="form-select">
                    <c:forEach items="${listMauSac}" var="mauSac">
                        <sf:option value="${mauSac.id}">${mauSac.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="mauSac"/>
            </div>
            <div class="col-6">
                <label>Dòng sản phẩm</label>
                <sf:select path="dongSP.id" cssClass="form-select">
                    <c:forEach items="${listDongSP}" var="dongSP">
                        <sf:option value="${dongSP.id}">${dongSP.ten}</sf:option>
                    </c:forEach>
                </sf:select>
                <sf:errors path="dongSP"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Năm bảo hành</label>
                <sf:input path="namBH" cssClass="form-control"/>
                <sf:errors path="namBH"/>
            </div>
            <div class="col-6">
                <label>Mô tả</label>
                <sf:input path="moTa" cssClass="form-control"/>
                <sf:errors path="moTa"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Số lượng tồn</label>
                <sf:input path="soLuongTon" cssClass="form-control"/>
                <sf:errors path="soLuongTon"/>
            </div>
            <div class="col-6">
                <label>Giá nhập</label>
                <sf:input path="giaNhap" cssClass="form-control"/>
                <sf:errors path="giaNhap"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Giá bán</label>
                <sf:input path="giaBan" cssClass="form-control"/>
                <sf:errors path="giaBan"/>
            </div>
        </div>

        <button class="btn btn-primary">Thêm</button>
    </sf:form>
</div>
</body>
</html>