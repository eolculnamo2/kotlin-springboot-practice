package com.shop.dashboard.mappers

import com.shop.dashboard.entities.UserEntity
import com.shop.dashboard.jax.User

// no great mapper options for kotlin?
// https://stackoverflow.com/questions/39199426/better-way-to-map-kotlin-data-objects-to-data-objects

fun UserEntity.toUser(): User {
    return User(
        uuid = uuid,
        email = email,
        firstName = firstName,
        lastName =  lastName,
        enabled = enabled
    )
}