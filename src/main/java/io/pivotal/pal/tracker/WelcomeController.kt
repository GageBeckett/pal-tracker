package io.pivotal.pal.tracker

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController(@Value("\${welcome.message}")
                        private val message: String) {

    @GetMapping
    fun sayHello(): String {
        return message
    }
}