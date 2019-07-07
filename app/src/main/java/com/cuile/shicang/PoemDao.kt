package com.cuile.shicang

import androidx.room.*

@Dao
interface PoemDao {
    @Query("SELECT * FROM loding_poem")
    fun getAllLodingPoems(): List<Poem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPoem(poem: Poem)

    @Delete
    fun deletePoem(poem: Poem)
}