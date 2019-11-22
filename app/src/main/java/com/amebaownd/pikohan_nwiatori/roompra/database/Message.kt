package com.amebaownd.pikohan_nwiatori.roompra.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "message_table")
data class Message(
    @PrimaryKey
    val id :String= UUID.randomUUID().toString(),
    val message : String
)