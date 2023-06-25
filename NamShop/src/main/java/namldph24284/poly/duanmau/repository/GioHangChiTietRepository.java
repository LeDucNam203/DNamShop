package namldph24284.poly.duanmau.repository;

import namldph24284.poly.duanmau.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, IdGioHangChiTiet> {
//    List<GioHangChiTiet> findByIdGioHangKhachHangIdEqual(UUID khachHangId);
    @Query(value = "select IdGioHang, IdChiTietSP, SoLuong, DonGia, DonGiaKhiGiam from GioHangChiTiet inner join GioHang on GioHangChiTiet.IdGioHang=GioHang.Id inner join ChiTietSP on GioHangChiTiet.IdChiTietSP=ChiTietSP.Id where IdNV = ?1", nativeQuery = true)
    List<GioHangChiTiet> findGioHang(UUID id);



}
