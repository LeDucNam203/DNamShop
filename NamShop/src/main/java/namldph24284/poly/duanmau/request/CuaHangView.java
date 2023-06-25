package namldph24284.poly.duanmau.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.entity.CuaHang;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CuaHangView {
    @NotBlank(message = "Vui long nhap ma")
    private String ma;
    @NotBlank(message = "Vui long nhap ten")
    private String ten;
    @NotBlank(message = "Vui long nhap dia chi")
    private String diaChi;
    @NotNull(message = "Vui long chon thanh pho")
    private String thanhPho;
    @NotNull(message = "Vui long chon quoc gia")
    private String quocGia;

    public void loadFormDomainModel(CuaHang domain){
        this.setMa(domain.getMa());
        this.setTen(domain.getTen());
        this.setDiaChi(domain.getDiaChi());
        this.setThanhPho(domain.getThanhPho());
        this.setQuocGia(domain.getQuocGia());
    }
}
