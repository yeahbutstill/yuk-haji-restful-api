package com.yeahbutstill.kotlinrestfulapi.model

import java.util.*

data class JamaahResponse(

    val id: String,
    val nama_lengkap: String,
    val nama_ayah_kandung: String,
    val tempat_lahir: String,
    val tgl_lahir: String,
    val ktp: Int?,
    val nik: Int?,
    val paspor: Int?,
    val jenis_kelamin: String,
    val kewarganegaraan: String,
    val alamat_lengkap: String,
    val pekerjaan: String,
    val pendidikan: String,
    val status_calon_jamaah_haji: String,
    val status_perkawinan: String,
    val createdAt: Date,
    val updatedAt: Date?

)
