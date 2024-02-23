package com.marazanil.personsapplication.di

import com.marazanil.personsapplication.data.repo.PersonDaoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonDaoRepository() : PersonDaoRepository{
        return  PersonDaoRepository()
    }

}