package io.pivotal.pal.tracker

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

class TimeEntryController(private val timeEntryRepository: TimeEntryRepository) {

    fun create(timeEntry: TimeEntry?):ResponseEntity<TimeEntry> {
        //TODO("Not yet implemented")
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    fun read(id: Long):ResponseEntity<TimeEntry> {
        //TODO("Not yet implemented")
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    fun list():ResponseEntity<MutableList<TimeEntry>> {
        //TODO("Not yet implemented")
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    fun update(id: Long, timeEntry: TimeEntry?):ResponseEntity<TimeEntry> {
        //TODO("Not yet implemented")
        return ResponseEntity(HttpStatus.ACCEPTED)
    }

    fun delete(id: Long): ResponseEntity<Void> {
        //TODO("Not yet implemented")
        return ResponseEntity(HttpStatus.ACCEPTED)
    }
}