package namldph24284.poly.duanmau.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.entity.*;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ChiTietSanPhamView {
    @NotNull(message = "Vui long nhap san pham")
    private SanPham sanPham;
    @NotNull(message = "Vui long nhap nha san xuat")
    private NSX nsx;
    @NotNull(message = "Vui long chon mau sac")
    private MauSac mauSac;
    @NotNull(message = "Vui long nhap chon dong san pham")
    private DongSP dongSP;
    @NotNull(message = "Vui long nhap nam bao hanh")
    private int namBH;
    @NotBlank(message = "Vui long nhap mo ta")
    private String moTa;
    @NotNull(message = "Vui long nhap so luong ton")
    private int soLuongTon;
    @NotNull(message = "Vui long nhap gia nhap")
    private double giaNhap;
    @NotNull(message = "Vui long nhap gia ban")
    private double giaBan;

    public void loadFormDomainModel(ChiTietSanPham domain){
        this.setSanPham(domain.getSanPham());
        this.setNsx(domain.getNsx());
        this.setMauSac(domain.getMauSac());
        this.setDongSP(domain.getDongSP());
        this.setNamBH(domain.getNamBH());
        this.setMoTa(domain.getMoTa());
        this.setSoLuongTon(domain.getSoLuongTon());
        this.setGiaNhap(domain.getGiaNhap());
        this.setGiaBan(domain.getGiaBan());
    }

}
