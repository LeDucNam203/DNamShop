package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class HoaDon {
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
    private Date ngayTao;
    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;
    @Column(name = "NgayShip")
    private Date ngayShip;
    @Column(name = "NgayNhan")
    private Date ngayNhan;
    @Column(name = "TinhTrang")
    private int tinhTrang;
    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;

    @OneToMany(mappedBy = "id.hoaDon", fetch = FetchType.LAZY)
    private List<HoaDonChiTiet> listHD = new ArrayList<>();

}
