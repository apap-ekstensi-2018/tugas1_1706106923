package com.example.tugas1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tugas1.model.FakultasModel;
import com.example.tugas1.model.MahasiswaModel;
import com.example.tugas1.model.ProgramStudiModel;
import com.example.tugas1.model.UniversitasModel;
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
	@RequestMapping("mahasiswa/tambah")
    public String add (Model model)
    {	
		model.addAttribute ("mahasiswa", new MahasiswaModel());
        return "add-mahasiswa";
    }
	
	@RequestMapping("/mahasiswa/tambah/submit")
    public String addSubmit (@RequestParam(value = "npm", required = false) String npm,
            @RequestParam(value = "nama", required = false) String nama,
            @RequestParam(value = "tempat_lahir", required = false) String tempat_lahir,
            @RequestParam(value = "tanggal_lahir", required = false) String tanggal_lahir,
            @RequestParam(value = "jenis_kelamin", required = false) int jenis_kelamin,
            @RequestParam(value = "agama", required = false) String agama,
            @RequestParam(value = "golongan_darah", required = false) String golongan_darah,
            @RequestParam(value = "status", required = false) String status,
            @RequestParam(value = "tahun_masuk", required = false) String tahun_masuk,
            @RequestParam(value = "jalur_masuk", required = false) String jalur_masuk,
            @RequestParam(value = "id_prodi", required = false) int id_prodi,
            @RequestParam(value = "fakultas", required = false) FakultasModel fakultas,
            @RequestParam(value = "univ", required = false) UniversitasModel univ,
            @RequestParam(value = "prodi", required = false) ProgramStudiModel prodi, Model model)
    {
		String generateNPM;
		MahasiswaModel mhs = mahasiswaDAO.selectMahasiswaByNpm(npm);
		String generate;
		if (mhs == null) {
			generate = "01";
		} else {
			int getNpmO= 1+ Integer.parseInt(mhs.getNpm().substring(9));
			generate ="" + getNpmO;

		}
		generateNPM = tahun_masuk.substring(2) + 01 + 02 + generate;
	 	MahasiswaModel mahasiswa = new MahasiswaModel (generateNPM, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, status, tahun_masuk,jalur_masuk, id_prodi, fakultas, univ, prodi);
		mahasiswaDAO.addMahasiswa (mahasiswa);
		model.addAttribute ("mahasiswa", mahasiswa);
        return "add-success";
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
