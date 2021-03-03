package io.pivotal.pal.tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.servlet.function.router

//val routeHandler = WelcomeRouterHandler()
//val router = router {
//    GET(routeHandler::welcomeMessageHandler)
//}

@SpringBootApplication
class PalTrackerApplication

    fun main(args: Array<String>) {
        runApplication<PalTrackerApplication>(*args)
    }
