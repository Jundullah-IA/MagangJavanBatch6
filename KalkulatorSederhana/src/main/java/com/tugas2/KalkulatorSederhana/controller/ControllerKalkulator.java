package com.tugas2.KalkulatorSederhana.controller;

import com.tugas2.KalkulatorSederhana.model.ModelKalkulator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ControllerKalkulator {


    @RequestMapping("/")
    public String kalkulator(Model model) {
        ModelKalkulator calc = new ModelKalkulator();

        model.addAttribute("calc", calc);
        return "index";
    }

    @RequestMapping(value = "/", params = "submit", method = RequestMethod.GET)
    public String tambah(@ModelAttribute("calc") ModelKalkulator calc, Model model){
        String hasilOperasi = "Hasil operasi : ";

        switch (calc.getOperator()) {
            case "tambah" : hasilOperasi += (calc.getAngka1() + calc.getAngka2());  break;
            case "kurang" : hasilOperasi += (calc.getAngka1() - calc.getAngka2());  break;
            case "kali" : hasilOperasi += (calc.getAngka1() * calc.getAngka2());  break;
            case "bagi" : {
                if (calc.getAngka2() != 0) {
                    hasilOperasi += (calc.getAngka1() / calc.getAngka2());
                } else {
                    hasilOperasi = "Operasi tidak dapat dijalankan.";
                }
            }  break;
        }

        model.addAttribute("hasil", hasilOperasi);
        return "index";
    }
}
