package io.pivotal.pal.tracker

import java.time.LocalDate
import java.util.*

data class TimeEntry(val id: Long, val projectId: Long, val userId: Long, val date: LocalDate, val hours: Int)