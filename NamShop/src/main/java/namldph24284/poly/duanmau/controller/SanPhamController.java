package namldph24284.poly.duanmau.controller;

import jakarta.validation.Valid;
import namldph24284.poly.duanmau.entity.MauSac;
import namldph24284.poly.duanmau.entity.SanPham;
import namldph24284.poly.duanmau.repository.MauSacRepository;
import namldph24284.poly.duanmau.repository.SanPhamRepository;
import namldph24284.poly.duanmau.request.SanPhamView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("san-pham")
public class SanPhamController {
    @Autowired
    private SanPhamRepository sanPhamRepo;

    @Autowired
    private SanPham sanPham;

    @GetMapping("index")
    public String index(Model model, @RequestParam(name = "page", defaultValue = "0") Integer pageNo,
                        @RequestParam(name = "sortField", defaultValue = "ten") String sortField,
                        @RequestParam(name = "sortDir", defaultValue = "asc") String sortDir) {
        int pageSize = 3; // Số lượng mục trên mỗi trang
        int startIndex = pageNo * pageSize + 1; // Số thứ tự bắt đầu

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        Page<SanPham> page = this.sanPhamRepo.findAll(pageable);
        List<SanPham> listSP = page.getContent();

        model.addAttribute("currentPage", pageNo + 1); // Add 1 to pageNo to display the correct current page number
        model.addAttribute("startIndex", startIndex);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
        model.addAttribute("view", "/views/san_pham/index.jsp");
        model.addAttribute("danhSachSanPham", listSP);
        return "layout";
    }

    @GetMapping("create")
    public String create(Model model) {
        model.addAttribute("data", this.sanPham);
        model.addAttribute("view", "/views/san_pham/edit.jsp");
        model.addAttribute("action", "/san-pham/store");
        return "layout";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") SanPham sanPham, Model model) {
        model.addAttribute("data", this.sanPhamRepo.findById(sanPham.getId()));
        model.addAttribute("action", "/san-pham/update/" + sanPham.getId());
        model.addAttribute("view", "/views/san_pham/edit.jsp");
        return "layout";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") SanPham sanPham) {
        this.sanPhamRepo.delete(sanPham);
        return "redirect:/san-pham/index";
    }

    @PostMapping("store")
    public String store(Model model,@Valid @ModelAttribute("data") SanPhamView sanPhamView, BindingResult result) {
        if (result.hasErrors()) {
            model.addAttribute("view", "/views/san_pham/edit.jsp");
            return "layout";
        } else {
            SanPham sanPham = new SanPham();
            sanPham.loadFormViewModel(sanPhamView);
            this.sanPhamRepo.save(sanPham);
            return "redirect:/san-pham/index";
        }
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable("id") SanPham oldValue,
                         @Valid @ModelAttribute("data") SanPhamView newValue,
                         Model model, BindingResult result
    ) {
        if (result.hasErrors()) {
            model.addAttribute("data", newValue);
            model.addAttribute("action", "/san-pham/update/" + sanPham.getId());
            model.addAttribute("view", "/views/san_pham/edit.jsp");
            return "layout";
        } else {
            oldValue.loadFormViewModel(newValue);
            this.sanPhamRepo.save(oldValue);
            return "redirect:/san-pham/index";
        }
    }
}
