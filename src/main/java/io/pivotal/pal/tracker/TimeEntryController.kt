package io.pivotal.pal.tracker

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/time-entries")
class TimeEntryController(private val timeEntryRepository: TimeEntryRepository) {

    @PostMapping
    @ResponseBody
    fun create(@RequestBody timeEntry: TimeEntry?):ResponseEntity<TimeEntry> =
        timeEntryRepository.create(timeEntry).let {
            ResponseEntity<TimeEntry>(it, HttpStatus.CREATED)
        }

    @GetMapping("/{id}")
    @ResponseBody
    fun read(@PathVariable id: Long):ResponseEntity<TimeEntry> =
        timeEntryRepository.find(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @GetMapping
    fun list():ResponseEntity<MutableList<TimeEntry>> = timeEntryRepository.list().let {
        ResponseEntity.ok(it)
    }

    @PutMapping("/{id}")
    @ResponseBody
    fun update(@PathVariable id: Long,
               @RequestBody timeEntry: TimeEntry):ResponseEntity<TimeEntry> =
        timeEntryRepository.update(id, timeEntry)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> =
        ResponseEntity.noContent().build<Void>().also {
            timeEntryRepository.delete(id)
        }
}