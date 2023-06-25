package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.NhanVien;
import namldph24284.poly.duanmau.repository.NhanVienRepository;
import namldph24284.poly.duanmau.request.NhanVienView;
import namldph24284.poly.duanmau.service.ChucVuService;
import namldph24284.poly.duanmau.service.CuaHangService;
import namldph24284.poly.duanmau.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("nhan-vien")
public class NhanVienController {
    @Autowired
    private NhanVienService nhanVienService;
    @Autowired
    private NhanVienRepository nhanVienRepository;
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private ChucVuService chucVuService;

    @Autowired
    private NhanVien nhanVien;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<NhanVien> nhanVienPage = this.nhanVienRepository.findAll(pageable);
        model.addAttribute("view", "/views/nhan_vien/index.jsp");
        model.addAttribute("danhSachNhanVien", nhanVienPage);
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", this.nhanVien);
        model.addAttribute("danhSachCuaHang", this.cuaHangService.getAll());
        model.addAttribute("danhSachChucVu", this.chucVuService.getAll());
        model.addAttribute("view", "/views/nhan_vien/edit.jsp");
        model.addAttribute("action", "/nhan-vien/store");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") NhanVien nhanVien) {
        model.addAttribute("data", this.nhanVienService.findById(nhanVien.getId()));
        model.addAttribute("danhSachCuaHang", this.cuaHangService.getAll());
        model.addAttribute("danhSachChucVu", this.chucVuService.getAll());
        model.addAttribute("view", "/views/nhan_vien/edit.jsp");
        model.addAttribute("action", "/nhan-vien/update/" + nhanVien.getId());
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NhanVien nhanVien) {
        this.nhanVienService.delete(nhanVien.getId());
        return "redirect:/nhan-vien/index";
    }

    @PostMapping("store")
    public String store(Model model,@Valid @ModelAttribute("data") NhanVienView nhanVienView, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/nhan_vien/edit.jsp");
            return "layout";
        } else {
            NhanVien nhanVien = new NhanVien();
            nhanVien.loadFormViewModel(nhanVienView);
            this.nhanVienService.save(nhanVien);
            return "redirect:/nhan-vien/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") NhanVien oldValue,
                         @Valid @ModelAttribute("data") NhanVienView newValue,
                         Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/nhan-vien/update/" + oldValue.getId());
            model.addAttribute("view", "/views/nhan_vien/edit.jsp");
            return "layout";
        } else {
            oldValue.loadFormViewModel(newValue);
            this.nhanVienService.save(oldValue);
            return "redirect:/nhan-vien/index";
        }
    }
}
