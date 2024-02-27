package com.marazanil.personsapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.marazanil.personsapplication.data.entity.Persons

@Dao
interface PersonDao {
    @Query("SELECT * FROM persons")
    suspend fun allPersons() : List<Persons>

    @Query("SELECT * FROM persons WHERE personName like '%' || :searchedWord || '%'")
    suspend fun findPerson(searchedWord : String) : List<Persons>

    @Insert
    suspend fun addPerson (person: Persons)

}