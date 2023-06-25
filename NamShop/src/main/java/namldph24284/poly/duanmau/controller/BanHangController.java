package namldph24284.poly.duanmau.controller;

import jakarta.servlet.http.HttpSession;
import namldph24284.poly.duanmau.entity.*;
import namldph24284.poly.duanmau.repository.ChiTietHoaDonRepository;
import namldph24284.poly.duanmau.repository.HoaDonRepository;
import namldph24284.poly.duanmau.service.ChiTietHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class BanHangController {
    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepo;

    @Autowired
    private ChiTietHoaDonService chiTietHoaDonService;

    @Autowired
    private NhanVien nhanVien;

//    @GetMapping("saveItem")
//    public String saveItem(HttpSession session){
//        List<Item> items = (List<Item>) session.getAttribute("cart");
//        if(items != null){
//            for(Item item : items){
//                HoaDonChiTiet hoaDonChiTiet = new HoaDonChiTiet();
//
////                HoaDon hoaDon = chiTietHoaDonRepo.findById(item)
//
////                IdHoaDonChiTiet idHoaDonChiTiet = new IdHoaDonChiTiet();
////                idHoaDonChiTiet.setHoaDon(item);
//
//                this.chiTietHoaDonService.insertHoaDonChiTiet(hoaDonChiTiet);
//            }
//        }
//        session.removeAttribute("cartItems");
//        return "thanh_toan/hoa_don";
//    }
}
