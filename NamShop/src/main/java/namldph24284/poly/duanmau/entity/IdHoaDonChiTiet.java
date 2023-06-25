package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class IdHoaDonChiTiet implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdHoaDon")
    private HoaDon hoaDon;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdChiTietSP")
    private ChiTietSanPham chiTietSanPham;

}
