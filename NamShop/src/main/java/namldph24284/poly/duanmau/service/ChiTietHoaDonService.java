package namldph24284.poly.duanmau.service;

import namldph24284.poly.duanmau.entity.ChiTietSanPham;
import namldph24284.poly.duanmau.entity.HoaDonChiTiet;
import namldph24284.poly.duanmau.repository.ChiTietHoaDonRepository;
import namldph24284.poly.duanmau.repository.ChiTietSanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChiTietHoaDonService {
    @Autowired
    private ChiTietHoaDonRepository chiTietHoaDonRepo;

    public void insertHoaDonChiTiet(HoaDonChiTiet hoaDonChiTiet){
        HoaDonChiTiet chiTiet = new HoaDonChiTiet();
        chiTiet.setId(hoaDonChiTiet.getId());
        chiTiet.setSoLuong(hoaDonChiTiet.getSoLuong());
        chiTiet.setDonGia(hoaDonChiTiet.getDonGia());

        this.chiTietHoaDonRepo.save(chiTiet);
    }
}
