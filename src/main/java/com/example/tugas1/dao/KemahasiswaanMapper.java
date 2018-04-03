package com.example.tugas1.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.*;

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
	
	
	@Insert("INSERT INTO mahasiswa (npm, nama, tempat_lahir, tanggal_lahir, jenis_kelamin, agama, golongan_darah, tahun_masuk, jalur_masuk, id_prodi) "
			+ "VALUES (#{mahasiswa.npm}, #{mahasiswa.nama}, #{mahasiswa.tempat_lahir},  #{mahasiswa.tanggal_lahir}, #{mahasiswa.jenis_kelamin}, #{mahasiswa.agama}, #{mahasiswa.golongan_darah}, #{mahasiswa.tahun_masuk}, #{mahasiswa.jalur_masuk}, #{mahasiswa.id_prodi})")
    void addMahasiswa (@Param("mahasiswa") MahasiswaModel mahasiswa);
	
	@Update("UPDATE mahasiswa SET nama = #{nama}, tempat_lahir = #{tempat_lahir},jenis_kelamin = #{jenis_kelamin},agama = #{agama},golongan_darah = #{golongan_darah},tahun_masuk = #{tahun_masuk},jalur_masuk = #{jalur_masuk},id_prodi = #{id_prodi}  WHERE npm = #{npm}")
    void updateMahasiswa (MahasiswaModel mahasiswa);
	
	@Select("select * from mahasiswa where npm LIKE #{npm} order by npm desc limit 1")
    @Results( value = {
            @Result(property = "npm", column = "npm")
    })
    MahasiswaModel selectMahasiswaByNpm (@Param("npm") String npm);
}
