package com.siva.ipdetails

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun IPDetailsRoute(
    viewModel: IPDetailsViewModel,
    onMapClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val uiAction = remember(viewModel) {
        val action: (IPDetailsUiAction) -> Unit = { viewModel.action(it) }
        action
    }

    IPRoute(
        uiState = uiState,
        onRefresh = {
            uiAction(IPDetailsUiAction.FetchIPDetails)
        },
        onMapClick = onMapClick
    )
}

@Composable
private fun IPRoute(
    uiState: IPDetailsUiState,
    onRefresh: () -> Unit,
    onMapClick: () -> Unit
) {
    IPDetailsScreen(
        uiState = uiState,
        onRefresh = onRefresh,
        onMapClick = onMapClick
    )
}