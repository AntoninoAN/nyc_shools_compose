package com.example.nycschoolsnomerge_compose.di.modules

import com.example.nycschoolsnomerge_compose.model.NetworkConstants
import com.example.nycschoolsnomerge_compose.model.SchoolService
import dagger.Provides
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Singleton
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