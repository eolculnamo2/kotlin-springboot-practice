package com.shop.dashboard.services

import com.shop.dashboard.jax.User

interface LoginService {
    fun authenticate(email: String, password: String): User
}