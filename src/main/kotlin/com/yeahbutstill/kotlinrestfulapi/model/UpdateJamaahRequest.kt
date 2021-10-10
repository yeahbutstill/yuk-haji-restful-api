package com.yeahbutstill.kotlinrestfulapi.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UpdateJamaahRequest(


    @field:NotBlank
    val nama_lengkap: String?,

    @field:NotBlank
    val nama_ayah_kandung: String?,

    @field:NotBlank
    val tempat_lahir: String?,

    @field:NotNull
    val tgl_lahir: String?,

    @field:NotNull
    @field:Min(value = 3)
    val ktp: Int?,

    @field:NotNull
    @field:Min(value = 3)
    val nik: Int?,

    @field:NotNull
    @field:Min(value = 3)
    val paspor: Int?,

    @field:NotBlank
    val jenis_kelamin: String?,

    @field:NotBlank
    val kewarganegaraan: String?,

    @field:NotBlank
    val alamat_lengkap: String?,

    @field:NotBlank
    val pekerjaan: String?,

    @field:NotBlank
    val pendidikan: String?,

    @field:NotBlank
    val status_calon_jamaah_haji: String?,

    @field:NotBlank
    val status_perkawinan: String?

)
