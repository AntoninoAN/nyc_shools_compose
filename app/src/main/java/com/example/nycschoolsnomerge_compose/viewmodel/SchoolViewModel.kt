package com.example.nycschoolsnomerge_compose.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nycschoolsnomerge_compose.model.UIState
import com.example.repository.NYCSchoolUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SchoolViewModel @Inject constructor(private val repository: NYCSchoolUseCase): ViewModel() {

    private val _uiData = MutableStateFlow<UIState>(UIState.Initial)
    val uiData: StateFlow<UIState>
        get() = _uiData

    init {
        viewModelScope.launch {
            repository.useCaseGetAllSchoolData().collect { dataResponse->
                if (dataResponse.isNotEmpty())
                    _uiData.value = UIState.Success(dataResponse)
                else
                    _uiData.value = UIState.Failure("No data from server")
            }
        }
    }
}