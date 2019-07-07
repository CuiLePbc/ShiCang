package com.cuile.shicang

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Poem::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun poemDao(): PoemDao
}