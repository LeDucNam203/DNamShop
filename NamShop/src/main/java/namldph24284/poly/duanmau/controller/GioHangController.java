package namldph24284.poly.duanmau.controller;

import jakarta.servlet.http.HttpSession;
import namldph24284.poly.duanmau.entity.*;
import namldph24284.poly.duanmau.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("gio-hang")
public class GioHangController {
    @Autowired
    private HttpSession session;

    @Autowired
    private GioHangRepository gioHangRepo;

    @Autowired
    private HoaDonRepository hoaDonRepo;
    @Autowired
    private KhachHangRepository khachHangRepo;
    @Autowired
    private NhanVienRepository nhanVienRepo;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepo;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepo;

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") UUID id) {
        // Lấy thông tin sản phẩm từ cơ sở dữ liệu dựa trên productId
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepo.findById(id).orElse(null);

        if (chiTietSanPham == null) {
            // Trả về phản hồi lỗi nếu không tìm thấy sản phẩm
            return "forward:/chi-tiet-san-pham/index";
        }

        // Lấy giỏ hàng của người dùng từ cơ sở dữ liệu
        UUID userId = (UUID) session.getAttribute("userId");
        GioHang gioHang1 = gioHangRepo.findByKhachHangId(userId);
        GioHang gioHang2 = gioHangRepo.findByNhanVienId(userId);
        NhanVien nhanVien = (NhanVien) session.getAttribute("nhanVien");
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");

        if (gioHang1 == null && gioHang2 == null) {
            // Tạo giỏ hàng mới nếu chưa tồn tại
            if (khachHang != null) {
                gioHang1 = new GioHang();
                gioHang1.setKhachHang(khachHangRepo.findById(userId).orElse(null));
                gioHang1.setNgayTao(LocalDate.now().toString());
                gioHangRepo.save(gioHang1); // Lưu giỏ hàng mới vào cơ sở dữ liệu
            } else if (nhanVien != null) {
                gioHang2 = new GioHang();
                gioHang2.setNhanVien(this.nhanVienRepo.findById(userId).orElse(null));
                gioHang2.setNgayTao(LocalDate.now().toString());
                gioHangRepo.save(gioHang2); // Lưu giỏ hàng mới vào cơ sở dữ liệu
            }
        }
        GioHang gioHang = (khachHang != null) ? gioHang1 : ((nhanVien != null) ? gioHang2 : null);

        // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
        boolean productExists = false;
        for (GioHangChiTiet gioHangChiTiet : gioHang.getListGH()) {
            if (gioHangChiTiet.getId().getChiTietSanPham().getId().equals(id)) {
                // Sản phẩm đã tồn tại trong giỏ hàng
                // Tăng số lượng lên 1
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
                productExists = true;
                gioHangChiTietRepo.save(gioHangChiTiet); // Lưu chi tiết giỏ hàng đã cập nhật vào cơ sở dữ liệu
                break;
            }
        }

        if (!productExists) {
            // Sản phẩm chưa tồn tại trong giỏ hàng
            // Tạo mới đối tượng IdGioHangChiTiet
            IdGioHangChiTiet idGioHangChiTiet = new IdGioHangChiTiet();
            idGioHangChiTiet.setGioHang(gioHang);
            idGioHangChiTiet.setChiTietSanPham(chiTietSanPham);

            // Tạo mới đối tượng GioHangChiTiet
            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setId(idGioHangChiTiet);
            gioHangChiTiet.setSoLuong(1);
            gioHangChiTiet.setDonGia(chiTietSanPham.getGiaBan()*gioHangChiTiet.getSoLuong());
            gioHangChiTiet.setDonGiaKhiGiam(chiTietSanPham.getGiaBan()*gioHangChiTiet.getSoLuong());
            gioHang.getListGH().add(gioHangChiTiet); // Thêm GioHangChiTiet vào danh sách chi tiết giỏ hàng
            gioHangChiTietRepo.save(gioHangChiTiet); // Lưu chi tiết giỏ hàng mới vào cơ sở dữ liệu
        }


        String randomNumber = String.format("%04d", new Random().nextInt(10000));
        if (nhanVien != null) {
            String ho = nhanVien.getHo(); // Lấy họ người dùng (nhân viên)
            String tenDem = nhanVien.getTenDem(); // Lấy tên đệm người dùng (nhân viên)
            String ten = nhanVien.getTen(); // Lấy tên người dùng (nhân viên)

            String maGH = ho.substring(0, 1).toUpperCase() + tenDem.substring(0, 1).toUpperCase() + ten.substring(0, 1).toUpperCase() + randomNumber;
            gioHang.setMa("GH"+maGH);
            gioHangRepo.save(gioHang);
        } else if (khachHang != null) {
            String ho = khachHang.getHo(); // Lấy họ người dùng (khách hàng)
            String tenDem = khachHang.getTenDem(); // Lấy tên đệm người dùng (khách hàng)
            String ten = khachHang.getTen(); // Lấy tên người dùng (khách hàng)

            String maGH = ho.substring(0, 1).toUpperCase() + tenDem.substring(0, 1).toUpperCase() + ten.substring(0, 1).toUpperCase() + randomNumber;
            gioHang.setMa("GH"+maGH);
            gioHangRepo.save(gioHang);
        }
        // Trả về phản hồi thành công
        return "forward:/chi-tiet-san-pham/index";
    }

    @GetMapping("/cart")
    public String viewCart(Model model) {
        UUID userId = (UUID) session.getAttribute("userId");
        String userType = (String) session.getAttribute("nguoiDung");

        if (userId == null || userType == null) {
            // Người dùng chưa đăng nhập, bạn có thể xử lý theo yêu cầu của ứng dụng của bạn
            // Ví dụ: chuyển hướng đến trang đăng nhập
            return "redirect:/view-login";
        }

        if (userType.equals("nhanvien")) {
            NhanVien nhanVien = (NhanVien) session.getAttribute("nhanVien");
            if (nhanVien == null) {
                // Không tìm thấy thông tin nhân viên trong session, xử lý theo yêu cầu của ứng dụng của bạn
                // Ví dụ: chuyển hướng đến trang đăng nhập
                return "redirect:/view-login";
            }

            GioHang gioHang = gioHangRepo.findByNhanVienId(nhanVien.getId());
            model.addAttribute("cartItems", gioHang.getListGH());
        } else if (userType.equals("khachhang")) {
            KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");
            if (khachHang == null) {
                // Không tìm thấy thông tin khách hàng trong session, xử lý theo yêu cầu của ứng dụng của bạn
                // Ví dụ: chuyển hướng đến trang đăng nhập
                return "redirect:/view-login";
            }

            GioHang gioHang = gioHangRepo.findByKhachHangId(khachHang.getId());
            session.setAttribute("gioHang", gioHang);
            model.addAttribute("cartItems", gioHang.getListGH());
        }

        return "gio_hang/gio_hang";
    }



    @GetMapping("deleteCartDB")
    public String deleteChiTiet(
            @RequestParam("gioHangId") UUID gioHangId,
            @RequestParam("chiTietSanPhamId") UUID chiTietSanPhamId
    ) {
        for (GioHangChiTiet gh : this.gioHangChiTietRepo.findAll()) {
            if (gh.getId().getGioHang().getId().equals(gioHangId) && gh.getId().getChiTietSanPham().getId().equals(chiTietSanPhamId)) {
                this.gioHangChiTietRepo.delete(gh);
                break; // Exit the loop after successful deletion
            }
        }
        return "redirect:/gio-hang/cart";
    }
}
