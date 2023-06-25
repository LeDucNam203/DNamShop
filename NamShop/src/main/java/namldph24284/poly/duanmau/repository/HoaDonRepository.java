package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.HoaDon;
import namldph24284.poly.duanmau.entity.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
//    HoaDon findById(UUID )

}
