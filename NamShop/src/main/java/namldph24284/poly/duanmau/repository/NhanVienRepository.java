package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.KhachHang;
import namldph24284.poly.duanmau.entity.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien, UUID> {
    NhanVien findByMaAndMatKhau(String ma, String pass);
}
