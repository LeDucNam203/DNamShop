package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.CuaHangView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "CuaHang")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class CuaHang {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "ThanhPho")
    private String thanhPho;
    @Column(name = "QuocGia")
    private String quocGia;

    @OneToMany(mappedBy = "idCH", fetch = FetchType.LAZY)
    private List<NhanVien> listNV = new ArrayList<>();

    public void loadFormViewModel(CuaHangView viewMD){
        this.setMa(viewMD.getMa());
        this.setTen(viewMD.getTen());
        this.setDiaChi(viewMD.getDiaChi());
        this.setThanhPho(viewMD.getThanhPho());
        this.setQuocGia(viewMD.getQuocGia());
    }
}
