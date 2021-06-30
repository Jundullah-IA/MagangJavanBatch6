package com.tugas2.Organisasi.Services;

import com.tugas2.Organisasi.Models.Employee;
import com.tugas2.Organisasi.Repositories.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    JdbcTemplate jdbc;

    public List<Employee> listAll() { return employeeRepo.findAll(); }

    public List<Employee> listTampil() {
        List<Employee> listEmployee = jdbc.query(
                "SELECT e.id, e.nama, if(em.nama=e.nama, 'CEO', em.nama) as atasan, c.nama from employee e " +
                        "join employee em join company c on e.company_id = c.id " +
                        "where e.atasan_id = em.id or e.atasan_id is null group by e.id" ,
                (rs, rowNum) -> new Employee(rs.getInt("e.id"), rs.getString("e.nama"),
                        rs.getString("atasan"), rs.getString("c.nama")));
        return listEmployee;
    }

    public String exportReport(String reportFormat) throws FileNotFoundException, JRException {
        String path = "File/Report.pdf";
        List<Employee> employees = listTampil();
        //load file and compile it
        File file = ResourceUtils.getFile("classpath:templates/pdfReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("createdBy", "Jundullah IA");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        if (reportFormat.equalsIgnoreCase("excel")) {
            JRXlsxExporter toExcel = new JRXlsxExporter();
//            String printFileName = JasperFillManager.fillReportToFile(path, parameters, );
            toExcel.setExporterInput(new SimpleExporterInput(jasperPrint));
            toExcel.setExporterOutput(new SimpleOutputStreamExporterOutput("File/ReportExcel.xlsx"));
            toExcel.exportReport();

        }
        if (reportFormat.equalsIgnoreCase("pdf")) {
            JasperExportManager.exportReportToPdfFile(jasperPrint, path);
        }

        return "report generated in path : " + path;
    }

    public void save(Employee employee) { employeeRepo.save(employee); }

    public Employee get(Integer id) { return employeeRepo.findById(id).get(); }

    public void delete(Integer id) { employeeRepo.deleteById(id); }
}
