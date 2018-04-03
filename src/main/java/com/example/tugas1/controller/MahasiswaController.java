package com.example.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tugas1.model.MahasiswaModel;
import com.example.tugas1.service.MahasiswaService;
import com.example.tugas1.service.MahasiswaServiceDatabase;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class MahasiswaController {
	
	@Autowired
	MahasiswaService mahasiswaDAO;
    
	@RequestMapping("/")
    public String index(Model model)
    {
		
		log.info("masukkkkk");
		return "index";
    }
	
	
	@RequestMapping("/mahasiswa/view")
	public String view (Model model, @RequestParam(value="npm", required=false) String npm)
	{
		MahasiswaModel mahasiswa = mahasiswaDAO.selectMahasiswa(npm);
		log.info("masuk");
		if (mahasiswa != null){
			
			model.addAttribute("mahasiswa", mahasiswa);
			return "view";	
		}else{
			model.addAttribute("npm",npm);
			return "not-found";
		}
	}
	
//	@RequestMapping("/student/viewall")
//    public String view (Model model)
//    {
//        List<MahasiswaModel> students = mahasiswaDAO.selectAllMahasiswa();
//        model.addAttribute ("students", students);
//
//        return "viewall";
//    }

}
