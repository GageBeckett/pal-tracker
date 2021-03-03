package io.pivotal.pal.tracker

import io.reactivex.rxjava3.core.Observable
import org.springframework.web.servlet.function.RouterFunctions
import org.springframework.web.servlet.function.ServerRequest
import org.springframework.web.servlet.function.ServerResponse


class WelcomeRouterHandler {


    fun welcomeMessageHandler(request: ServerRequest): ServerResponse {
        return ServerResponse.ok().body("Hello Using Router")
    }
}