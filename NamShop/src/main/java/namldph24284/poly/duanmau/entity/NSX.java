package namldph24284.poly.duanmau.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.request.NSXView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NSX")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Component
public class NSX {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;

    @OneToMany(mappedBy = "nsx", fetch = FetchType.LAZY)
    private List<ChiTietSanPham> listCTSP = new ArrayList<>();

    public void loadFormViewModel(NSXView nsxView){
        this.setMa(nsxView.getMa());
        this.setTen(nsxView.getTen());
    }
}
