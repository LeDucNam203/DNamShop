package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.*;
@Entity
@AllArgsConstructor @NoArgsConstructor
@Data
public class HoaDonChiTiet {
    @EmbeddedId
    private IdHoaDonChiTiet id;
    private Integer soLuong;
    private double donGia;

    @Override
    public String toString() {
        return "HoaDonChiTiet{" +
                "Ma Hoa Don=" + id.getHoaDon().getMa() +
                ",Chi Tiet San Pham=" + id.getChiTietSanPham().getId() +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                '}';
    }
}
