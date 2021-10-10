package com.yeahbutstill.kotlinrestfulapi.repository

import com.yeahbutstill.kotlinrestfulapi.entity.ApiKey
import org.springframework.data.jpa.repository.JpaRepository

interface ApiKeyRepository : JpaRepository<ApiKey, String>