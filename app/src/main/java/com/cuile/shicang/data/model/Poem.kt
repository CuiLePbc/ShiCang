package com.cuile.shicang.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "loding_poem")
data class Poem(
    @PrimaryKey(autoGenerate = true)
    val id: Int,

    val title: String,

    val author: String,

    val content: String,

    @ColumnInfo(name = "object_id")
    val objectId: String,

    @ColumnInfo(name = "created_at")
    val createdAt: String,

    @ColumnInfo(name = "updated_at")
    val updatedAt: String
)