package namldph24284.poly.duanmau.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;

import java.io.Serializable;

@Embeddable
@Data
public class IdGioHangChiTiet implements Serializable {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdGioHang")
    private GioHang gioHang;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham chiTietSanPham;

}
