package com.marazanil.personsapplication.room

import androidx.room.Dao
import androidx.room.Query
import com.marazanil.personsapplication.data.entity.Persons

@Dao
interface PersonDao {
    @Query("SELECT * FROM persons")
     suspend fun allPersons() : List<Persons>
}