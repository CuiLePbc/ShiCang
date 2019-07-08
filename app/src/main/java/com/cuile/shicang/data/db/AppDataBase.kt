package com.cuile.shicang.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cuile.shicang.data.model.Poem

@Database(entities = [Poem::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {
    abstract fun poemDao(): PoemDao
}