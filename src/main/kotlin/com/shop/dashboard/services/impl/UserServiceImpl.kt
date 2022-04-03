package com.shop.dashboard.services.impl

import com.shop.dashboard.dao.UserDao
import com.shop.dashboard.entities.UserEntity
import com.shop.dashboard.jax.User
import com.shop.dashboard.mappers.toUser
import com.shop.dashboard.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl @Autowired constructor(private val userDao: UserDao) : UserService {

    override fun getAllUsers(): List<User> {
        val userEntities = userDao.getAllUsers()
        // lambda generally uses curly braces like this:
        // userEntities.map { userEntity -> userEntity.toUser() }
        return userEntities.map(UserEntity::toUser)
    }

}