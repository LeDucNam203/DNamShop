package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.NhanVienView;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Entity
@Table(name = "NhanVien")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class NhanVien {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    private String ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "MatKhau")
    private String matKhau;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCV")
    private ChucVu idCV;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "IdCH")
    private CuaHang idCH;
    @Column(name = "TrangThai")
    private String trangThai;

    public void loadFormViewModel(NhanVienView nhanVienView){
        this.setMa(nhanVienView.getMa());
        this.setTen(nhanVienView.getTen());
        this.setTenDem(nhanVienView.getTenDem());
        this.setHo(nhanVienView.getHo());
        this.setGioiTinh(nhanVienView.getGioiTinh());
        this.setNgaySinh(nhanVienView.getNgaySinh());
        this.setDiaChi(nhanVienView.getDiaChi());
        this.setSdt(nhanVienView.getSdt());
        this.setMatKhau(nhanVienView.getMatKhau());
        this.setIdCV(nhanVienView.getIdCV());
        this.setIdCH(nhanVienView.getIdCH());
        this.setTrangThai(nhanVienView.getTrangThai());
    }

}
