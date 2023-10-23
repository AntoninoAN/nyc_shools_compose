package com.example.domain.di.modules

import com.example.domain.model.NetworkConstants
import com.example.domain.model.SchoolService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@InstallIn
@Module
class NetworkModule {
    @Provides
    fun provideSchoolService(retrofit: Retrofit): SchoolService {
        return retrofit.create(SchoolService::class.java)
    }

    @Provides
    fun provideRetrofit(moshiConverterFactory: Converter.Factory): Retrofit {
        return Retrofit.Builder()
            .baseUrl(NetworkConstants.BASE_URL)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Provides
    fun provideMoshiConverter(): Converter.Factory =
        MoshiConverterFactory.create()
}