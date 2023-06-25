package namldph24284.poly.duanmau.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.entity.SanPham;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SanPhamView {
    @NotBlank(message = "Vui long nhap ma")
    private String ma;
    @NotBlank(message = "Vui long nhap ten")
    private String ten;

    public void loadFormDomainModel(SanPham domain){
        this.setMa(domain.getMa());
        this.setTen(domain.getTen());
    }

}
