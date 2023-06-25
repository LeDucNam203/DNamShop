package namldph24284.poly.duanmau.controller;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.ChiTietSanPham;
import namldph24284.poly.duanmau.entity.MauSac;
import namldph24284.poly.duanmau.repository.*;
import namldph24284.poly.duanmau.request.ChiTietSanPhamView;
import namldph24284.poly.duanmau.request.MauSacView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("chi-tiet-san-pham")
public class ChiTietSanPhamController {
    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepo;
    @Autowired
    private SanPhamRepository sanPhamRepo;
    @Autowired
    private NSXRepository nsxRepo;
    @Autowired
    private MauSacRepository mauSacRepo;
    @Autowired
    private DongSPRepository dongSPRepo;

    @Autowired
    private ChiTietSanPham chiTietSanPham;
    @Autowired
    private HttpSession session;

    @GetMapping("index")
    public String index( Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<ChiTietSanPham> chiTietSanPhamPage = this.chiTietSanPhamRepo.findAll(pageable);
        model.addAttribute("danhSachChiTietSP", chiTietSanPhamPage);
        UUID userId = (UUID) session.getAttribute("userId");
        model.addAttribute("view", "/views/chi_tiet_sp/index.jsp");
//        return "chi_tiet_sp/index";
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", this.chiTietSanPham);
        model.addAttribute("listSanPham", this.sanPhamRepo.findAll());
        model.addAttribute("listNsx", this.nsxRepo.findAll());
        model.addAttribute("listMauSac", this.mauSacRepo.findAll());
        model.addAttribute("listDongSP", this.dongSPRepo.findAll());
        model.addAttribute("view", "/views/chi_tiet_sp/edit.jsp");
        model.addAttribute("action", "/chi-tiet-san-pham/store");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") ChiTietSanPham chiTietSanPham){
        model.addAttribute("data", this.chiTietSanPhamRepo.findById(chiTietSanPham.getId()));
        model.addAttribute("listSanPham", this.sanPhamRepo.findAll());
        model.addAttribute("listNsx", this.nsxRepo.findAll());
        model.addAttribute("listMauSac", this.mauSacRepo.findAll());
        model.addAttribute("listDongSP", this.dongSPRepo.findAll());
        model.addAttribute("view", "/views/chi_tiet_sp/edit.jsp");
        model.addAttribute("action", "/chi-tiet-san-pham/update/"+chiTietSanPham.getId());

        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChiTietSanPham chiTietSanPham){
        this.chiTietSanPhamRepo.deleteById(chiTietSanPham.getId());
        return "redirect:/chi-tiet-san-pham/index";
    }

    @PostMapping("store")
    public String store(Model model,@Valid @ModelAttribute("data") ChiTietSanPhamView chiTietSanPhamView, BindingResult result){
        if(result.hasErrors()){
            model.addAttribute("listSanPham", this.sanPhamRepo.findAll());
            model.addAttribute("listNsx", this.nsxRepo.findAll());
            model.addAttribute("listMauSac", this.mauSacRepo.findAll());
            model.addAttribute("listDongSP", this.dongSPRepo.findAll());
            model.addAttribute("view", "/views/chi_tiet_sp/edit.jsp");
            return "layout";
        }else {
            ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
            chiTietSanPham.loadFormViewModel(chiTietSanPhamView);
            this.chiTietSanPhamRepo.save(chiTietSanPham);
            return "redirect:/chi-tiet-san-pham/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ChiTietSanPham oldValue,
                         @Valid @ModelAttribute("data") ChiTietSanPhamView newValue,
                         Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("listSanPham", this.sanPhamRepo.findAll());
            model.addAttribute("listNsx", this.nsxRepo.findAll());
            model.addAttribute("listMauSac", this.mauSacRepo.findAll());
            model.addAttribute("listDongSP", this.dongSPRepo.findAll());
            model.addAttribute("action", "/chi-tiet-san-pham/update/" + chiTietSanPham.getId());
            model.addAttribute("view", "/views/chi_tiet_sp/edit.jsp");
            return "layout";
        } else {
            oldValue.loadFormViewModel(newValue);
            this.chiTietSanPhamRepo.save(oldValue);
            return "redirect:/chi-tiet-san-pham/index";
        }
    }


}
