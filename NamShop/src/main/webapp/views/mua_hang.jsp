<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Nam-MinHo-Store</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet"/>
    <!-- Core theme CSS (includes Bootstrap)-->
    <link href="css/styles.css" rel="stylesheet"/>

    <style>
        .carousel-inner img {
            width: 100%;
            height: 450px;
        }
    </style>
</head>

<body>
<!-- nav -->
<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top">
    <div class="container px-4 px-lg-5">
        <a class="navbar-brand" href="/mua-hang">namldph24284</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="/mua-hang">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="#!">Quiz</a></li>
                <li class="nav-item dropdown navbar-nav navbar-right">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Lab</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Lab-1</a></li>
                        <li><a class="dropdown-item" href="#!">Lab-2</a></li>
                        <li><a class="dropdown-item" href="#!">Lab-3</a></li>
                        <li><a class="dropdown-item" href="#!">Lab-4</a></li>
                    </ul>
                </li>

                <li class="nav-item dropdown navbar-nav navbar-right">
                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button"
                       data-bs-toggle="dropdown" aria-expanded="false">Assignment</a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <li><a class="dropdown-item" href="#!">Assignment hoàn thiện</a></li>
                        <li>
                            <hr class="dropdown-divider"/>
                        </li>
                        <li><a class="dropdown-item" href="#!">Assignment giai đoạn 1</a></li>
                        <li><a class="dropdown-item" href="#!">Assignment giai đoạn 2</a></li>
                    </ul>
                </li>
                <li class="nav-item"><a class="nav-link" href="#!">Final Exam</a></li>
            </ul>
            <form class="d-flex" action="/gio-hang/cart" method="get">
                <button class="btn btn-outline-dark" type="submit">
                    <span class="badge bg-dark text-white ms-1 rounded-pill">0</span>
                    Cart
                    <i class="bi-cart-fill me-1"></i>
                </button>
            </form>
        </div>
    </div>
</nav>
<!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">

    <!-- Indicators/dots -->
    <div class="carousel-indicators">
        <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
        <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
    </div>

    <!-- The slideshow/carousel -->
    <div class="carousel-inner">
<%--        <div class="carousel-item active">--%>
<%--            <img src="https://www.mbusa.com/content/dam/mb-nafta/us/myco/my22/s/maybach/gallery/series/gallery-type-page/2022-S-MAYBACH-GAL-001-L-TE-DR.jpg"--%>
<%--                 alt="Los Angeles" class="d-block w-100">--%>
<%--        </div>--%>
        <div class="carousel-item">
            <img src="https://www.lamborghini.com/sites/it-en/files/DAM/lamborghini/news/2023/01_26_urus/cover.jpg"
                 alt="Chicago" class="d-block w-100">
        </div>
        <div class="carousel-item">
            <img src="https://hips.hearstapps.com/hmg-prod/images/2021-rolls-royce-cullinan-mmp-3-1606753972.jpg?crop=1.00xw:0.918xh;0,0.0510xh&resize=980:*"
                 alt="New York" class="d-block w-100">
        </div>
    </div>

    <!-- Left and right controls/icons -->
    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
        <span class="carousel-control-prev-icon"></span>
    </button>
    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
        <span class="carousel-control-next-icon"></span>
    </button>
</div>

<!-- Section-->
<section class="py-5">
    <div class="container px-3 px-lg-5 mt-5">
        <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
            <c:forEach items="${ListSanPham}" var="sanPham">
                <div class="col mb-5">
                    <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top"
                             src="https://cdn.24.co.za/files/Cms/General/d/11099/ad38ebdd429246cb9148b3dddbc4d3d7.jpg"
                             alt="..."/>
                        <!-- Product details-->
                        <div class="card-body p-4">
                            <div class="text-center">
                                <!-- Product name Lamborghini Urus-->
                                <h5 class="fw-bolder">${sanPham.sanPham.ten} ${sanPham.nsx.ten}  ${sanPham.dongSP.ten} ${sanPham.mauSac.ten}</h5>
                                <div class="d-flex justify-content-center small text-warning mb-2">
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                </div>
                                <!-- Product price-->
                                    ${sanPham.giaBan}
                            </div>
                        </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i
                                    class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="/add-gio-hang/${sanPham.id}"><i
                                    class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i
                                    class="bi bi-heart"></i></a></div>
                        </div>
                    </div>
                </div>
            </c:forEach>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Sale badge-->--%>
<%--                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale--%>
<%--                    </div>--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top"--%>
<%--                         src="https://tse3.mm.bing.net/th?id=OIP.PqTrq_hJzIWs5gb_tmpZUAHaE8&pid=Api&P=0" alt="..."/>--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">AMG G 63 SUV</h5>--%>
<%--                            <!-- Product reviews-->--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            <span class="text-muted text-decoration-line-through">$420.000</span>--%>
<%--                            $380.000--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-heart"></i></a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Sale badge-->--%>
<%--                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale--%>
<%--                    </div>--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top"--%>
<%--                         src="https://tse4.mm.bing.net/th?id=OIP.0DhkURSD7wOuXY539a2nBgHaE8&pid=Api&P=0" alt="..."/>--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Range Rover Velar</h5>--%>
<%--                            <!-- Product reviews-->--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            <span class="text-muted text-decoration-line-through">$70.000</span>--%>
<%--                            $59.000--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-heart"></i></a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top"--%>
<%--                         src="https://scr.vn/wp-content/uploads/2020/07/T%E1%BA%A3i-h%C3%ACnh-n%E1%BB%81n-4k-Si%C3%AAu-xe-Roll-Royce-scaled-2048x1152.jpg"--%>
<%--                         alt="..."/>--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Rolls-Royce Phantom EWB Limousine Chengdu</h5>--%>
<%--                            <!-- Product reviews-->--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            $700.000--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-heart"></i></a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top"--%>
<%--                         src="https://img.mensxp.com/media/content/2019/Oct/exelero-1569936656.jpg" alt="..."/>--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Maybach Exelero sold</h5>--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            $675.000 - $660.000--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-heart"></i></a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--            <div class="col mb-5">--%>
<%--                <div class="card h-100">--%>
<%--                    <!-- Sale badge-->--%>
<%--                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale--%>
<%--                    </div>--%>
<%--                    <!-- Product image-->--%>
<%--                    <img class="card-img-top"--%>
<%--                         src="https://hips.hearstapps.com/hmg-prod/images/phantom-series-ii-2-1652357186.jpg?crop=1.00xw:0.795xh;0,0.114xh&resize=1200:*"--%>
<%--                         alt="..."/>--%>
<%--                    <!-- Product details-->--%>
<%--                    <div class="card-body p-4">--%>
<%--                        <div class="text-center">--%>
<%--                            <!-- Product name-->--%>
<%--                            <h5 class="fw-bolder">Rolls-Royce Phantom</h5>--%>
<%--                            <div class="d-flex justify-content-center small text-warning mb-2">--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                                <div class="bi-star-fill"></div>--%>
<%--                            </div>--%>
<%--                            <!-- Product price-->--%>
<%--                            <span class="text-muted text-decoration-line-through">$500.000</span>--%>
<%--                            $460,000--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <!-- Product actions-->--%>
<%--                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">--%>
<%--                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i--%>
<%--                                class="bi bi-heart"></i></a></div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Sale badge-->
                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale
                    </div>
                    <!-- Product image-->
                    <img class="card-img-top"
                         src="https://tse1.mm.bing.net/th?id=OIP.93oj_zNOXwsGWsGn3DJgWQHaE7&pid=Api&P=0" alt="..."/>
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">Lamborghini AVENTADOR SVJ 2207 Miles</h5>
                            <!-- Product price-->
                            <span class="text-muted text-decoration-line-through">$529,000</span>
                            $466.000
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-heart"></i></a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Sale badge-->
                    <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale
                    </div>
                    <!-- Product image-->
                    <img class="card-img-top"
                         src="https://cdn.motor1.com/images/mgl/PvpK2/s1/34-million-lykan-hypersport-is-about-to-get-a-1000-hp-sibling.jpg"
                         alt="..."/>
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">Lykan Hypersports</h5>
                            <!-- Product reviews-->
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                            </div>
                            <!-- Product price-->
                            <span class="text-muted text-decoration-line-through">$479.000</span>
                            $400.000
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-heart"></i></a></div>
                    </div>
                </div>
            </div>
            <div class="col mb-5">
                <div class="card h-100">
                    <!-- Product image-->
                    <img class="card-img-top"
                         src="https://www.millermotorcars.com/imagetag/1421/main/l/Used-2012-Bugatti-Veyron-164-Super-Sport.jpg"
                         alt="..."/>
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">Bugatti Veyron 16.4 Super Sport</h5>
                            <!-- Product reviews-->
                            <div class="d-flex justify-content-center small text-warning mb-2">
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                                <div class="bi-star-fill"></div>
                            </div>
                            <!-- Product price-->
                            $400.000
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-eye"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-cart"></i></a> <a class="btn btn-outline-dark mt-auto" href="#"><i
                                class="bi bi-heart"></i></a></div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!-- footer -->
<div class="container my-5">

    <footer class="bg-light text-center text-white">
        <!-- Grid container -->
        <div class="container p-4 pb-0">
            <!-- Section: Social media -->
            <section class="mb-4">
                <!-- Facebook -->
                <a class="btn btn-primary btn-floating m-1" style="background-color: #3b5998;" href="#!"
                   role="button"><i class="bi bi-facebook"></i></a>

                <!-- Twitter -->
                <a class="btn btn-primary btn-floating m-1" style="background-color: #55acee;" href="#!"
                   role="button"><i class="bi bi-twitter"></i></a>

                <!-- Google -->
                <a class="btn btn-primary btn-floating m-1" style="background-color: #dd4b39;" href="#!"
                   role="button"><i class="bi bi-google"></i></a>

                <!-- Instagram -->
                <a class="btn btn-primary btn-floating m-1" style="background-color: #ac2bac;" href="#!"
                   role="button"><i class="bi bi-instagram"></i></a>

                <!-- Linkedin -->
                <a class="btn btn-primary btn-floating m-1" style="background-color: #0082ca;" href="#!"
                   role="button"><i class="bi bi-discord"></i></a>
                <!-- tiktok -->
                <a class="btn btn-primary btn-floating m-1" style="background-color: #333333;" href="#!"
                   role="button"><i class="bi bi-github"></i></a>
            </section>
            <!-- Section: Social media -->
        </div>
        <!-- Grid container -->

        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © Chủ shop:
            <a class="text-white" href="https://www.facebook.com/profile.php?id=100029701398123">Lê Đức Nam</a>
        </div>
        <!-- Copyright -->
    </footer>

</div>
</body>
</html>