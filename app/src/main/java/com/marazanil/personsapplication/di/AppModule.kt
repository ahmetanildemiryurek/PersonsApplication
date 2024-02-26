package com.marazanil.personsapplication.di

import android.content.Context
import androidx.room.Room
import com.marazanil.personsapplication.data.repo.PersonDaoRepository
import com.marazanil.personsapplication.room.PersonDao
import com.marazanil.personsapplication.room.PersonDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providePersonDaoRepository(pDao : PersonDao):PersonDaoRepository {
        return PersonDaoRepository(pDao)
    }

    @Singleton
    @Provides
    fun providePersonDao(@ApplicationContext context: Context):PersonDao {
        val db = Room.databaseBuilder(context,PersonDatabase::class.java,"persons.sqlite").
        createFromAsset("persons.sqlite").build()
        return db.getPersonsDao()
    }

}