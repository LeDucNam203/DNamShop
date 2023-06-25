<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <sf:form action="${action}" method="post" modelAttribute="data">
        <div class="row mt-3">
            <div class="col-6">
                <label>Mã</label>
                <sf:input path="ma" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label>Tên</label>
                <sf:input path="ten" cssClass="form-control"/>
            </div>
        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Chức vụ</label>
                <sf:select path="idCV.id" cssClass="form-select">
                    <c:forEach items="${danhSachChucVu}" var="chucVu">
                        <sf:option value="${chucVu.id}">${chucVu.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
            <div class="col-6">
                <label>Cửa hàng</label>
                <sf:select path="idCH.id" cssClass="form-select">
                    <c:forEach items="${danhSachCuaHang}" var="cuaHang">
                        <sf:option value="${cuaHang.id}">${cuaHang.ten}</sf:option>
                    </c:forEach>
                </sf:select>
            </div>
        </div>

        <div class="row mt-3">
            <div class="col-6">
                <label>Tên đệm</label>
                <sf:input path="tenDem" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label>Họ</label>
                <sf:input path="ho" cssClass="form-control"/>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Ngày sinh</label>
                <sf:input path="ngaySinh" type="date" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label>Giới tính</label>
                <sf:radiobutton path="gioiTinh" value="Nam" cssClass="form-radio"/>Nam
                <sf:radiobutton path="gioiTinh" value="Nữ" cssClass="form-radio"/>Nữ
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Địa chỉ</label>
                <sf:input path="diaChi" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label>Số điện thoại</label>
                <sf:input path="sdt" cssClass="form-control"/>
            </div>

        </div>
        <div class="row mt-3">
            <div class="col-6">
                <label>Trạng thái</label>
                <sf:input path="trangThai" cssClass="form-control"/>
            </div>
            <div class="col-6">
                <label>Mật khẩu</label>
                <sf:input path="matKhau" cssClass="form-control"/>
            </div>
        </div>
        <button class="btn btn-primary">Thêm</button>
    </sf:form>
</div>
</body>
</html>