package com.shop.dashboard.config

import com.shop.dashboard.resources.PingResource
import com.shop.dashboard.resources.SessionResource
import com.shop.dashboard.resources.UsersResource
import org.glassfish.jersey.server.ResourceConfig
import org.springframework.context.annotation.Configuration


@Configuration
class JerseyConfig : ResourceConfig() {
    init {
        register(PingResource::class.java)
        register(UsersResource::class.java)
        register(SessionResource::class.java)
    }
}
