package com.example.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.tugas1.model.MahasiswaModel;

@Mapper
public interface KemahasiswaanMapper {
	
	@Select ("SELECT npm"
			+ ",nama"
			+ ",tempat_lahir"
			+ ",tanggal_lahir"
			+ ",nama_prodi"
			+ ",nama_fakultas"
			+ ",nama_univ"
			+ ",jenis_kelamin"
			+ ",agama"
			+ ",golongan_darah"
			+ ",tahun_masuk"
			+ ",jalur_masuk"
			+ ",status "
			+ "FROM mahasiswa "
			+ "INNER JOIN Program_Studi ON mahasiswa.id_prodi = Program_Studi.id "
			+ "INNER JOIN Fakultas on Program_Studi.id_fakultas=Fakultas.id "
			+ "INNER JOIN Universitas ON Fakultas.id_univ = Universitas.id where npm=#{npm}")
	MahasiswaModel selectMahasiswa(@Param("npm") String npm);
}
