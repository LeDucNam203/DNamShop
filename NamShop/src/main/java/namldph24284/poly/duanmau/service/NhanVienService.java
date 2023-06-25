package namldph24284.poly.duanmau.service;

import namldph24284.poly.duanmau.entity.NhanVien;
import namldph24284.poly.duanmau.repository.NhanVienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NhanVienService {
    @Autowired
    private NhanVienRepository nhanVienRepo;

    public List<NhanVien> getAll(){
        return this.nhanVienRepo.findAll();
    }

    public Optional<NhanVien> findById(UUID id){
        return this.nhanVienRepo.findById(id);
    }

    public NhanVien save(NhanVien nhanVien){
        return this.nhanVienRepo.save(nhanVien);
    }

    public void delete(UUID id){
         this.nhanVienRepo.deleteById(id);
    }

}
