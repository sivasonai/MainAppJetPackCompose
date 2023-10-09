package com.siva.common.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RowTextFieldCompose(textOne: String, textTwo: String, modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(16.dp)
            .background(Color.White)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(modifier = modifier.fillMaxWidth()) {
            Column(
                modifier = modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = textOne)
            }

            Column(
                modifier = modifier.weight(1f),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = textTwo, fontSize = 16.sp, fontWeight = FontWeight.Bold)
            }
        }
        Spacer(modifier = modifier.height(16.dp))
        Spacer(
            modifier = modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(Color.LightGray)
        )
    }
}
