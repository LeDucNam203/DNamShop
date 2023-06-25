package namldph24284.poly.duanmau.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.entity.ChiTietSanPham;
import namldph24284.poly.duanmau.entity.KhachHang;
import org.springframework.format.annotation.DateTimeFormat;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangView {
    @NotBlank(message = "Vui long nhap ma")
    private String ma;
    @NotBlank(message = "Vui long nhap ten")
    private String ten;
    @NotBlank(message = "Vui long nhap ten dem")
    private String tenDem;
    @NotBlank(message = "Vui long nhap ho")
    private String ho;
    @NotBlank(message = "Vui long nhap ngay sinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private String ngaySinh;
    @NotBlank(message = "Vui long nhap so dien thoai")
    private String sdt;
    @NotBlank(message = "Vui long nhap dia chi")
    private String diaChi;
    @NotNull(message = "Vui long chon thanh pho")
    private String thanhPho;
    @NotNull(message = "Vui long cho quoc gia")
    private String quocGia;
    @NotBlank(message = "Vui long nhap mat khau")
    private String matKhau;

    public void loadFormDomainModel(KhachHang domain){
        this.setMa(domain.getMa());
        this.setTen(domain.getTen());
        this.setTenDem(domain.getTenDem());
        this.setHo(domain.getHo());
        this.setNgaySinh(domain.getNgaySinh());
        this.setSdt(domain.getSdt());
        this.setDiaChi(domain.getDiaChi());
        this.setThanhPho(domain.getThanhPho());
        this.setQuocGia(domain.getQuocGia());
        this.setMatKhau(domain.getMatKhau());
    }
}
