package com.tugas2.Organisasi.Controller;

import com.tugas2.Organisasi.Models.CompanyModel;
import com.tugas2.Organisasi.Services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<CompanyModel> listProducts = companyService.listAll();
        model.addAttribute("listCompany", listProducts);

        return "index";
    }

    @RequestMapping(value = "/saveCompany", method = RequestMethod.POST)
    public String saveCompany(@ModelAttribute("company") CompanyModel model){
        companyService.save(model);
        return ("redirect:/");
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView viewEditPageEmployee(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("company_edit");
        CompanyModel comp = companyService.get(id);
        mav.addObject("comp", comp);
        return mav;
    }
}
