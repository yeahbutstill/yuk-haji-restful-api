package com.yeahbutstill.kotlinrestfulapi.entity

import org.hibernate.Hibernate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "jamaahs")
data class Jamaah(

    @Id
    val id: String,

    @Column(name = "nama_lengkap")
    var nama_lengkap: String,

    @Column(name = "nama_ayah_kandung")
    var nama_ayah_kandung: String,

    @Column(name = "tempat_lahir")
    var tempat_lahir: String,

    @Column(name = "tgl_lahir")
    var tgl_lahir: String,

    @Column(name = "ktp")
    var ktp: Int?,

    @Column(name = "nik")
    var nik: Int?,

    @Column(name = "paspor")
    var paspor: Int?,

    @Column(name = "jenis_kelamin")
    var jenis_kelamin: String,

    @Column(name = "kewarganegaraan")
    var kewarganegaraan: String,

    @Column(name = "alamat_lengkap")
    var alamat_lengkap: String,

    @Column(name = "pekerjaan")
    var pekerjaan: String,

    @Column(name = "pendidikan")
    var pendidikan: String,

    @Column(name = "status_calon_jamaah")
    var status_calon_jamaah_haji: String,

    @Column(name = "status_perkawinan")
    var status_perkawinan: String,

    @Column(name = "created_at")
    var createdAt: Date,

    @Column(name = "updated_at")
    var updatedAt: Date?

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Jamaah

        return id == other.id
    }

    override fun hashCode(): Int = 0
}
