package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.DongSPView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class DongSP {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "dongSP", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listCTSP = new ArrayList<>();

    public void loadFormViewModel(DongSPView dongSPView){
        this.setMa(dongSPView.getMa());
        this.setTen(dongSPView.getTen());
    }
}
