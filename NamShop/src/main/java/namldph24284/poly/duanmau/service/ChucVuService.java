package namldph24284.poly.duanmau.service;

import namldph24284.poly.duanmau.entity.ChucVu;
import namldph24284.poly.duanmau.entity.KhachHang;
import namldph24284.poly.duanmau.repository.ChucVuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ChucVuService {
    @Autowired
    private ChucVuRepository chucVuRepo;

    public List<ChucVu> getAll(){
        return this.chucVuRepo.findAll();
    }

    public Optional<ChucVu> findById(UUID id){
        return this.chucVuRepo.findById(id);
    }

    public void delete(UUID id){
        this.chucVuRepo.deleteById(id);
    }

    public ChucVu save(ChucVu chucVu){
        return this.chucVuRepo.save(chucVu);
    }
}
