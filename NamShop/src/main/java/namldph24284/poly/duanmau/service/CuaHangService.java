package namldph24284.poly.duanmau.service;

import namldph24284.poly.duanmau.entity.CuaHang;
import namldph24284.poly.duanmau.repository.CuaHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CuaHangService {
    @Autowired
    private CuaHangRepository cuaHangRepo;

    public List<CuaHang> getAll(){
        return this.cuaHangRepo.findAll();
    }

    public Optional<CuaHang> findById(UUID id){
        return this.cuaHangRepo.findById(id);
    }

    public void delete(UUID id){
        this.cuaHangRepo.deleteById(id);
    }

    public CuaHang save(CuaHang cuaHang){
        return this.cuaHangRepo.save(cuaHang);
    }

}
