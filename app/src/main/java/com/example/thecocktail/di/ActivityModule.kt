package com.example.thecocktail.di

import com.example.thecocktail.data.local.LocalDataSource
import com.example.thecocktail.data.local.LocalDataSourceImpl
import com.example.thecocktail.data.local.LocalRepository
import com.example.thecocktail.data.local.LocalRepositoryImpl
import com.example.thecocktail.data.remote.RemoteDataSource
import com.example.thecocktail.data.remote.RemoteDataSourceImpl
import com.example.thecocktail.data.remote.RemoteRepository
import com.example.thecocktail.data.remote.RemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class ActivityModule {

    @Binds
    abstract fun bindRemoteRepositoryImpl(repositoryImpl: RemoteRepositoryImpl): RemoteRepository

    @Binds
    abstract fun bindRemoteDataSourceImpl(dataSourceImpl: RemoteDataSourceImpl): RemoteDataSource

    @Binds
    abstract fun bindLocalRepositoryImpl(localRepositoryImpl: LocalRepositoryImpl): LocalRepository

    @Binds
    abstract fun bindLocalDataSourceImpl(localDataSourceImpl: LocalDataSourceImpl): LocalDataSource
}