package namldph24284.poly.duanmau.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.entity.ChucVu;
import namldph24284.poly.duanmau.entity.SanPham;


@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChucVuView {
    @NotBlank(message = "Vui long nhap ma")
    private String ma;
    @NotBlank(message = "Vui long nhap ten")
    private String ten;

    public void loadFormDomainModel(ChucVu domain){
        this.setMa(domain.getMa());
        this.setTen(domain.getTen());
    }
}
