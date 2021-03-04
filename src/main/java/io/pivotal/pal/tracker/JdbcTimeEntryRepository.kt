package io.pivotal.pal.tracker

import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.ResultSetExtractor
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.support.GeneratedKeyHolder
import java.sql.Date
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement.RETURN_GENERATED_KEYS
import java.util.function.BiFunction
import javax.sql.DataSource

class JdbcTimeEntryRepository(dataSource: DataSource) : TimeEntryRepository {
    private val template = JdbcTemplate(dataSource)

    private val mapper: RowMapper<TimeEntry> = RowMapper{rs, _ ->  TimeEntry(
        rs.getLong("id"),
        rs.getLong("project_id"),
        rs.getLong("user_id"),
        rs.getDate("date").toLocalDate(),
        rs.getInt("hours")
    )}

    private val extractor = ResultSetExtractor<TimeEntry> {
        it.takeIf { it.next() }?.let { resultSet ->
            mapper.mapRow(resultSet, 1)
        } ?: throw SQLException("ResultSet is empty")
    }

    override fun create(timeEntry: TimeEntry) = GeneratedKeyHolder().let { keyHolder ->
        template.update({
            it.prepareStatement(
                "INSERT  INTO time_entries (project_id, user_id, date, hours) VALUES (?, ?, ?, ?)",
                RETURN_GENERATED_KEYS
            ).apply {
                setLong(1, timeEntry.projectId)
                setLong(2, timeEntry.userId)
                setDate(3, Date.valueOf(timeEntry.date))
                setInt(4, timeEntry.hours)
            }
        }, keyHolder)
        find(keyHolder.key?.toLong() ?: throw NullPointerException("The Generated Key Could not be found"))
    }


    override fun find(id: Long): TimeEntry =
        template.query("SELECT id, project_id, user_id, date, hours FROM time_entries WHERE id = ?",
        extractor, id) ?: throw throw NullPointerException("The TimeEntry Could not be found")

    override fun list(): MutableList<TimeEntry> =
        template.query("SELECT id, project_id, user_id, date, hours FROM time_entries", mapper)

    override fun update(id: Long, timeEntry: TimeEntry) =
        template.update("UPDATE time_entries SET project_id = ?, user_id = ?, date = ?,  hours = ? WHERE id = ?",
        timeEntry.projectId,
        timeEntry.userId,
        Date.valueOf(timeEntry.date),
        id).let { find(id) }

    override fun delete(id: Long) {
        template.update("DELETE FROM time_entries WHERE id = ?", id)
    }
}