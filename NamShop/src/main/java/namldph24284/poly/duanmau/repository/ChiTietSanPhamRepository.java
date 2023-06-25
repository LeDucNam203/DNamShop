package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChiTietSanPhamRepository extends JpaRepository<ChiTietSanPham, UUID> {
}
