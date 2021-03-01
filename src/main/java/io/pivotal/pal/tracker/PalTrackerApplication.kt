package io.pivotal.pal.tracker

import org.springframework.boot.runApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
open class PalTrackerApplication
        fun main(args: Array<String>) {
            runApplication<PalTrackerApplication>(*args)
        }
