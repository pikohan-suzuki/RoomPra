package com.amebaownd.pikohan_nwiatori.roompra.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MessageDao{

    @Query("SELECT message FROM message_table")
    fun getMessage():LiveData<List<String>>

    @Insert
    fun insert(message:Message)
}