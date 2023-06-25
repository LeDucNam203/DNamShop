package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.HoaDonChiTiet;
import namldph24284.poly.duanmau.entity.IdHoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChiTietHoaDonRepository extends JpaRepository<HoaDonChiTiet, IdHoaDonChiTiet> {

    List<HoaDonChiTiet> findByIdHoaDonId(UUID hoaDonId);
}
