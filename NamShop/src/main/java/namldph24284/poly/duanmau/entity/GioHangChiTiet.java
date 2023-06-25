package namldph24284.poly.duanmau.entity;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "GioHangChiTiet")
@AllArgsConstructor @NoArgsConstructor
@Data
public class GioHangChiTiet {
    @EmbeddedId
    private IdGioHangChiTiet id;
    private Integer soLuong;
    private double donGia;
    private double donGiaKhiGiam;

    @Override
    public String toString() {
        return "GioHangChiTiet{" +
                "Ma Gia Hang =" + id.getGioHang().getMa() +
                ",Ten San Pham Chi Tiet=" + id.getChiTietSanPham().getSanPham().getTen() +
                ", soLuong=" + soLuong +
                ", donGia=" + donGia +
                ", donGiaKhiGiam=" + donGiaKhiGiam +
                '}';
    }
}
