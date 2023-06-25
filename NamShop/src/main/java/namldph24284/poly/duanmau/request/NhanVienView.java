package namldph24284.poly.duanmau.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.entity.ChucVu;
import namldph24284.poly.duanmau.entity.CuaHang;
import namldph24284.poly.duanmau.entity.NhanVien;

@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NhanVienView {
    @NotBlank(message = "Vui long nhap ma")
    private String ma;
    @NotBlank(message = "Vui long nhap ten")
    private String ten;
    @NotBlank(message = "Vui long nhap ten dem")
    private String tenDem;
    @NotBlank(message = "Vui long nhap ho")
    private String ho;
    @NotBlank(message = "Vui long nhap gioi tinh")
    private String gioiTinh;
    @NotBlank(message = "Vui long nhap ngay sinh")
    private String ngaySinh;
    @NotBlank(message = "Vui long nhap dia chi")
    private String diaChi;
    @NotBlank(message = "Vui long nhap so dien thoai")
    private String sdt;
    @NotBlank(message = "Vui long nhap mat khau")
    private String matKhau;
    @NotNull(message = "Vui long chon chuc vu")
    private ChucVu idCV;
    @NotNull(message = "Vui long chon cua hang")
    private CuaHang idCH;
    @NotBlank(message = "Vui long nhap trang thai")
    private String trangThai;

    public void loadFormNhanVien(NhanVien domain){
        this.setMa(domain.getMa());
        this.setTen(domain.getTen());
        this.setTenDem(domain.getTenDem());
        this.setHo(domain.getHo());
        this.setGioiTinh(domain.getGioiTinh());
        this.setNgaySinh(domain.getNgaySinh());
        this.setDiaChi(domain.getDiaChi());
        this.setSdt(domain.getSdt());
        this.setMatKhau(domain.getMatKhau());
        this.setIdCH(domain.getIdCH());
        this.setIdCH(domain.getIdCH());
        this.setTrangThai(domain.getTrangThai());
    }

}
