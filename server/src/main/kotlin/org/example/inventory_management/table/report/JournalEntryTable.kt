package org.example.inventory_management.table.report

import org.example.inventory_management.table.BaseIntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

/**
 * Table for storing journal entries.
 *
 * This table contains the following columns:
 * - entry_date: The date when the journal entry was made.
 * - description: A description of the journal entry (optional).
 */
object JournalEntryTable : BaseIntIdTable("journal_entry") {
    /**
     * The date when the journal entry was made.
     */
    val entryDate = date("entry_date")

    /**
     * A description of the journal entry (optional).
     */
    val description = text("description").nullable()
}

