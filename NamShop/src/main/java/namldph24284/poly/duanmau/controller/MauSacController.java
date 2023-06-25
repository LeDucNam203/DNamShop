package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.MauSac;
import namldph24284.poly.duanmau.entity.NSX;
import namldph24284.poly.duanmau.repository.MauSacRepository;
import namldph24284.poly.duanmau.request.MauSacView;
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
@RequestMapping("mau-sac")
public class MauSacController {
    @Autowired
    private MauSacRepository mauSacRepo;

    @Autowired
    private MauSac mauSac;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<MauSac> mauSacPage = this.mauSacRepo.findAll(pageable);
        model.addAttribute("view", "/views/mau_sac/index.jsp");
        model.addAttribute("danhSachMauSac", mauSacPage);
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", this.mauSac);
        model.addAttribute("view", "/views/mau_sac/edit.jsp");
        model.addAttribute("action", "/mau-sac/store");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") MauSac mauSac, Model model) {
        model.addAttribute("data", this.mauSacRepo.findById(mauSac.getId()));
        model.addAttribute("view", "/views/mau_sac/edit.jsp");
        model.addAttribute("action", "/mau-sac/update/"+mauSac.getId());
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") MauSac mauSac) {
        this.mauSacRepo.delete(mauSac);
        return "redirect:/mau-sac/index";
    }

    @PostMapping("store")
    public String store(Model model,@Valid @ModelAttribute("data") MauSacView mauSacView, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/mau_sac/edit.jsp");
            return "layout";
        } else {
            MauSac mauSac = new MauSac();
            mauSac.loadFormViewModel(mauSacView);
            this.mauSacRepo.save(mauSac);
            return "redirect:/mau-sac/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") MauSac oldValue,
                         @Valid @ModelAttribute("data") MauSacView newValue,
                         Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/mau-sac/update/" + mauSac.getId());
            model.addAttribute("view", "/views/mau_sac/edit.jsp");
            return "layout";
        } else {
            oldValue.loadFormViewModel(newValue);
            this.mauSacRepo.save(oldValue);
            return "redirect:/san-pham/index";
        }
    }
}
