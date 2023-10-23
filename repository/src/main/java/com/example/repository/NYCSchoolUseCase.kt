package com.example.repository

import com.example.repository.model.SchoolListSatUseCaseDTO
import com.example.repository.model.SchoolListUseCaseDTO
import kotlinx.coroutines.flow.Flow

interface NYCSchoolUseCase {
    fun useCaseGetAllSchoolData(): Flow<List<SchoolListUseCaseDTO>>
    fun useCaseGetAllSatReport(): Flow<SchoolListSatUseCaseDTO>
}