package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.ChiTietSanPhamView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class ChiTietSanPham {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdSP")
    private SanPham sanPham;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNsx")
    private NSX nsx;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;
    @Column(name = "NamBH")
    private int namBH;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private int soLuongTon;
    @Column(name = "GiaNhap")
    private double giaNhap;
    @Column(name = "GiaBan")
    private double giaBan;

    @OneToMany(mappedBy = "id.chiTietSanPham", fetch = FetchType.LAZY)
    List<GioHangChiTiet> listGH = new ArrayList<>();

    public void loadFormViewModel(ChiTietSanPhamView chiTietSanPhamView){
        this.setSanPham(chiTietSanPhamView.getSanPham());
        this.setNsx(chiTietSanPhamView.getNsx());
        this.setMauSac(chiTietSanPhamView.getMauSac());
        this.setDongSP(chiTietSanPhamView.getDongSP());
        this.setNamBH(chiTietSanPhamView.getNamBH());
        this.setMoTa(chiTietSanPhamView.getMoTa());
        this.setSoLuongTon(chiTietSanPhamView.getSoLuongTon());
        this.setGiaNhap(chiTietSanPhamView.getGiaNhap());
        this.setGiaBan(chiTietSanPhamView.getGiaBan());
    }


}
