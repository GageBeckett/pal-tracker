package io.pivotal.pal.tracker

import java.time.LocalDate
import java.util.*

class TimeEntry(val id: Long, val projectId: Long, val userId: Long, val date: LocalDate, val hours: Int) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val timeEntry = other as TimeEntry
        return id == timeEntry.id && projectId == timeEntry.projectId && userId == timeEntry.userId && hours == timeEntry.hours && date == timeEntry.date
    }

    override fun hashCode(): Int {
        return Objects.hash(id, projectId, userId, date, hours)
    }

    override fun toString(): String {
        return "TimeEntry{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", userId=" + userId +
                ", date=" + date +
                ", hours=" + hours +
                '}'
    }
}