package com.marazanil.personsapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.marazanil.personsapplication.data.entity.Persons

@Database(entities = [Persons::class], version = 1)
abstract class PersonDatabase : RoomDatabase() {
        abstract fun getPersonsDao () : PersonDao
}