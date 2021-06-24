package com.tugas2.Organisasi.Services;

import com.tugas2.Organisasi.Models.Employee;
import com.tugas2.Organisasi.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    public List<Employee> listAll() { return employeeRepo.findAll(); }

    public void save(Employee employee) { employeeRepo.save(employee); }

    public Employee get(Integer id) { return employeeRepo.findById(id).get(); }

    public void delete(Integer id) { employeeRepo.deleteById(id); }
}
