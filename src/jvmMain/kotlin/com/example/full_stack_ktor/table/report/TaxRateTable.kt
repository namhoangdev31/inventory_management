package com.example.full_stack_ktor.table.report

import com.example.full_stack_ktor.table.BaseIntIdTable
import org.jetbrains.exposed.sql.kotlin.datetime.date

/**
 * Table for storing tax rates.
 *
 * Each tax rate has a name, a rate, effective from date and optional effective to date.
 */
object TaxRateTable : BaseIntIdTable("tax_rate") {
    val taxName = varchar("tax_name", 50)
    val rate = decimal("rate", 5, 2)
    val effectiveFrom = date("effective_from")
    val effectiveTo = date("effective_to").nullable()
}
