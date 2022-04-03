package com.shop.dashboard.services

import com.shop.dashboard.jax.User

interface UserService {
    fun getAllUsers(): List<User>
}