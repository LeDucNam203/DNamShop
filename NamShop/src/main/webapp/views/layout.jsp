<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/x-icon" href="assets/favicon.ico"/>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<c:set var="user" value="${sessionScope.userId}"/>
<nav class="navbar navbar-expand-lg bg-light">
    <div class="container-fluid">

        <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <a href="#" class="d-flex align-items-center text-black text-decoration-none dropdown-toggle"
               id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                <img src="https://tse2.mm.bing.net/th?id=OIP.C-xUoukm7KZqrMm0sZQD8AHaHa&pid=Api&P=0" alt="hugenerd"
                     width="35" height="0"
                     class="rounded-circle">
                <%--                <span class="d-none d-sm-inline mx-1">Chào: ${role.tenDem} ${role.ten}</span>--%>
                <div>
                <h5>Chào mừng</h5>
                    <c:choose>
                        <c:when test="${sessionScope.nguoiDung eq 'khachhang'}">
                            Khách hàng: ${sessionScope.khachHang.tenDem} ${sessionScope.khachHang.ten}
                        </c:when>
                        <c:when test="${sessionScope.nguoiDung eq 'nhanvien'}">
                            Nhân viên: ${sessionScope.nhanVien.tenDem} ${sessionScope.nhanVien.ten}
                        </c:when>
                    </c:choose>
                </div>
            </a>
            <ul class="dropdown-menu dropdown-menu-dark text-small shadow">
                <%--                <li><a class="dropdown-item" href="#">New project...</a></li>2--%>
                <li><a class="dropdown-item" href="#">Settings</a></li>
                <li><a class="dropdown-item" href="/lich-su">Lịch sử mua</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>
                <li><a class="dropdown-item" href="/view-login">Sign out</a></li>
            </ul>
            <div class="navbar-collapse collapse" id="navbarCollapse">

                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="/khach-hang/index">Khách Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/cua-hang/index">Cửa Hàng</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/chuc-vu/index">Chức Vụ</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/nhan-vien/index">Nhân Viên</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/mau-sac/index">Màu Sắc</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/san-pham/index">Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/dongSP/index">Dòng Sản Phẩm</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/nsx/index">Nhà Sản Xuất</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/chi-tiet-san-pham/index">Chi Tiết Sản Phẩm</a>
                    </li>
                </ul>
            </div>
            <ul class="navbar-nav px-3">
                <li class="nav-item text-nowrap">
                    <a class="nav-link" href="/gio-hang/cart">Giỏ hàng</a>
                </li>
                <li class="nav-item text-nowrap">
                    <!-- Nếu chưa đăng nhập thì hiển thị nút Đăng nhập -->
                    <a class="nav-link" href="/view-login">Đăng nhập</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container-fluid">
    <%--    <div class="row flex-nowrap">--%>
    <%--        <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-secondary">--%>
    <%--            <div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">--%>
    <%--                <a href="/"--%>
    <%--                   class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white ">--%>
    <%--                    <span class="fs-5 d-none d-sm-inline">Menu</span>--%>
    <%--                </a>--%>
    <%--                <ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"--%>
    <%--                    id="menu">--%>
    <%--                    <li class="nav-item">--%>
    <%--                        <a href="#" class="nav-link align-middle px-0">--%>
    <%--                            <i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>--%>
    <%--                        </a>--%>
    <%--                    </li>--%>
    <%--                    <li>--%>
    <%--                        <a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">--%>
    <%--                            <i class="fs-4 bi-speedometer2"></i> <span--%>
    <%--                                class="ms-1 d-none d-sm-inline">Sản phẩm</span> </a>--%>
    <%--                        <ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">--%>
    <%--                            <li class="w-100">--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Trà Sữa</span> 1--%>
    <%--                                </a>--%>
    <%--                            </li>--%>
    <%--                            <li>--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Sinh Tố</span> 2--%>
    <%--                                </a>--%>
    <%--                            </li>--%>
    <%--                        </ul>--%>
    <%--                    </li>--%>
    <%--                    <li>--%>
    <%--                        <a href="#" class="nav-link px-0 align-middle">--%>
    <%--                            <i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Orders</span></a>--%>
    <%--                    </li>--%>
    <%--                    <li>--%>
    <%--                        <a href="#submenu2" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">--%>
    <%--                            <i class="fs-4 bi-bootstrap"></i> <span--%>
    <%--                                class="ms-1 d-none d-sm-inline">Quản Lý Nhân Viên</span></a>--%>
    <%--                        <ul class="collapse nav flex-column ms-1" id="submenu2" data-bs-parent="#menu">--%>
    <%--                            <li class="w-100">--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Item</span>--%>
    <%--                                    1</a>--%>
    <%--                            </li>--%>
    <%--                            <li>--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Item</span>--%>
    <%--                                    2</a>--%>
    <%--                            </li>--%>
    <%--                        </ul>--%>
    <%--                    </li>--%>
    <%--                    <li>--%>
    <%--                        <a href="#submenu3" data-bs-toggle="collapse" class="nav-link px-0 align-middle">--%>
    <%--                            <i class="fs-4 bi-grid"></i> <span class="ms-1 d-none d-sm-inline">Products</span> </a>--%>
    <%--                        <ul class="collapse nav flex-column ms-1" id="submenu3" data-bs-parent="#menu">--%>
    <%--                            <li class="w-100">--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 1</a>--%>
    <%--                            </li>--%>
    <%--                            <li>--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 2</a>--%>
    <%--                            </li>--%>
    <%--                            <li>--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 3</a>--%>
    <%--                            </li>--%>
    <%--                            <li>--%>
    <%--                                <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 4</a>--%>
    <%--                            </li>--%>
    <%--                        </ul>--%>
    <%--                    </li>--%>
    <%--                    <li>--%>
    <%--                        <a href="#" class="nav-link px-0 align-middle">--%>
    <%--                            <i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Customers</span>--%>
    <%--                        </a>--%>
    <%--                    </li>--%>
    <%--                </ul>--%>
    <%--                <hr>--%>

    <%--            </div>--%>
    <%--        </div>--%>
    <div class="col py-3" style="min-height: 500px">
        <jsp:include page="${ view }"/>
    </div>
</div>
</div>


<div class="row " style="min-height: 200px;">
    <footer class="text-center text-lg-start text-white bg-secondary">
        <!-- Grid container -->
        <div class="container p-4 pb-0">
            <!-- Section: Links -->
            <section class="">
                <!--Grid row-->
                <div class="row">
                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-3 col-xl-3 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">
                            Company name
                        </h6>
                        <p>
                            Ở đây bạn có thể ăn uống và tận hưởng niềm vui khi uống đồ uống tại
                            Nam-MinHo-Store
                        </p>
                    </div>
                    <!-- Grid column -->

                    <hr class="w-100 clearfix d-md-none"/>

                    <!-- Grid column -->
                    <div class="col-md-2 col-lg-2 col-xl-2 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">Products</h6>
                        <p>
                            <a class="text-white">Trà Sữa</a>
                        </p>
                        <p>
                            <a class="text-white">Kem</a>
                        </p>
                        <p>
                            <a class="text-white">Trà trái cây</a>
                        </p>
                        <p>
                            <a class="text-white">Topping</a>
                        </p>
                    </div>
                    <!-- Grid column -->

                    <hr class="w-100 clearfix d-md-none"/>

                    <!-- Grid column -->
                    <hr class="w-100 clearfix d-md-none"/>

                    <!-- Grid column -->
                    <div class="col-md-4 col-lg-3 col-xl-3 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">Contact</h6>
                        <p><i class="fas fa-home mr-3"></i> Mỹ Đình, Hà Nội</p>
                        <p><i class="fas fa-envelope mr-3"></i> namldph24284@gmail.com</p>
                        <p><i class="fas fa-phone mr-3"></i> + 08 324 839 34</p>
                        <p><i class="fas fa-print mr-3"></i> + 01 234 567 89</p>
                    </div>
                    <!-- Grid column -->

                    <!-- Grid column -->
                    <div class="col-md-3 col-lg-2 col-xl-2 mx-auto mt-3">
                        <h6 class="text-uppercase mb-4 font-weight-bold">Follow us</h6>

                        <!-- Facebook -->
                        <a class="btn btn-primary btn-floating m-1" style="background-color: #3b5998" href="#!"
                           role="button"><i class="fab fa-facebook-f"></i></a>

                        <!-- Twitter -->
                        <a class="btn btn-primary btn-floating m-1" style="background-color: #55acee" href="#!"
                           role="button"><i class="fab fa-twitter"></i></a>

                        <!-- Google -->
                        <a class="btn btn-primary btn-floating m-1" style="background-color: #dd4b39" href="#!"
                           role="button"><i class="fab fa-google"></i></a>

                        <!-- Instagram -->
                        <a class="btn btn-primary btn-floating m-1" style="background-color: #ac2bac" href="#!"
                           role="button"><i class="fab fa-instagram"></i></a>

                        <!-- Linkedin -->
                        <a class="btn btn-primary btn-floating m-1" style="background-color: #0082ca" href="#!"
                           role="button"><i class="fab fa-linkedin-in"></i></a>
                        <!-- Github -->
                        <a class="btn btn-primary btn-floating m-1" style="background-color: #333333" href="#!"
                           role="button"><i class="fab fa-github"></i></a>
                    </div>

                </div>
                <!--Grid row-->
            </section>
            <!-- Section: Links -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2)">
            © Nam-MinHo:
            <a class="text-white" href="https://www.facebook.com/profile.php?id=100029701398123">Lê Đức
                Nam</a>
        </div>
        <!-- Copyright -->
    </footer>
</div>
<script src="/SP23B2_SOF3011_IT17313_war_exploded/js/bootstrap.min.js"></script>
</body>
</html>
