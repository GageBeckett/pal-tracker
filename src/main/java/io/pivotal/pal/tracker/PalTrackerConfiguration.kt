package io.pivotal.pal.tracker

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class PalTrackerConfiguration {

    @Bean
    fun timeEntryRepository(dataSource: DataSource): TimeEntryRepository = JdbcTimeEntryRepository(dataSource)
}