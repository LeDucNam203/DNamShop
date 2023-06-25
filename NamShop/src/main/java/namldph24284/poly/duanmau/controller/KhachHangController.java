package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.KhachHang;
import namldph24284.poly.duanmau.repository.KhachHangRepository;
import namldph24284.poly.duanmau.request.KhachHangView;
import namldph24284.poly.duanmau.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;
    @Autowired
    private KhachHangRepository khachHangRepo;

    @Autowired
    private KhachHang khach;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<KhachHang> khachHangPage = this.khachHangRepo.findAll(pageable);
        model.addAttribute("view", "/views/khach_hang/index.jsp");
        model.addAttribute("danhSachKhachHang", khachHangPage);
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") KhachHang khachHang) {
        this.khachHangService.delete(khachHang.getId());
        return "redirect:/khach-hang/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", khach);
        model.addAttribute("view", "/views/khach_hang/edit.jsp");
        model.addAttribute("action", "/khach-hang/store");
        return "layout";
    }

    @PostMapping("store")
    public String store(Model model,@Valid @ModelAttribute("data") KhachHangView khachHangView, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/khach_hang/edit.jsp");
            return "layout";
        } else {
            KhachHang khachHang = new KhachHang();
            khachHang.loadFormViewModel(khachHangView);
            this.khachHangService.save(khachHang);
            return "redirect:/khach-hang/index";
        }
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") KhachHang khachHang) {
        model.addAttribute("data", this.khachHangService.findById(khachHang.getId()));
        model.addAttribute("view", "/views/khach_hang/edit.jsp");
        model.addAttribute("action", "/khach-hang/update/" + khachHang.getId());

        return "layout";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") KhachHang oldValue,
                         @Valid @ModelAttribute("data") KhachHangView newValue,
                         Model model, BindingResult result
    ){
        if(result.hasErrors()){
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/khach-hang/update/" + khach.getId());
            model.addAttribute("view", "/views/khach_hang/edit.jsp");
            return "layout";
        }else {
            oldValue.loadFormViewModel(newValue);
            this.khachHangService.save(oldValue);
            return "redirect:/khach-hang/index";
        }
    }
}
