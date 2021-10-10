package com.yeahbutstill.kotlinrestfulapi.service.impl

import com.yeahbutstill.kotlinrestfulapi.entity.Jamaah
import com.yeahbutstill.kotlinrestfulapi.error.NotFoundException
import com.yeahbutstill.kotlinrestfulapi.model.CreateJamaahRequest
import com.yeahbutstill.kotlinrestfulapi.model.JamaahResponse
import com.yeahbutstill.kotlinrestfulapi.model.ListJamaahRequest
import com.yeahbutstill.kotlinrestfulapi.model.UpdateJamaahRequest
import com.yeahbutstill.kotlinrestfulapi.repository.JamaahRepository
import com.yeahbutstill.kotlinrestfulapi.service.JamaahService
import com.yeahbutstill.kotlinrestfulapi.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class JamaahServiceImpl(
    val jamaahRepository: JamaahRepository,
    val validationUtil: ValidationUtil
) : JamaahService {

    private fun convertJamaahToJamaahResponse(jamaah: Jamaah): JamaahResponse {

        return JamaahResponse(

            id = jamaah.id,
            nama_lengkap = jamaah.nama_lengkap,
            nama_ayah_kandung = jamaah.nama_ayah_kandung,
            tempat_lahir = jamaah.tempat_lahir,
            tgl_lahir = jamaah.tgl_lahir,
            ktp = jamaah.ktp,
            nik = jamaah.nik,
            paspor = jamaah.paspor,
            jenis_kelamin = jamaah.jenis_kelamin,
            kewarganegaraan = jamaah.kewarganegaraan,
            alamat_lengkap = jamaah.alamat_lengkap,
            pekerjaan = jamaah.pekerjaan,
            pendidikan = jamaah.pendidikan,
            status_calon_jamaah_haji = jamaah.status_calon_jamaah_haji,
            status_perkawinan = jamaah.status_perkawinan,
            createdAt = jamaah.createdAt,
            updatedAt = jamaah.updatedAt

        )

    }

    private fun findJaamaahByIdOrThrowNotFound(id: String): Jamaah {

        val jamaah = jamaahRepository.findByIdOrNull(id)

        if (jamaah == null) {
            throw NotFoundException()
        } else {
            return jamaah
        }

    }

    override fun create(createJamaahRequest: CreateJamaahRequest): JamaahResponse {

        validationUtil.validate(createJamaahRequest)

        val jamaah = Jamaah(

            id = createJamaahRequest.id!!,
            nama_lengkap = createJamaahRequest.nama_lengkap!!,
            nama_ayah_kandung = createJamaahRequest.nama_ayah_kandung!!,
            tempat_lahir = createJamaahRequest.tempat_lahir!!,
            tgl_lahir = createJamaahRequest.tgl_lahir!!,
            ktp = createJamaahRequest.ktp,
            nik = createJamaahRequest.nik,
            paspor = createJamaahRequest.paspor,
            jenis_kelamin = createJamaahRequest.jenis_kelamin!!,
            kewarganegaraan = createJamaahRequest.kewarganegaraan!!,
            alamat_lengkap = createJamaahRequest.alamat_lengkap!!,
            pekerjaan = createJamaahRequest.pekerjaan!!,
            pendidikan = createJamaahRequest.pendidikan!!,
            status_calon_jamaah_haji = createJamaahRequest.status_calon_jamaah_haji!!,
            status_perkawinan = createJamaahRequest.status_perkawinan!!,
            createdAt = Date(),
            updatedAt = null

        )

        jamaahRepository.save(jamaah)

        return convertJamaahToJamaahResponse(jamaah)

    }

    override fun get(id: String): JamaahResponse {

        val jamaah = findJaamaahByIdOrThrowNotFound(id)

        return convertJamaahToJamaahResponse(jamaah)

    }

    override fun update(id: String, updateJamaahRequest: UpdateJamaahRequest): JamaahResponse {

        val jamaah = findJaamaahByIdOrThrowNotFound(id)

        validationUtil.validate(updateJamaahRequest)

        jamaah.apply {

            nama_lengkap = updateJamaahRequest.nama_lengkap!!
            nama_ayah_kandung = updateJamaahRequest.nama_ayah_kandung!!
            tempat_lahir = updateJamaahRequest.tempat_lahir!!
            tgl_lahir = updateJamaahRequest.tgl_lahir!!
            ktp = updateJamaahRequest.ktp
            nik = updateJamaahRequest.nik
            paspor = updateJamaahRequest.paspor
            jenis_kelamin = updateJamaahRequest.jenis_kelamin!!
            kewarganegaraan = updateJamaahRequest.kewarganegaraan!!
            alamat_lengkap = updateJamaahRequest.alamat_lengkap!!
            pekerjaan = updateJamaahRequest.pekerjaan!!
            pendidikan = updateJamaahRequest.pendidikan!!
            status_calon_jamaah_haji = updateJamaahRequest.status_calon_jamaah_haji!!
            status_perkawinan = updateJamaahRequest.status_perkawinan!!
            updatedAt = Date()

        }

        jamaahRepository.save(jamaah)

        return convertJamaahToJamaahResponse(jamaah)

    }

    override fun list(listJamaahRequest: ListJamaahRequest): List<JamaahResponse> {

        val page = jamaahRepository.findAll(PageRequest.of(listJamaahRequest.page, listJamaahRequest.size))
        val jamaahs: List<Jamaah> = page.get().collect(Collectors.toList())

        return jamaahs.map { convertJamaahToJamaahResponse(it) }
    }

    override fun delete(id: String) {

        val jamaah = findJaamaahByIdOrThrowNotFound(id)

        jamaahRepository.delete(jamaah)
    }

}