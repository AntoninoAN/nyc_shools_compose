package com.example.repository

import com.example.domain.model.SchoolService
import com.example.repository.model.SchoolListSatUseCaseDTO
import com.example.repository.model.SchoolListUseCaseDTO
import com.example.repository.model.transformation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NYCSchoolUseCaseImpl @Inject constructor(private val service: SchoolService): NYCSchoolUseCase {

    override fun useCaseGetAllSchoolData(): Flow<List<SchoolListUseCaseDTO>> {
        return flow {
            try {
                val response = service.getAllSchool()
                emit(
                    response.map {
                        transformation(it)
                    }
                )
            }catch (ex: Exception) {
                ex.printStackTrace()
                emit(emptyList())
            }
        }
    }

    override fun useCaseGetAllSatReport(): Flow<SchoolListSatUseCaseDTO> {
        TODO("Not yet implemented")
    }
}