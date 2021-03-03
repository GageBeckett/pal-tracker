package io.pivotal.pal.tracker

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableWebMvc
class PalTrackerConfiguration {

    @Bean
    fun timeEntryRepository(): TimeEntryRepository = InMemoryTimeEntryRepository()
}