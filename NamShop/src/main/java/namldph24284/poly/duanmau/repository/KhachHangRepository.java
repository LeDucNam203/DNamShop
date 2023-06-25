package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, UUID> {
    KhachHang findByMaAndMatKhau(String ma, String matKhau);

//    @Query("select hd from KhachHang hd where HoaDon.id= ?1")
//    Optional<KhachHang> findById(UUID id);
//    @Query(value = "select KhachHang.Ma, Ten, TenDem, Ho, NgaySinh, KhachHang.Sdt, KhachHang.DiaChi, ThanhPho, QuocGia from KhachHang inner join HoaDon on KhachHang.Id=HoaDon.IdKH where KhachHang.Ma = ?1", nativeQuery = true)
//    KhachHang findKhachHangByI(UUID id);
}
