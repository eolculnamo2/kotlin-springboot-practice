package com.shop.dashboard.resources

import com.shop.dashboard.jax.User
import com.shop.dashboard.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

@Path("/users")
class UsersResource @Autowired constructor(private val userService: UserService) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getAllUsers(): List<User> {
        return userService.getAllUsers()
    }
}