package namldph24284.poly.duanmau.controller;

import jakarta.servlet.http.HttpSession;
import namldph24284.poly.duanmau.entity.*;
import namldph24284.poly.duanmau.repository.*;
import namldph24284.poly.duanmau.service.ChiTietHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class HoaDonController {
    private UUID hoaDonId;
    @Autowired
    private HttpSession session;
    @Autowired
    private NhanVienRepository nhanVienRepo;
    @Autowired
    private KhachHangRepository khachHangRepo;

    @Autowired
    private HoaDonRepository hoaDonRepo;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepo;

    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepo;

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping("createHoaDon")
    public String createHoaDon(Model model) {
        String randomNumber = String.format("%04d", new Random().nextInt(10000));
        UUID idKH = (UUID) session.getAttribute("userId");
        NhanVien nv = this.nhanVienRepo.findById(idKH).orElse(null);
        HoaDon hoaDon = new HoaDon();
        hoaDon.setMa("HD" + randomNumber);
        hoaDon.setNhanVien(nv);
        hoaDon.setNgayTao(new Date());
        hoaDon.setTinhTrang(1);
        this.hoaDonRepo.save(hoaDon);
        hoaDonId = hoaDon.getId();
        session.setAttribute("TTKhachHang", nv);

        Cart cart = (Cart) session.getAttribute("cart");
        ArrayList<Item> listItem = cart.getListItem();

        // Set the gioHangChiTiet attribute in the session
        session.setAttribute("gioHangChiTiet", listItem);

        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("khachHang", nv);
        model.addAttribute("gioHangChiTiet", listItem);

        return "forward:/hoaDon/" + hoaDon.getId(); // Trả về trang JSP trực tiếp, không sử dụng redirect
    }

    @GetMapping("/hoaDon/{id}")
    public String viewHoaDon(@PathVariable("id") UUID id, Model model) {
        HoaDon hoaDon = hoaDonRepo.findById(id).orElse(null);
        NhanVien nhanVien = (NhanVien) session.getAttribute("TTKhachHang");
        model.addAttribute("hoaDon", hoaDon);
        model.addAttribute("khachHang", nhanVien);
        return "thanh_toan/don_hang_session";
    }

    @PostMapping("saveItem")
    public String saveItem(HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        ArrayList<Item> listItem = cart.getListItem();
        if (cart != null) {
            for (Item item : listItem) {
                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();

                HoaDon hoaDon = hoaDonRepo.findById(hoaDonId).orElse(null);
//                hoaDonChiTiet.getId().setHoaDon(hoaDon);
                hoaDon.setTinhTrang(2);
//                hoaDon.setTenNguoiNhan(hoaDonChiTiet);
                hoaDon.setNgayThanhToan(new Date());
                this.hoaDonRepo.save(hoaDon);
                session.setAttribute("idHoaDon", hoaDon.getId());
                ChiTietSanPham chiTietSanPham = chiTietSanPhamRepo.findById(item.getId()).orElse(null);
//                hoaDonChiTiet.getId().setChiTietSanPham(chiTietSanPham);

                IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet(hoaDon, chiTietSanPham);
                hoaDonChiTiet.setId(idHoaDonChiTiet);
                hoaDonChiTiet.setSoLuong(item.getSoLuong());
                hoaDonChiTiet.setDonGia(item.getGiaBan());

                this.chiTietHoaDonService.insertHoaDonChiTiet(hoaDonChiTiet);
            }
        }
        listItem.clear();
        session.removeAttribute("cartItems");
        return "forward:/chi-tiet-san-pham/index";
    }

    @GetMapping("lich-su")
    public String lichSu(Model model) {
        model.addAttribute("danhSachHoaDon", hoaDonRepo.findAll());
        return "thanh_toan/lich_su";
    }

    @GetMapping("chi-tiet-don-hang/{id}")
    public String chiTietDonHang(Model model, @PathVariable("id") UUID id) {
        List<HoaDonChiTiet> danhSachChiTietHoaDon = chiTietHoaDonRepo.findByIdHoaDonId(id);
        model.addAttribute("lichSuMuaHang", danhSachChiTietHoaDon);
        return "thanh_toan/chi_tiet_hang";
    }


}
