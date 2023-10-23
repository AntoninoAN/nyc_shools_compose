package com.example.repository.model

import com.example.domain.model.SchoolListResponse


data class SchoolListUseCaseDTO(
    val schoolName: String,
    val zip: String,
    val city: String
)

data class SchoolUseCaseDTO(
    val dbn: String,
    val schoolName: String,
    val zip: String,
    val city: String
)

data class SchoolListSatUseCaseDTO(
    val dbn: String,
    val school_name: String,
    val num_of_sat_test_takers: String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String
)
// Repository DTO
// Domain DTO
// shouldn't known about the Presentation(UI/V-VM) DTO
fun transformation(domainDTO: SchoolListResponse): SchoolListUseCaseDTO {
    return SchoolListUseCaseDTO(
        domainDTO.schoolName,
        domainDTO.zip,
        domainDTO.city
    )
}
