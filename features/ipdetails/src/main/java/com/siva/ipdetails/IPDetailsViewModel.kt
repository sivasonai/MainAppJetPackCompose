package com.siva.ipdetails

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siva.domain.usecase.IPApiUseCase
import com.siva.domain.utils.Result
import com.siva.entity.IPApiEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IPDetailsViewModel @Inject constructor(
    private val useCase: IPApiUseCase
) : ViewModel() {
    val action: (IPDetailsUiAction) -> Unit

    private val viewModelState = MutableStateFlow(IPDetailsViewModelState(isLoading = true))
    val uiState = viewModelState
        .map(IPDetailsViewModelState::toUiState)
        .stateIn(
            viewModelScope,
            SharingStarted.Eagerly,
            viewModelState.value.toUiState()
        )

    init {
        action = {
            when (it) {
                IPDetailsUiAction.FetchIPDetails -> fetchIPDetails()
            }
        }
        fetchIPDetails()
    }

    private fun fetchIPDetails() {
        viewModelScope.launch {
            useCase.execute().collect { response ->
                println("Varshika response  ${response}")
                when (response) {
                    is Result.Error -> viewModelState.update {
                        println("Varshika error  ${response.message}")
                        it.copy(error = response.message)
                    }

                    is Result.Loading -> viewModelState.update {
                        println("Varshika loading ${response.loading}")
                        it.copy(error = "", isLoading = response.loading)
                    }

                    is Result.Success -> viewModelState.update {
                        println("Varshika Success ${response.data}")
                        it.copy(ipApiEntity = response.data)
                    }
                }
            }
        }
    }
}

private data class IPDetailsViewModelState(
    val isLoading: Boolean = false,
    val error: String = "",
    val ipApiEntity: IPApiEntity? = null
) {
    fun toUiState(): IPDetailsUiState =
        if (ipApiEntity != null) IPDetailsUiState.Success(
            isLoading = isLoading,
            error = error,
            ipApiEntity = ipApiEntity
        )
        else IPDetailsUiState.Error(isLoading = isLoading, error = error)
}

sealed interface IPDetailsUiState {
    val isLoading: Boolean
    val error: String

    data class Success(
        val ipApiEntity: IPApiEntity,
        override val isLoading: Boolean,
        override val error: String
    ) : IPDetailsUiState

    data class Error(
        override val isLoading: Boolean,
        override val error: String
    ) : IPDetailsUiState
}

sealed class IPDetailsUiAction {
    object FetchIPDetails : IPDetailsUiAction()
}