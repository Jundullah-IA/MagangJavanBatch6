package com.tugas2.Organisasi.Repositories;

import com.tugas2.Organisasi.Models.CompanyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyModel, Long> {
}
