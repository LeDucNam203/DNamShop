package namldph24284.poly.duanmau.controller;

import jakarta.servlet.http.HttpSession;
import namldph24284.poly.duanmau.entity.KhachHang;
import namldph24284.poly.duanmau.entity.NhanVien;
import namldph24284.poly.duanmau.repository.GioHangChiTietRepository;
import namldph24284.poly.duanmau.repository.GioHangRepository;
import namldph24284.poly.duanmau.repository.KhachHangRepository;
import namldph24284.poly.duanmau.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;
import java.util.UUID;

@Controller
public class LoginController {
    @Autowired
    private HttpSession session;

    @Autowired
    private NhanVienRepository nhanVienRepo;

    @Autowired
    private KhachHangRepository khachHangRepo;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepo;

    @GetMapping("view-login")
    public String viewLogin() {

        return "login";
    }

    @PostMapping("login")
    public String login(
            @RequestParam("ma") String ma,
            @RequestParam("matKhau") String matKhau,
            Model model
    ) {
        KhachHang kh = this.khachHangRepo.findByMaAndMatKhau(ma, matKhau);
        NhanVien nv = this.nhanVienRepo.findByMaAndMatKhau(ma, matKhau);
        if (nv != null) {
            session.setAttribute("userId", nv.getId());
            session.setAttribute("nguoiDung", "nhanvien");
            model.addAttribute("nguoi", nv);

            return "redirect:/phan-quyen";
        } else if (kh != null) {
            session.setAttribute("userId", kh.getId());
            session.setAttribute("nguoiDung", "khachhang");
            model.addAttribute("nguoi", kh);
            return "redirect:/phan-quyen";
        } else {
            return "redirect:/view-login";
        }
    }


    @GetMapping("phan-quyen")
    public String dashboard(HttpSession session, Model model) {
        UUID userId = (UUID) session.getAttribute("userId");
        String userType = (String) session.getAttribute("nguoiDung");

        if (userId == null && userType == null) {
            return "redirect:/view-login";
        } else {
            if (userType.equals("nhanvien")) {
                Optional<NhanVien> nv = this.nhanVienRepo.findById(userId);
                model.addAttribute("idUser", userId);
                nv.ifPresent(nhanVien -> session.setAttribute("nhanVien", nhanVien));
                return "forward:/nhan-vien/index";
            } else if (userType.equals("khachhang")) {
                Optional<KhachHang> kh = this.khachHangRepo.findById(userId);
                model.addAttribute("idUser", userId);
                kh.ifPresent(khachHang -> session.setAttribute("khachHang", khachHang));
                return "forward:/mua-hang";
            }
        }
        return "redirect:/view-login";
    }


//    @GetMapping("tuiDo/{id}")
//    public String tuiDo(Model model, @PathVariable("id") UUID id) {
//        model.addAttribute("danhSachGioHangChiTiet", this.gioHangChiTietRepo.findGioHang(id));
//        return "gio_hang/gio_hang";
//    }



}
