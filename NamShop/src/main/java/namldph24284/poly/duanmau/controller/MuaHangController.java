package namldph24284.poly.duanmau.controller;

import jakarta.servlet.http.HttpSession;
import namldph24284.poly.duanmau.entity.*;
import namldph24284.poly.duanmau.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;
import java.util.*;

@Controller
public class MuaHangController {
    @Autowired
    private HttpSession session;

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepo;
    @Autowired
    private HoaDonRepository hoaDonRepo;
    @Autowired
    private KhachHangRepository khachHangRepo;
    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepo;
    @Autowired
    private GioHangRepository gioHangRepo;
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepo;

    @GetMapping("mua-hang")
    public String muaHang(Model model) {
        model.addAttribute("ListSanPham", this.chiTietSanPhamRepo.findAll());
        return "mua_hang";
    }
    @GetMapping("add-gio-hang/{id}")
    public String addGioHang(@PathVariable("id") UUID id) {
        ChiTietSanPham chiTietSanPham = chiTietSanPhamRepo.findById(id).orElse(null);
        if (chiTietSanPham == null) {
            return "forward:/mua-hang";
        }

        UUID idUser = (UUID) session.getAttribute("userId");
        GioHang gioHang = this.gioHangRepo.findByKhachHangId(idUser);
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");

        if (gioHang == null) {
            if (khachHang == null) {
                gioHang = new GioHang();
                gioHang.setKhachHang(this.khachHangRepo.findById(idUser).orElse(null));
                gioHang.setNgayTao(LocalDate.now().toString());
                this.gioHangRepo.save(gioHang);
            }
        }
        boolean kiemTraSanPham = false;
        for (GioHangChiTiet gioHangChiTiet : gioHang.getListGH()) {
            if (gioHangChiTiet.getId().getChiTietSanPham().getId().equals(id)) {
                gioHangChiTiet.setSoLuong(gioHangChiTiet.getSoLuong() + 1);
                this.gioHangChiTietRepo.save(gioHangChiTiet);
                kiemTraSanPham = true; // Cập nhật giá trị kiemTraSanPham
                break;
            }
        }

        if (!kiemTraSanPham) {
            IdGioHangChiTiet idGioHangChiTiet = new IdGioHangChiTiet();
            idGioHangChiTiet.setGioHang(gioHang);
            idGioHangChiTiet.setChiTietSanPham(chiTietSanPham);

            GioHangChiTiet gioHangChiTiet = new GioHangChiTiet();
            gioHangChiTiet.setId(idGioHangChiTiet);
            gioHangChiTiet.setSoLuong(1);
            gioHangChiTiet.setDonGia(chiTietSanPham.getGiaBan() * gioHangChiTiet.getSoLuong());
            gioHangChiTiet.setDonGiaKhiGiam(chiTietSanPham.getGiaBan() * gioHangChiTiet.getSoLuong());
            this.gioHangChiTietRepo.save(gioHangChiTiet);
        }

        String radom = String.format("%04d", new Random().nextInt(10000));
        if (khachHang != null) {
            String ho = khachHang.getHo();
            String tenDem = khachHang.getTenDem();
            String ten = khachHang.getTen();

            String maGH = ho.substring(0, 1).toUpperCase() + tenDem.substring(0, 1).toUpperCase() + ten.substring(0, 1).toUpperCase() + radom;
            gioHang.setMa("GH" + maGH);
            this.gioHangRepo.save(gioHang);
        }
        return "forward:/mua-hang";
    }

    @GetMapping("createHoaDonMuaHang")
    public String createHoaDonMuaHang(Model model) {
        String randomNumber = String.format("%04d", new Random().nextInt(10000));
        UUID idKH = (UUID) session.getAttribute("userId");
        KhachHang nv = this.khachHangRepo.findById(idKH).orElse(null);
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa("HD" + randomNumber);
        hoaDon.setKhachHang(nv);
        hoaDon.setNgayTao(new Date());
        hoaDon.setTinhTrang(1);
        this.hoaDonRepo.save(hoaDon);
        session.setAttribute("TTKhachHang", nv);
        session.setAttribute("hoaDon", hoaDon);
        session.setAttribute("idHoaDon", hoaDon.getId());
        model.addAttribute("khachHang", nv);
        session.setAttribute("gioHangChiTiet", gioHangChiTietRepo.findAll());
        return "redirect:/thongTinHoaDon";
    }

    @GetMapping("/thongTinHoaDon")
    public String thongTinHoaDon(Model model) {
        HoaDon hoaDon = (HoaDon) session.getAttribute("hoaDon");
        KhachHang khachHang = (KhachHang) session.getAttribute("TTKhachHang");
        List<GioHangChiTiet> gioHangChiTiet = (List<GioHangChiTiet>) session.getAttribute("gioHangChiTiet");
        model.addAttribute("chiTietGioHang", gioHangChiTiet);
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("khachHang", khachHang);
        return "thanh_toan/hoa_don"; // Thay thế bằng tên trang JSP hiển thị thông tin hóa đơn
    }

    @GetMapping("/cancel/{id}")
    public String cancelInvoice(Model model,@PathVariable("id") UUID id) {
        // Tìm hóa đơn dựa trên id
        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
        UUID idHoaDon = (UUID) session.getAttribute("idHoaDon");
        model.addAttribute("idHoaDon",idHoaDon);
        if (hoaDon == null) {
            // Không tìm thấy hóa đơn, xử lý theo yêu cầu của ứng dụng của bạn
            return "forward:/chi-tiet-san-pham/index";
        }

        // Xóa hóa đơn và các chi tiết hóa đơn liên quan
        hoaDon.getListHD().clear();
        hoaDonRepo.delete(hoaDon);

        // Trả về phản hồi thành công hoặc chuyển hướng đến trang khác
        return "redirect:/gio-hang/cart";
    }

    @PostMapping("thanh-toan")
    public String thanhToan() {
        HoaDon hoaDon = (HoaDon) session.getAttribute("hoaDon");
        UUID idUser = (UUID) session.getAttribute("userId");
        GioHang gioHang = this.gioHangRepo.findByKhachHangId(idUser);
        KhachHang khachHang = (KhachHang) session.getAttribute("khachHang");

        if (gioHang != null && khachHang != null) {
            // Tạo đối tượng HoaDon
            List<GioHangChiTiet> gioHangChiTietList = gioHang.getListGH();
            for (GioHangChiTiet gioHangChiTiet : gioHangChiTietList) {
                ChiTietSanPham chiTietSanPham = gioHangChiTiet.getId().getChiTietSanPham();
                int soLuong = gioHangChiTiet.getSoLuong();
                double donGia = gioHangChiTiet.getDonGia();
                hoaDon.setTinhTrang(2);
                hoaDon.setTenNguoiNhan(khachHang.getTen());
                hoaDon.setDiaChi(khachHang.getDiaChi());
                hoaDon.setDiaChi(khachHang.getThanhPho());
                hoaDon.setDiaChi(khachHang.getQuocGia());
                hoaDon.setSdt(khachHang.getSdt());
                hoaDon.setNgayThanhToan(new Date());
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
                hoaDonChiTiet.setId(new IdHoaDonChiTiet(hoaDon, chiTietSanPham));
                hoaDonChiTiet.setSoLuong(soLuong);
                hoaDonChiTiet.setDonGia(donGia);
                this.hoaDonRepo.save(hoaDon);
                this.chiTietHoaDonRepo.save(hoaDonChiTiet);
            }

            // Xóa sản phẩm trong giỏ hàng sau khi đã chuyển sang hóa đơn chi tiết
            gioHangChiTietRepo.deleteAll(gioHangChiTietList);

            return "redirect:/mua-hang";
        }

        return "redirect:/gio-hang/cart";
    }

}
