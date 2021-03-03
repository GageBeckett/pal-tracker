package io.pivotal.pal.tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.support.beans

@SpringBootApplication
class PalTrackerApplication

    fun main(args: Array<String>) {
        runApplication<PalTrackerApplication>(*args)
        beans {
            bean<TimeEntryRepository> {
                InMemoryTimeEntryRepository()
            }
        }
    }
