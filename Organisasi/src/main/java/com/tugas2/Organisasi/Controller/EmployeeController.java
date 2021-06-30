package com.tugas2.Organisasi.Controller;

import com.tugas2.Organisasi.Models.Employee;
import com.tugas2.Organisasi.Services.EmployeeService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileNotFoundException;
import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService service;

    @RequestMapping("/employee")
    public String mainEmployee(Model model) {
        List<Employee> employees = service.listTampil();
        model.addAttribute("employees" , employees);

        return "employee_index";
    }

    @RequestMapping("/employee/new")
    public String viewNewPageEmployee(Model model){
        Employee company = new Employee();
        model.addAttribute("employee" , company);
        return "employee_new";
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Employee model){
        service.save(model);
        return ("redirect:/employee");
    }

    @RequestMapping("/employee/edit/{id}")
    public ModelAndView viewEditPageEmployee(@PathVariable(name = "id") Integer id){
        ModelAndView mav = new ModelAndView("employee_edit");
        Employee employee = service.get(id);
        mav.addObject("employee", employee);
        return mav;
    }

    @RequestMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id") Integer id){
        service.delete(id);
        return "redirect:/employee";
    }

    @GetMapping("/createReport")
    public String generateReport() throws FileNotFoundException, JRException {
        String massage = service.exportReport("excel");
        return "redirect:/employee";
    }
}
