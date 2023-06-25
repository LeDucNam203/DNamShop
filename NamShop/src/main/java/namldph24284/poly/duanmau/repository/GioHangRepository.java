package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    GioHang findByKhachHangId(UUID id);
    GioHang findByNhanVienId(UUID id);
}
