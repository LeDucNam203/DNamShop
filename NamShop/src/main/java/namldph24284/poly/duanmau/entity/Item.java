package namldph24284.poly.duanmau.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Data
public class Item {
    private UUID id;
    private String tenSanPham;
    private String tenDongSP;
    private String tenNhaSanXuat;
    private String tenMauSac;
    private Integer soLuong;
    private double giaBan;

    public Item(UUID id, String tenSanPham, String tenDongSP, String tenNhaSanXuat, String tenMauSac, Integer soLuong, double giaBan) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.tenDongSP = tenDongSP;
        this.tenNhaSanXuat = tenNhaSanXuat;
        this.tenMauSac = tenMauSac;
        this.soLuong = soLuong;
        this.giaBan = giaBan;
    }

    public Item() {
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", tenDongSP='" + tenDongSP + '\'' +
                ", tenNhaSanXuat='" + tenNhaSanXuat + '\'' +
                ", tenMauSac='" + tenMauSac + '\'' +
                ", soLuong=" + soLuong +
                ", giaBan=" + giaBan +
                '}';
    }
}
