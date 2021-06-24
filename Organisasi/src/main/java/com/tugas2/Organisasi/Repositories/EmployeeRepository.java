package com.tugas2.Organisasi.Repositories;

import com.tugas2.Organisasi.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee , Integer> {

}
