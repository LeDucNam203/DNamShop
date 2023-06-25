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
                <label>Quốc gia</label>
                <sf:select path="quocGia" cssClass="form-select">
                    <sf:option value="VietNam">Việt Nam</sf:option>
                    <sf:option value="Japan">Nhật Bản</sf:option>
                </sf:select>
            </div>
            <div class="col-6">
                <label>Thành phố</label>
                <sf:select path="thanhPho" cssClass="form-select">
                    <sf:option value="HaNoi">Hà Nội</sf:option>
                    <sf:option value="Tokyo">Tokyo</sf:option>
                </sf:select>
            </div>
        </div>
        <div class="row mt-3">

            <div class="col-6">
                <label>Địa chỉ</label>
                <sf:input path="diaChi" cssClass="form-control"/>
            </div>
        </div>

        <button class="btn btn-primary">Thêm</button>
    </sf:form>
</div>
</body>
</html>