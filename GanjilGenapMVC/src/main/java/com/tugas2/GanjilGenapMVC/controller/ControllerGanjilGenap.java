package com.tugas2.GanjilGenapMVC.controller;

import com.tugas2.GanjilGenapMVC.model.ModelBilangan;
import com.tugas2.GanjilGenapMVC.model.ModelAngka;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerGanjilGenap {
    @RequestMapping("/")
    public String index(Model model) {
        ModelBilangan bilangan = new ModelBilangan();

        model.addAttribute("bilangan", bilangan);
        return "index";
    }

    @RequestMapping(value = "/" , params = "excecute", method = RequestMethod.POST)
    public String excecute(@ModelAttribute("bilangan") ModelBilangan bilangan, Model model) {
        List<ModelAngka> angkaKeterangan = new ArrayList<>();

        for (int a = bilangan.getBatasAwal(); a <= bilangan.getBatasAkhir(); a++) {
            if (a % 2 == 0) {
                angkaKeterangan.add(new ModelAngka(a , "Bilangan genap"));
            } else {
                angkaKeterangan.add(new ModelAngka(a , "Bilangan ganjil"));
            }
        }

        model.addAttribute("containerAngka", angkaKeterangan);

        return "index";
    }
}
