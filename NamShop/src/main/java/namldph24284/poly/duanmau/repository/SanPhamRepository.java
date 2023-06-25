package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.SanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SanPhamRepository extends JpaRepository<SanPham, UUID> {
}
