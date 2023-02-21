package com.troshchiy.roomtest.di

import com.troshchiy.roomtest.db.UsersRepository
import com.troshchiy.roomtest.db.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class MainModule {

    @Binds
    abstract fun hitsRepository(repo: UsersRepositoryImpl): UsersRepository

}
