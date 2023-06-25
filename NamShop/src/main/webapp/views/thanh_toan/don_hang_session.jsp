<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="vi" class="h-100">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Nền tảng - Kiến thức cơ bản về WEB | Bảng tin</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="../vendor/bootstrap/css/bootstrap.min.css" type="text/css">
    <!-- Font awesome -->
    <link rel="stylesheet" href="../vendor/font-awesome/css/font-awesome.min.css" type="text/css">

    <!-- Custom css - Các file css do chúng ta tự viết -->
    <link rel="stylesheet" href="../assets/css/app.css" type="text/css">
</head>

<body>
<%--<c:set var="khachHang" value="${sessionScope.TTKhachHang}"/>--%>
<main role="main">
    <!-- Block content - Đục lỗ trên giao diện bố cục chung, đặt tên là `content` -->
    <div class="container mt-4">
        <form class="needs-validation" method="post"
              action="/saveItem">
            <input type="hidden" name="kh_tendangnhap" value="dnpcuong">

            <div class="py-5 text-center">
                <i class="fa fa-credit-card fa-4x" aria-hidden="true"></i>
                <h2>Thanh toán</h2>
                <p class="lead">Vui lòng kiểm tra thông tin Khách hàng, thông tin Giỏ hàng trước khi Đặt hàng.</p>
            </div>
            <div class="row">

                <div class="col-md-4 order-md-2 mb-4">
                    <h4 class="d-flex justify-content-between align-items-center mb-3">
                        <span class="text-muted">Giỏ hàng</span>
                        <span class="badge badge-secondary badge-pill">2</span>
                    </h4>
                    <%--                            <input type="hidden" name="sanphamgiohang[1][sp_ma]" value="${gioHangChiTiet.tenSanPham}">--%>
                    <%--                            <input type="hidden" name="sanphamgiohang[1][sp_ma]" value="${gioHangChiTiet.tenMauSac}">--%>
                    <%--                            <input type="hidden" name="sanphamgiohang[1][gia]" value="${gioHangChiTiet.giaBan}">--%>
                    <%--                            <input type="hidden" name="sanphamgiohang[1][soluong]" value="${gioHangChiTiet.soLuong}">--%>

                    <%--                            <li class="list-group-item d-flex justify-content-between lh-condensed">--%>
                    <%--                                <div>--%>
                    <%--                                    <h6 class="my-0">${gioHangChiTiet.tenSanPham}</h6>--%>
                    <%--                                    <small class="text-muted">${gioHangChiTiet.giaBan} x ${gioHangChiTiet.soLuong}</small>--%>
                    <%--                                </div>--%>
                    <%--                                <span class="text-muted">${gioHangChiTiet.giaBan}</span>--%>
                    <%--                            </li>--%>
                    <%--                            <li class="list-group-item d-flex justify-content-between lh-condensed">--%>
                    <%--                                <div>--%>
                    <%--                                    <h6 class="my-0">${hoaDon.ma}</h6>--%>
                    <%--                                </div>--%>
                    <%--                            </li>--%>
                    <%--                            <input type="hidden" name="sanphamgiohang[2][sp_ma]" value="4">--%>
                    <%--                            <input type="hidden" name="sanphamgiohang[2][gia]" value="14990000.00">--%>
                    <%--                            <input type="hidden" name="sanphamgiohang[2][soluong]" value="8">--%>
                    <ul class="list-group mb-3">
                        <c:set var="grandTotal" value="0" /> <!-- Khởi tạo biến grandTotal -->
                        <c:forEach var="item" items="${gioHangChiTiet}">
                            <c:set var="totalPrice" value="${item.giaBan * item.soLuong}" /> <!-- Tính tổng giá trị của từng sản phẩm -->
                            <li class="list-group-item d-flex justify-content-between lh-condensed">
                                <div>
                                    <h6 class="my-0">${item.tenSanPham}</h6>
                                    <small class="text-muted">${item.giaBan} x ${item.soLuong}</small>
                                </div>
                                <span class="text-muted">${totalPrice}</span>
                            </li>
                            <c:set var="grandTotal" value="${grandTotal + totalPrice}" /> <!-- Cộng tổng giá trị của từng sản phẩm vào grandTotal -->
                        </c:forEach>
                        <li class="list-group-item d-flex justify-content-between">
                            <span>Tổng thành tiền</span>
                            <strong>${grandTotal}</strong> <!-- Hiển thị tổng thành tiền -->
                        </li>
                    </ul>

                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Mã khuyến mãi">
                        <div class="input-group-append">
                            <button type="submit" class="btn btn-secondary">Xác nhận</button>
                        </div>
                    </div>
                </div>

                <div class="col-md-8 order-md-1">
                    <h4 class="mb-3">Thông tin khách hàng</h4>

                    <div class="row">
                        <div class="col-md-12">
                            <label for="kh_ten">Họ tên</label>
                            <input type="text" class="form-control" name="kh_ten" id="kh_ten"
                                   value="${khachHang.ho} ${khachHang.tenDem} ${khachHang.ten} " readonly="">
                        </div>
                        <div class="col-md-12">
                            <label for="kh_gioitinh">Giới tính</label>
                            <input type="text" class="form-control" name="kh_gioitinh" id="kh_gioitinh"
                                   value="${khacHang.gioiTinh}"
                                   readonly="">
                        </div>
                        <div class="col-md-12">
                            <label for="kh_diachi">Địa chỉ</label>
                            <input type="text" class="form-control" name="kh_diachi" id="kh_diachi"
                                   value="${khachHang.diaChi}"
                                   readonly="">
                        </div>
                        <div class="col-md-12">
                            <label for="kh_dienthoai">Điện thoại</label>
                            <input type="text" class="form-control" name="kh_dienthoai" id="kh_dienthoai"
                                   value="${khachHang.sdt}" readonly="">
                        </div>
                        <div class="col-md-12">
                            <label for="kh_email">Email</label>
                            <input type="text" class="form-control" name="kh_email" id="kh_email"
                                   value="phucuong@ctu.edu.vn" readonly="">
                        </div>
                        <div class="col-md-12">
                            <label for="kh_ngaysinh">Ngày sinh</label>
                            <input type="text" class="form-control" name="kh_ngaysinh" id="kh_ngaysinh"
                                   value="${khachHang.ngaySinh}" readonly="">
                        </div>
                        <%--                        <div class="col-md-12">--%>
                        <%--                            <label for="kh_cmnd">CMND</label>--%>
                        <%--                            <input type="text" class="form-control" name="kh_cmnd" id="kh_cmnd" value="362209685"--%>
                        <%--                                   readonly="">--%>
                        <%--                        </div>--%>
                    </div>

                    <h4 class="mb-3">Hình thức thanh toán</h4>

                    <div class="d-block my-3">
                        <div class="custom-control custom-radio">
                            <input id="httt-1" name="httt_ma" type="radio" class="custom-control-input" required=""
                                   value="1">
                            <label class="custom-control-label" for="httt-1">Tiền mặt</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input id="httt-2" name="httt_ma" type="radio" class="custom-control-input" required=""
                                   value="2">
                            <label class="custom-control-label" for="httt-2">Chuyển khoản</label>
                        </div>
                        <div class="custom-control custom-radio">
                            <input id="httt-3" name="httt_ma" type="radio" class="custom-control-input" required=""
                                   value="3">
                            <label class="custom-control-label" for="httt-3">Ship COD</label>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <button class="btn btn-primary btn-lg btn-block" type="submit" name="btnDatHang">Đặt
                        hàng
                    </button>
                    <a href="/cancel/${idHoaDon}" class="btn btn-danger">Hủy đơn hàng</a>
                </div>
            </div>
        </form>

    </div>
    <!-- End block content -->
</main>

<!-- footer -->
<footer class="footer mt-auto py-3">
    <div class="container">
        <span>Bản quyền © bởi <a href="https://nentang.vn">Nền Tảng</a> - <script>document.write(new Date().getFullYear());</script>.</span>
        <span class="text-muted">Hành trang tới Tương lai</span>

        <p class="float-right">
            <a href="#">Về đầu trang</a>
        </p>
    </div>
</footer>
<!-- end footer -->

<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="../vendor/jquery/jquery.min.js"></script>
<script src="../vendor/popperjs/popper.min.js"></script>
<script src="../vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Custom script - Các file js do mình tự viết -->
<script src="../assets/js/app.js"></script>

</body>

</html>
