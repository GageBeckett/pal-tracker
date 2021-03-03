package io.pivotal.pal.tracker

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class PalTrackerApplication
    fun main(args: Array<String>) {
        runApplication<PalTrackerApplication>(*args)
    }

    @Bean
    fun timeEntryRepository(): TimeEntryRepository {
        return InMemoryTimeEntryRepository()
    }
