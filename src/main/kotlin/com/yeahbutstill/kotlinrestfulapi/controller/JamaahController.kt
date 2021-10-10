package com.yeahbutstill.kotlinrestfulapi.controller

import com.yeahbutstill.kotlinrestfulapi.model.*
import com.yeahbutstill.kotlinrestfulapi.service.JamaahService
import org.springframework.web.bind.annotation.*

@RestController
class JamaahController(val jamaahService: JamaahService) {

    @PostMapping(
        value = ["/main-api/jamaah"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createJamaah(
        @RequestBody createJamaahRequest: CreateJamaahRequest
    ): WebResponse<JamaahResponse> {

        val jamaahResponse = jamaahService.create(createJamaahRequest)


        return WebResponse(
            code = 200,
            status = "OK",
            data = jamaahResponse
        )

    }

    @GetMapping(
        value = ["/main-api/jamaah/{idJamaah}"],
        produces = ["application/json"]
    )
    fun getJamaah(@PathVariable(value = "idJamaah") id: String): WebResponse<JamaahResponse> {

        val jamaahResponse = jamaahService.get(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = jamaahResponse
        )

    }

    @PutMapping(
        value = ["/main-api/jamaah/{idJamaah}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateJamaah(
        @PathVariable(value = "idJamaah") id: String,
        @RequestBody updateJamaahRequest: UpdateJamaahRequest
    ): WebResponse<JamaahResponse> {

        val jamaahResponse = jamaahService.update(id, updateJamaahRequest)

        return WebResponse(
            code = 200,
            status = "OK",
            data = jamaahResponse
        )

    }

    @GetMapping(
        value = ["/main-api/jamaahs"],
        produces = ["application/json"]
    )
    fun listJamaahs(
        @RequestParam(value = "size", defaultValue = "10") size: Int,
        @RequestParam(value = "page", defaultValue = "0") page: Int
    ): WebResponse<List<JamaahResponse>> {

        val request = ListJamaahRequest(size = size, page = page)
        val response = jamaahService.list(request)

        return WebResponse(
            code = 200,
            status = "OK",
            data = response
        )

    }

    @DeleteMapping(
        value = ["/main-api/jamaah/{idJamaah}"],
        produces = ["application/json"]
    )
    fun deleteJamaah(
        @PathVariable(value = "idJamaah") id: String
    ): WebResponse<String> {

        jamaahService.delete(id)

        return WebResponse(
            code = 200,
            status = "OK",
            data = "DELETED $id"
        )
    }

}