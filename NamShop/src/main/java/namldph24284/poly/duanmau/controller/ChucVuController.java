package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.ChucVu;
import namldph24284.poly.duanmau.entity.NSX;
import namldph24284.poly.duanmau.repository.ChucVuRepository;
import namldph24284.poly.duanmau.request.ChucVuView;
import namldph24284.poly.duanmau.request.NSXView;
import namldph24284.poly.duanmau.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("chuc-vu")
public class ChucVuController {
    @Autowired
    private ChucVuService chucVuService;
    @Autowired
    private ChucVuRepository chucVuRepo;

    @Autowired
    private ChucVu chucVu;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<ChucVu> chucVuPage = this.chucVuRepo.findAll(pageable);
        model.addAttribute("danhSachChucVu", chucVuPage);
        model.addAttribute("view", "/views/chuc_vu/index.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") ChucVu chucVu) {
        this.chucVuService.delete(chucVu.getId());
        return "redirect:/chuc-vu/index";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", chucVu);
        model.addAttribute("view", "/views/chuc_vu/edit.jsp");
        model.addAttribute("action", "/chuc-vu/store");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") ChucVu chucVu, Model model) {
        model.addAttribute("data", this.chucVuService.findById(chucVu.getId()));
        model.addAttribute("view", "/views/chuc_vu/edit.jsp");
        model.addAttribute("action", "/chuc-vu/update/" + chucVu.getId());
        return "layout";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") ChucVuView chucVuView,
                        BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/chuc_vu/edit.jsp");
            return "layout";
        } else {
            ChucVu chucVu = new ChucVu();
            chucVu.loadFormViewModel(chucVuView);
            this.chucVuService.save(chucVu);
            return "redirect:/chuc-vu/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") ChucVu oldValue,
                         @Valid @ModelAttribute("data") ChucVuView newValue,
                         Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/chuc-vu/update/" + chucVu.getId());
            model.addAttribute("view", "/views/chuc_vu/edit.jsp");
            return "layout";
        } else {
            oldValue.loadFormViewModel(newValue);
            this.chucVuService.save(oldValue);
            return "redirect:/san-pham/index";
        }
    }


}
