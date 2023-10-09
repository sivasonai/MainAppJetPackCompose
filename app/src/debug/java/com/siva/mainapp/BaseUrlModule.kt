package com.siva.mainapp

import com.siva.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class BaseUrlModule {
    @Provides
    @AppBaseUrl
    fun provideBaseUrl(): String = "https://ipapi.co/"
}

