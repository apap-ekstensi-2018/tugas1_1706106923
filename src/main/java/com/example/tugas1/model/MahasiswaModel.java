package com.example.tugas1.model;
import lombok.NoArgsConstructor;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MahasiswaModel {
	private int id;
    private String npm;
    private String nama;
    private String tempat_lahir;
    private Date tanggal_lahir;
    private int jenis_kelamin;
    private String agama;
    private String golongan_darah;
    private String status;
    private String tahun_masuk;
    private String jalur_masuk;
    private String int_prodi;
    private String nama_prodi;
    private String nama_fakultas;
    private String nama_univ;
    
}
