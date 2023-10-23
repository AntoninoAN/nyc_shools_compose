package com.example.nycschoolsnomerge_compose.model

import com.example.repository.model.SchoolListUseCaseDTO

sealed class UIState {
    data class Success(val data: List<SchoolListUseCaseDTO>): UIState()
    data class Failure(val error: String): UIState()
    data class Loading(val isLoading: Boolean = true): UIState()
    object Initial: UIState()
}
