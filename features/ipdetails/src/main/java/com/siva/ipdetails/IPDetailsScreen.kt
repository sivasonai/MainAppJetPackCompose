package com.siva.ipdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.siva.common.compose.ApplicationAppbar
import com.siva.common.compose.CircularProgressBar
import com.siva.common.compose.NetworkErrorMessage
import com.siva.common.compose.RowTextFieldCompose
import com.siva.entity.IPApiEntity

@Composable
fun IPDetailsScreen(
    uiState: IPDetailsUiState,
    onRefresh: () -> Unit,
    onMapClick: () -> Unit,
) {
    IPDetailsScreen(
        uiState = uiState,
        success = { ipApiEntity, modifier ->
            IPDetailsContentView(entity = ipApiEntity, modifier = modifier, mapClick = onMapClick)
        },
        error = { message ->
            Column(Modifier.fillMaxSize()) {
                NetworkErrorMessage(
                    message = message,
                    onClickRefresh = onRefresh
                )
                val ipApiEntity = IPApiEntity()
                val modifier = Modifier
                IPDetailsContentView(
                    entity = ipApiEntity,
                    modifier = modifier,
                    mapClick = onMapClick
                )
            }
        }
    )
}

@Composable
private fun IPDetailsScreen(
    uiState: IPDetailsUiState,
    success: @Composable (ipApiEntity: IPApiEntity, modifier: Modifier) -> Unit,
    error: @Composable (message: String) -> Unit,
) {
    Scaffold(topBar = {
        ApplicationAppbar(
            title = stringResource(R.string.ip_details)
        )
    }) {
        val modifier = Modifier.padding(it)
        FullScreenLoading(
            isLoading = uiState.isLoading,
            loadingContent = { CircularProgressBar() },
            content = {
                when (uiState) {
                    is IPDetailsUiState.Error -> error(uiState.error)
                    is IPDetailsUiState.Success -> success(uiState.ipApiEntity, modifier)
                }
            }
        )
    }
}

@Composable
private fun FullScreenLoading(
    isLoading: Boolean,
    loadingContent: @Composable () -> Unit,
    content: @Composable () -> Unit,
) {
    if (isLoading) loadingContent()
    else content()
}

@Composable
private fun IPDetailsContentView(
    modifier: Modifier = Modifier,
    entity: IPApiEntity,
    mapClick: () -> Unit
) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        RowTextFieldCompose(
            textOne = stringResource(R.string.ip_address),
            textTwo = entity.ip.toString(),
            modifier = modifier
        )
        RowTextFieldCompose(
            textOne = stringResource(R.string.network),
            textTwo = entity.network.toString(),
            modifier = modifier
        )
        RowTextFieldCompose(
            textOne = stringResource(R.string.version),
            textTwo = entity.version.toString(),
            modifier = modifier
        )
        RowTextFieldCompose(
            textOne = stringResource(R.string.address),
            textTwo = entity.city.toString() + ", " + entity.region.toString() + ",\n" + entity.country_name.toString() + "-" + entity.postal.toString(),
            modifier = modifier
        )
        RowTextFieldCompose(
            textOne = stringResource(R.string.timezone),
            textTwo = entity.timezone.toString(),
            modifier = modifier
        )
        RowTextFieldCompose(
            textOne = stringResource(R.string.currency),
            textTwo = entity.currency.toString(),
            modifier = modifier
        )
        RowTextFieldCompose(
            textOne = stringResource(R.string.organization),
            textTwo = entity.org.toString(),
            modifier = modifier
        )
        Spacer(modifier = modifier.height(16.dp))
        Button(
            modifier = modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 54.dp),
            onClick = { mapClick() },
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = stringResource(R.string.locate_my_ip_on_map))
        }
    }
}


