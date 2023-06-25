package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.CuaHang;
import namldph24284.poly.duanmau.repository.CuaHangRepository;
import namldph24284.poly.duanmau.request.CuaHangView;
import namldph24284.poly.duanmau.service.CuaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cua-hang")
public class CuaHangController {
    @Autowired
    private CuaHangService cuaHangService;
    @Autowired
    private CuaHangRepository cuaHangRepo;

    @Autowired
    private CuaHang cuaHang;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo){
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<CuaHang> cuaHangPage = this.cuaHangRepo.findAll(pageable);
        model.addAttribute("danhSachCuaHang", cuaHangPage);
        model.addAttribute("view", "/views/cua_hang/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") CuaHang cuaHang){
        this.cuaHangService.delete(cuaHang.getId());
        return "redirect:/cua-hang/index";
    }

    @GetMapping("create")
    public String create(Model model){
        model.addAttribute("data", this.cuaHang);
        model.addAttribute("view", "/views/cua_hang/edit.jsp");
        model.addAttribute("action", "/cua-hang/store");
        return "layout";

    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") CuaHang cuaHang, Model model){
        model.addAttribute("data", this.cuaHangService.findById(cuaHang.getId()));
        model.addAttribute("view", "/views/cua_hang/edit.jsp");
        model.addAttribute("action", "/cua-hang/update/"+cuaHang.getId());
        return "layout";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") CuaHangView cuaHangView,
                        BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("view", "/views/cua_hang/edit.jsp");
            return "layout";
        }else {
            CuaHang cuaHang = new CuaHang();
            cuaHang.loadFormViewModel(cuaHangView);
            this.cuaHangService.save(cuaHang);
            return "redirect:/cua-hang/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") CuaHang oldValue,
                         @Valid @ModelAttribute("data") CuaHangView newValue,
                         Model model, BindingResult result
    ){
        if(result.hasErrors()){
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/cua-hang/update/"+ oldValue.getId());
            model.addAttribute("view", "/views/cua_hang/edit.jsp");
            return "layout";
        }else {
            oldValue.loadFormViewModel(newValue);
            this.cuaHangService.save(oldValue);
            return "redirect:/cua-hang/index";
        }
    }

}
