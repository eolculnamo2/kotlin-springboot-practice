package com.shop.dashboard.dao

import com.shop.dashboard.entities.UserEntity
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet

@Repository
class UserDao @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {
    fun getAllUsers(): List<UserEntity> {
        val rowMapper: RowMapper<UserEntity> = RowMapper<UserEntity> { resultSet: ResultSet, rowIndex: Int ->
            UserEntity(
                uuid = checkNotNull(resultSet.getString("uuid")),
                email = checkNotNull(resultSet.getString("email")),
                password = checkNotNull(resultSet.getString("password")),
                firstName = checkNotNull(resultSet.getString("first_name")),
                lastName = checkNotNull(resultSet.getString("last_name")),
                enabled = checkNotNull(resultSet.getBoolean("enabled"))
            )
        }
        return jdbcTemplate.query("SELECT * FROM user", rowMapper)
    }
}