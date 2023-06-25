package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.DongSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DongSPRepository extends JpaRepository<DongSP, UUID> {
}
