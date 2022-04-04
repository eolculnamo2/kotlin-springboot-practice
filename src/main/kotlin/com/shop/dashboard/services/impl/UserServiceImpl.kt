package com.shop.dashboard.services.impl

import com.shop.dashboard.dao.UserDao
import com.shop.dashboard.entities.UserEntity
import com.shop.dashboard.jax.NewUser
import com.shop.dashboard.jax.User
import com.shop.dashboard.mappers.toUser
import com.shop.dashboard.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserServiceImpl @Autowired constructor(private val userDao: UserDao) : UserService {

    override fun getAllUsers(): List<User> {
        val userEntities = userDao.getAllUsers()
        // lambda generally uses curly braces like this:
        // userEntities.map { userEntity -> userEntity.toUser() }
        return userEntities.map(UserEntity::toUser)
    }

    override fun createUser(newUser: NewUser): User {
        var entity = UserEntity(
            uuid = UUID.randomUUID().toString(),
            email = newUser.email,
            password = newUser.password, // encrypt here
            firstName = newUser.firstName,
            lastName = newUser.lastName,
            enabled = true,
        )
        userDao.createUser(entity)
        return entity.toUser()
    }
}