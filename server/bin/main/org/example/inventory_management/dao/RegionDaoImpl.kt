package org.example.inventory_management.dao

import org.example.inventory_management.entity.RegionEntity
import org.example.inventory_management.table.inventory_management.RegionTable
import org.jetbrains.exposed.sql.Op

class RegionDaoImpl : RegionDao {
    override suspend fun findRegionByName(name: String): RegionEntity? {
        return null
    }

    override suspend fun insertRegion(region: RegionEntity): RegionEntity {
        return region
    }

    override suspend fun deleteRegion(id: Int): Boolean {
        return true
    }

    override suspend fun getAll(): List<RegionEntity> {
        return emptyList()
    }

    override suspend fun getAllWithCondition(condition: (RegionTable) -> Op<Boolean>): List<RegionEntity> {
        return emptyList()
    }
}