package io.pivotal.pal.tracker

import org.springframework.context.annotation.Bean


class InMemoryTimeEntryRepository: TimeEntryRepository {
    private val timeEntries = hashMapOf<Long, TimeEntry>()
    private var currentId = 1L

    override fun create(timeEntry: TimeEntry) =
        (currentId++).let { id ->
            TimeEntry(id, timeEntry.projectId, timeEntry.userId,
                timeEntry.date, timeEntry.hours)
                .also { timeEntries[id] = it }
        }

    override fun find(id: Long) = timeEntries[id]

    override fun list() = ArrayList(timeEntries.values)

    override fun update(id: Long, timeEntry: TimeEntry) =
        find(id)?.let {
            TimeEntry(
                id,
                timeEntry.projectId,
                timeEntry.userId,
                timeEntry.date,
                timeEntry.hours
            ).also { newTimeEntry -> timeEntries.replace(id, newTimeEntry) }
        }

    override fun delete(id: Long) {
        timeEntries.remove(id)
    }
}