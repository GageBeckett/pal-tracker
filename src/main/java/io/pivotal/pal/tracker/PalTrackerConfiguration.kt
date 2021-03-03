package io.pivotal.pal.tracker

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class PalTrackerConfiguration {

    @Bean
    fun timeEntryRepository(): TimeEntryRepository = InMemoryTimeEntryRepository()
}