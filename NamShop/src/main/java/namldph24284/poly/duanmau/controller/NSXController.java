package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.NSX;
import namldph24284.poly.duanmau.entity.SanPham;
import namldph24284.poly.duanmau.repository.NSXRepository;
import namldph24284.poly.duanmau.request.NSXView;
import namldph24284.poly.duanmau.request.SanPhamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("nsx")
public class NSXController {
    @Autowired
    private NSX nsx;

    @Autowired
    private NSXRepository nsxRepo;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<NSX> nsxPage = this.nsxRepo.findAll(pageable);
        model.addAttribute("view", "/views/nsx/index.jsp");
        model.addAttribute("danhSachNSX", nsxPage);
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", this.nsx);
        model.addAttribute("view", "/views/nsx/edit.jsp");
        model.addAttribute("action", "/nsx/store");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") NSX nsx, Model model) {
        model.addAttribute("data", this.nsxRepo.findById(nsx.getId()));
        model.addAttribute("view", "/views/nsx/edit.jsp");
        model.addAttribute("action", "/nsx/update/" + nsx.getId());
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") NSX nsx, Model model) {
        this.nsxRepo.delete(nsx);
        return "redirect:/nsx/index";
    }

    @PostMapping("store")
    public String store(@Valid @ModelAttribute("data") NSXView nsxView, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/nsx/edit.jsp");
            return "layout";
        } else {
            NSX nsx = new NSX();
            nsx.loadFormViewModel(nsxView);
            this.nsxRepo.save(nsx);
            return "redirect:/nsx/index";
        }

    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") NSX oldValue,
                         @Valid @ModelAttribute("data") NSXView newValue,
                         Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/nsx/update/" + nsx.getId());
            model.addAttribute("view", "/views/nsx/edit.jsp");
            return "layout";
        } else {
            oldValue.loadFormViewModel(newValue);
            this.nsxRepo.save(oldValue);
            return "redirect:/san-pham/index";
        }
    }

}
