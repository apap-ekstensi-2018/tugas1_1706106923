package com.example.tugas1.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tugas1.dao.KemahasiswaanMapper;
import com.example.tugas1.model.MahasiswaModel;

@Slf4j
@Service
public class MahasiswaServiceDatabase implements MahasiswaService{
	@Autowired
	private KemahasiswaanMapper mhsMapper;
	
	@Override
	public MahasiswaModel selectMahasiswa(String npm){
		log.info ("Lihat data mahasiswa dengan NPM : {}", npm);
			return mhsMapper.selectMahasiswa(npm);
	}
}
