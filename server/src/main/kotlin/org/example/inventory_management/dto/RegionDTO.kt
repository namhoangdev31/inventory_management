package org.example.inventory_management.dto

import org.example.inventory_management.entity.RegionEntity
import org.example.inventory_management.table.inventory_management.RegionTable
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime
import org.jetbrains.exposed.dao.EntityBatchUpdate
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class RegionDTO(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RegionDTO>(RegionTable)
    var name: String = ""
    var description: String? = null
    var updatedAt by RegionTable.updatedAt

    fun toRegionEntity() = RegionEntity(
        name = name,
        description = description
    )

    override fun flush(batch: EntityBatchUpdate?): Boolean {
        val currentTime = Clock.System.now().toLocalDateTime(TimeZone.currentSystemDefault())
        updatedAt = currentTime
        return super.flush(batch)
    }
}
