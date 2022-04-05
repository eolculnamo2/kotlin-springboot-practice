package com.shop.dashboard.services.impl

import com.shop.dashboard.dao.UserDao
import com.shop.dashboard.jax.User
import com.shop.dashboard.mappers.toUser
import com.shop.dashboard.services.LoginService
import com.shop.dashboard.services.PasswordEncryptionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import javax.ws.rs.NotAuthorizedException
import javax.ws.rs.NotFoundException

@Service
class LoginServiceImpl @Autowired constructor(
        private val passwordEncryptionService: PasswordEncryptionService,
        private val userDao: UserDao
    ) : LoginService {

    override fun authenticate(email: String, password: String): User {
        val user = userDao.findByEmail(email) ?: throw NotFoundException("Unable to find user by email")
        if (!passwordEncryptionService.isValid(password, user.password)) {
            throw NotAuthorizedException("Invalid login")
        }
        return user.toUser()
    }

}