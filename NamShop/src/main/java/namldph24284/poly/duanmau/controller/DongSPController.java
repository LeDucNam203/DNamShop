package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.DongSP;
import namldph24284.poly.duanmau.entity.NSX;
import namldph24284.poly.duanmau.repository.DongSPRepository;
import namldph24284.poly.duanmau.request.DongSPView;
import namldph24284.poly.duanmau.request.NSXView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("dongSP")
public class DongSPController {
    @Autowired
    private DongSPRepository dongSPRepo;

    @Autowired
    private DongSP dongSP;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<DongSP> dongSPPage = this.dongSPRepo.findAll(pageable);
        model.addAttribute("view", "/views/dong_sp/index.jsp");
        model.addAttribute("danhSachDongSP", dongSPPage);
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", this.dongSP);
        model.addAttribute("view", "/views/dong_sp/edit.jsp");
        model.addAttribute("action", "/dongSP/store");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(Model model, @PathVariable("id") DongSP dongSP) {
        model.addAttribute("data", this.dongSPRepo.findById(dongSP.getId()));
        model.addAttribute("view", "/views/dong_sp/edit.jsp");
        model.addAttribute("action", "/dongSP/update/" + dongSP.getId());
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") DongSP dongSP) {
        this.dongSPRepo.delete(dongSP);
        return "dong_sp/edit";
    }

    @PostMapping("store")
    public String store(Model model,@Valid @ModelAttribute("data") DongSPView dongSPView, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/dong_sp/edit.jsp");
            return "layout";
        } else {
            DongSP dongSP = new DongSP();
            dongSP.loadFormViewModel(dongSPView);
            this.dongSPRepo.save(dongSP);
            return "redirect:/dongSP/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") DongSP oldValue,
                         @Valid @ModelAttribute("data") DongSPView newValue,
                         Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/dongSP/update/" + dongSP.getId());
            model.addAttribute("view", "/views/dong_sp/edit.jsp");
            return "layout";
        } else {
            oldValue.loadFormViewModel(newValue);
            this.dongSPRepo.save(oldValue);
            return "redirect:/san-pham/index";
        }
    }

}
