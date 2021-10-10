package com.yeahbutstill.kotlinrestfulapi.config

import com.yeahbutstill.kotlinrestfulapi.entity.ApiKey
import com.yeahbutstill.kotlinrestfulapi.repository.ApiKeyRepository
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component

@Component
class ApiKeySeeders(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {

    val apiKey = "9G9ZZrBy"

    override fun run(args: ApplicationArguments?) {

        if (!apiKeyRepository.existsById(apiKey)) {
            val key = ApiKey(id = apiKey)
            apiKeyRepository.save(key)
        }
    }
}