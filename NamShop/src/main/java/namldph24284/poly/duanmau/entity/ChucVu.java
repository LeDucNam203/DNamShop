package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.ChucVuView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ChucVu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "Id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "idCV", fetch = FetchType.LAZY)
    private List<NhanVien> listNV = new ArrayList<>();

    public void loadFormViewModel(ChucVuView chucVuView){
        this.setMa(chucVuView.getMa());
        this.setTen(chucVuView.getTen());
    }

}
