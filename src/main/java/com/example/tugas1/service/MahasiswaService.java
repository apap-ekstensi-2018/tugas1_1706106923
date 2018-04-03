package com.example.tugas1.service;

import com.example.tugas1.model.MahasiswaModel;

public interface MahasiswaService {
	MahasiswaModel selectMahasiswa(String npm);

	void addMahasiswa (MahasiswaModel mahasiswa); 

	void updateMahasiswa (MahasiswaModel mahasiswa);

	MahasiswaModel selectMahasiswaByNpm (String npm);
}
