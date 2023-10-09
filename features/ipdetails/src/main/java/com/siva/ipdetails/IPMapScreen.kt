package com.siva.ipdetails

import android.content.Context.MODE_PRIVATE
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.viewinterop.AndroidView
import com.siva.common.compose.ApplicationAppbar
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView

@Composable
fun IPMapScreen(
    geoPoint: GeoPoint,
    onPopBack: () -> Unit
) {
    IPDetailsContentView(geoPoint = geoPoint, onPopBack = onPopBack)
}


@Composable
private fun IPDetailsContentView(
    geoPoint: GeoPoint,
    onPopBack: () -> Unit
) {
    Scaffold(topBar = {
        ApplicationAppbar(
            title = stringResource(R.string.ip_location),
            onClickBack = onPopBack
        )
    }) { paddingValues ->
        val modifier = Modifier.padding(paddingValues)

        AndroidView(factory = {
            MapView(it).apply {
                Configuration.getInstance().load(
                    it,
                    it.getSharedPreferences(context.getString(R.string.osm_map), MODE_PRIVATE)
                )
                setTileSource(TileSourceFactory.MAPNIK)
            }
        }, update = { mapView ->
            mapView.apply {
                val controller = controller
                controller.animateTo(geoPoint)
                controller.setZoom(12.0)
            }
        })
    }


}

