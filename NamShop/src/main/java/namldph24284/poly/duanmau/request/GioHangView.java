package namldph24284.poly.duanmau.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import namldph24284.poly.duanmau.entity.GioHang;
import namldph24284.poly.duanmau.entity.KhachHang;
import namldph24284.poly.duanmau.entity.NhanVien;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GioHangView {
    private UUID khachHang;
    private UUID nhanVien;
    private String ma;
    private String ngayTao;
    private String ngayThanhToan;
    private String tenNguoiNhan;
    private String diaChi;
    private String sdt;
    private String tinhTrang;


}
