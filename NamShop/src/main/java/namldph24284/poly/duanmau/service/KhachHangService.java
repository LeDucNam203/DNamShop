package namldph24284.poly.duanmau.service;

import namldph24284.poly.duanmau.entity.KhachHang;
import namldph24284.poly.duanmau.repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepo;

    public List<KhachHang> getAll(){
        return this.khachHangRepo.findAll();
    }

    public Optional<KhachHang> findById(UUID id){
        return this.khachHangRepo.findById(id);
    }

    public void delete(UUID id){
        this.khachHangRepo.deleteById(id);
    }

    public KhachHang save(KhachHang khachHang){
        return this.khachHangRepo.save(khachHang);
    }


}
