package com.example.nycschoolsnomerge_compose.model

import retrofit2.http.GET

interface SchoolService {
    @GET(NetworkConstants.ENDPOINT_SCHOOL_LIST)
    suspend fun getAllSchool(): List<SchoolListResponse>
    @GET(NetworkConstants.ENDPOINT_SCHOOL_SAT)
    suspend fun getAllSat(): List<SchoolListSatResponse>
}