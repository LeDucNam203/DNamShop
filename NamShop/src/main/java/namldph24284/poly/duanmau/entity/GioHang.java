package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.GioHangView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "GioHang")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdKH")
    private KhachHang khachHang;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdNV")
    private NhanVien nhanVien;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private String ngayTao;
    @Column(name = "NgayThanhToan")
    private String ngayThanhToan;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "TinhTrang")
    private String tinhTrang;

    @OneToMany(mappedBy = "id.gioHang", fetch = FetchType.LAZY)
    List<GioHangChiTiet> listGH = new ArrayList<>();

    public void loadFormViewModel(GioHangView gioHangView){
        this.setMa(gioHangView.getMa());
        this.setNgayTao(gioHangView.getNgayTao());
        this.setNgayThanhToan(gioHangView.getNgayThanhToan());
        this.setTenNguoiNhan(gioHangView.getTenNguoiNhan());
        this.setDiaChi(gioHangView.getDiaChi());
        this.setDiaChi(gioHangView.getDiaChi());
        this.setTinhTrang(gioHangView.getTinhTrang());
    }

}
