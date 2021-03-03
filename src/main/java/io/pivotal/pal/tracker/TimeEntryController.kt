package io.pivotal.pal.tracker

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/time-entries")
class TimeEntryController(private val timeEntryRepository: TimeEntryRepository) {

    @PostMapping("/create")
    @ResponseBody
    fun create(@RequestBody timeEntry: TimeEntry?):ResponseEntity<TimeEntry> =
        timeEntryRepository.create(timeEntry).let {
            ResponseEntity<TimeEntry>(it, HttpStatus.CREATED)
        }

    @GetMapping("/read")
    @ResponseBody
    fun read(@RequestParam("id") id: Long):ResponseEntity<TimeEntry> =
        timeEntryRepository.find(id)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity(HttpStatus.NOT_FOUND)

    @GetMapping("/list")
    fun list():ResponseEntity<MutableList<TimeEntry>> = timeEntryRepository.list().let {
        ResponseEntity.ok(it)
    }

    @PutMapping("/update")
    @ResponseBody
    fun update(@RequestParam("id") id: Long,
               @RequestBody timeEntry: TimeEntry):ResponseEntity<TimeEntry> =
        timeEntryRepository.update(id, timeEntry)?.let {
            ResponseEntity.ok(it)
        } ?: ResponseEntity.notFound().build()

    @DeleteMapping("/delete")
    fun delete(@RequestParam("id") id: Long): ResponseEntity<Void> =
        ResponseEntity.noContent().build<Void>().also {
            timeEntryRepository.delete(id)
        }
}