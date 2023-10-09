package com.siva.ipdetails

import androidx.compose.runtime.Composable
import org.osmdroid.util.GeoPoint

@Composable
fun IPMapRoute(
    onPopBack: () -> Unit,
) {


    MapRoute(
        geoPoint = GeoPoint(11.0142, 76.9941),
        onPopBack = onPopBack
    )
}

@Composable
private fun MapRoute(
    geoPoint: GeoPoint,
    onPopBack: () -> Unit
) {
    IPMapScreen(
        geoPoint = geoPoint,
        onPopBack = onPopBack
    )
}