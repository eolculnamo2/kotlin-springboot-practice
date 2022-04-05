package com.shop.dashboard.services.impl

import com.shop.dashboard.services.PasswordEncryptionService
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.stereotype.Service

@Service
class PasswordEncryptionServiceImpl : PasswordEncryptionService {
    override fun encrypt(raw: String): String = BCrypt.hashpw(raw, BCrypt.gensalt())
    override fun isValid(attempt: String, actual: String): Boolean = BCrypt.checkpw(attempt, actual)
}