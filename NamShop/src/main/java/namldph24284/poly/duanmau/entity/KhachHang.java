package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.KhachHangView;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Entity
@Table(name = "KhachHang")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class KhachHang {
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
    @Column(name = "NgaySinh")
    private String ngaySinh;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "ThanhPho")
    private String thanhPho;
    @Column(name = "QuocGia")
    private String quocGia;
    @Column(name = "MatKhau")
    private String matKhau;

    public void loadFormViewModel(KhachHangView khachHangView){
        this.setMa(khachHangView.getMa());
        this.setTen(khachHangView.getTen());
        this.setTenDem(khachHangView.getTenDem());
        this.setHo(khachHangView.getHo());
        this.setNgaySinh(khachHangView.getNgaySinh());
        this.setSdt(khachHangView.getSdt());
        this.setDiaChi(khachHangView.getDiaChi());
        this.setThanhPho(khachHangView.getThanhPho());
        this.setQuocGia(khachHangView.getQuocGia());
        this.setMatKhau(khachHangView.getMatKhau());
    }
}
