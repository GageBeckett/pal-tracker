package io.pivotal.pal.tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PalTrackerApplication {
    fun main(args: Array<String>) {
        runApplication<PalTrackerApplication>(*args)
    }
}