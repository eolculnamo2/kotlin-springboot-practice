package com.shop.dashboard.resources

import com.shop.dashboard.jax.Login
import com.shop.dashboard.jax.User
import com.shop.dashboard.services.LoginService
import org.springframework.beans.factory.annotation.Autowired
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/sessions")
class SessionResource @Autowired constructor(private val loginService: LoginService) {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun login(@Valid login: Login): User = loginService.authenticate(login.email, login.password)

    @DELETE
    fun logout() {
        println("Logging out...")
    }
}