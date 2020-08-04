package com.choala.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.choala.local.model.CharacterEntity
import com.choala.local.model.EpisodeEntity
import com.choala.local.model.LocationEntity

@Database(
    version = 1,
    entities = [
        CharacterEntity::class,
        EpisodeEntity::class,
        LocationEntity::class
    ]
)
abstract class DataBase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
    abstract fun locationDao(): LocationDao
    abstract fun episodeDao(): EpisodeDao
}