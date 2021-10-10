package com.yeahbutstill.kotlinrestfulapi.service

import com.yeahbutstill.kotlinrestfulapi.model.CreateJamaahRequest
import com.yeahbutstill.kotlinrestfulapi.model.JamaahResponse
import com.yeahbutstill.kotlinrestfulapi.model.ListJamaahRequest
import com.yeahbutstill.kotlinrestfulapi.model.UpdateJamaahRequest

interface JamaahService {

    fun create(createJamaahRequest: CreateJamaahRequest): JamaahResponse

    fun get(id: String): JamaahResponse

    fun update(id: String, updateJamaahRequest: UpdateJamaahRequest): JamaahResponse

    fun delete(id: String)

    fun list(listJamaahRequest: ListJamaahRequest): List<JamaahResponse>

}