package com.cuile.shicang.data.db

import androidx.room.*
import com.cuile.shicang.data.model.Poem

@Dao
interface PoemDao {
    @Query("SELECT * FROM loding_poem")
    fun getAllLodingPoems(): List<Poem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPoem(poem: Poem)

    @Delete
    fun deletePoem(poem: Poem)
}