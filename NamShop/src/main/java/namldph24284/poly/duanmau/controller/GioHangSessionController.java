package namldph24284.poly.duanmau.controller;

import jakarta.servlet.http.HttpSession;
import namldph24284.poly.duanmau.entity.Cart;
import namldph24284.poly.duanmau.entity.ChiTietSanPham;
import namldph24284.poly.duanmau.entity.Item;
import namldph24284.poly.duanmau.repository.ChiTietSanPhamRepository;
import namldph24284.poly.duanmau.repository.GioHangChiTietRepository;
import namldph24284.poly.duanmau.repository.GioHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("gio-hang")
public class GioHangSessionController {
    @Autowired
    private HttpSession httpSession;

    @Autowired
    private ChiTietSanPhamRepository chiTietSanPhamRepo;

    @Autowired
    private GioHangChiTietRepository gioHangChiTietRepo;

    @GetMapping("store/{id}")
    public String addToCart(@PathVariable("id") UUID id, Model model) {
        Optional<ChiTietSanPham> chiTietSanPham = this.chiTietSanPhamRepo.findById(id);
        Item item = new Item(chiTietSanPham.get().getId(),
                chiTietSanPham.get().getDongSP().getTen(),
                chiTietSanPham.get().getSanPham().getTen(),
                chiTietSanPham.get().getNsx().getTen(),
                chiTietSanPham.get().getMauSac().getTen(),
                1,
                chiTietSanPham.get().getGiaBan());

        Cart cartSession = (Cart) httpSession.getAttribute("cart");
        if (cartSession == null) {
            Cart cart = new Cart();
            ArrayList<Item> list = new ArrayList<>();
            list.add(item);
            cart.setListItem(list);
            httpSession.setAttribute("cart", cart);
        } else {
            Cart cart = (Cart) httpSession.getAttribute("cart");
            ArrayList<Item> listItem = cart.getListItem();

            boolean itemExists = false;
            for (Item itemTmp : listItem) {
                if (itemTmp.getId().equals(id)) {
                    itemTmp.setSoLuong(itemTmp.getSoLuong() + 1);
                    itemExists = true;
                    break;
                }
            }

            if (!itemExists) {
                listItem.add(item);
            }

            // Cập nhật giỏ hàng trong session
            httpSession.setAttribute("cart", cart);
        }
        return "forward:/chi-tiet-san-pham/index";
    }

    @GetMapping("viewCart")
    public String viewCart(Model model) {
        Cart cart = (Cart) httpSession.getAttribute("cart");
        System.out.println(cart.toString());
        ArrayList<Item> list = cart.getListItem();
        model.addAttribute("gioHangChiTiet", list);
        model.addAttribute("view", "/views/gio_hang/GioHangView.jsp");
        return "layout";
    }

    @GetMapping("deleteCart/{id}")
    public String deleteCart(@PathVariable("id") UUID id, HttpSession session) {
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null) {
            ArrayList<Item> list = cart.getListItem();
            for (Item item : list) {
                if (item.getId().equals(id)) {
                    list.remove(item);
                    break;
                }
            }
        }
        return "redirect:/gio-hang/viewCart";
    }



}
