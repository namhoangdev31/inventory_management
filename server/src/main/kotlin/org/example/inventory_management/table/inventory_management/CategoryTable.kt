package org.example.inventory_management.table.inventory_management

import org.example.inventory_management.table.BaseIntIdTable
/**
 * Table for storing categories of products.
 *
 * Each category has a unique name and optional description.
 */
object CategoryTable : BaseIntIdTable("category") {
    /**
     * Unique name of the category.
     */
    val categoryName = varchar("category_name", 100).uniqueIndex()

    /**
     * Optional description of the category.
     */
    val description = varchar("description", 255).nullable()
}
