package io.pivotal.pal.tracker

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping
class TimeEntryController(private val timeEntryRepository: TimeEntryRepository) {

    @PostMapping("/time-entries")
    @ResponseBody
    fun create(@RequestBody timeEntry: TimeEntry?):ResponseEntity<TimeEntry> =
        timeEntryRepository.create(timeEntry).let {
            ResponseEntity<TimeEntry>(it, HttpStatus.CREATED)
        }

    @GetMapping("/time-entries/{id}")
    @ResponseBody
    fun read(@PathVariable id: Long):ResponseEntity<TimeEntry> =
        timeEntryRepository.find(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @GetMapping("/time-entries")
    fun list():ResponseEntity<MutableList<TimeEntry>> = timeEntryRepository.list().let {
        ResponseEntity.ok(it)
    }

    @PutMapping("/time-entries/{id}")
    @ResponseBody
    fun update(@PathVariable id: Long,
               @RequestBody timeEntry: TimeEntry):ResponseEntity<TimeEntry> =
        timeEntryRepository.update(id, timeEntry)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/time-entries/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        ResponseEntity.noContent().build<Void>().also {
            timeEntryRepository.delete(id)
        }
}