package com.example.tugas1.model;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FakultasModel {
	private int id;
	private String kode_fakultas;
	private String nama_fakultas;
	private int id_univ;
}
