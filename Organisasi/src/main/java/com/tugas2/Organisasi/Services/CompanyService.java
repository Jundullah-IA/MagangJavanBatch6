package com.tugas2.Organisasi.Services;

import com.tugas2.Organisasi.Models.CompanyModel;
import com.tugas2.Organisasi.Repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CompanyService {
    @Autowired
    private CompanyRepository repo;

    public List<CompanyModel> listAll() {
        return repo.findAll();
    }

    public void save(CompanyModel company) {
        repo.save(company);
    }

    public CompanyModel get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
