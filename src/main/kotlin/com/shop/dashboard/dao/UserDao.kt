package com.shop.dashboard.dao

import com.shop.dashboard.entities.UserEntity
import com.shop.dashboard.jax.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class UserDao @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {

    private fun mapUserEntity(resultSet: ResultSet): UserEntity {
        return UserEntity(
            uuid = checkNotNull(resultSet.getString("uuid")),
            email = checkNotNull(resultSet.getString("email")),
            password = checkNotNull(resultSet.getString("password")),
            firstName = checkNotNull(resultSet.getString("first_name")),
            lastName = checkNotNull(resultSet.getString("last_name")),
            enabled = checkNotNull(resultSet.getBoolean("enabled"))
        )
    }

    private val rowMapper: RowMapper<UserEntity> = RowMapper<UserEntity> { resultSet: ResultSet, _: Int -> mapUserEntity(resultSet) }

    fun getAllUsers(): List<UserEntity> = jdbcTemplate.query("SELECT * FROM user", rowMapper)

    fun createUser(user: UserEntity) {
        jdbcTemplate.execute("INSERT INTO user(uuid, email, password, first_name, last_name, enabled) VALUES" +
                "('${user.uuid}', '${user.email}', '${user.password}', '${user.firstName}', '${user.lastName}', ${user.enabled})")
    }

    fun findByEmail(email: String): UserEntity? = jdbcTemplate.query("SELECT * FROM user WHERE email = '$email'", rowMapper).getOrNull(0)
}