package com.shop.dashboard.resources

import javax.ws.rs.DELETE
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/sessions")
class SessionResource {

    @POST
    fun login() {
        println("Logging in...")
    }

    @DELETE
    fun logout() {
        println("Logging out...")
    }
}