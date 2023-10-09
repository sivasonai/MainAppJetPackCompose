package com.siva.mainapp.di


import com.siva.data.repoimpl.IPApiRepoImpl
import com.siva.domain.repository.IPApiRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindIPApiRepository(ipApiRepoImpl: IPApiRepoImpl): IPApiRepository

}