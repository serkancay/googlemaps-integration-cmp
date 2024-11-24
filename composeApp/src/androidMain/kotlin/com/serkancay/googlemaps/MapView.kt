package com.serkancay.googlemaps

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState

@Composable
actual fun MapView(
    modifier: Modifier,
    coordinates: List<Coordinate>,
) {

    val cameraPositionState = rememberCameraPositionState()
    val bounds = createBounds(coordinates)

    LaunchedEffect(Unit) {
        cameraPositionState.move(
            update = CameraUpdateFactory.newLatLngBounds(bounds, 100)
        )
    }

    Box(
        modifier = modifier,
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            coordinates.map {
                val markerState = rememberMarkerState(position = LatLng(it.latitude, it.longitude))
                Marker(
                    state = markerState,
                    title = "Android Native Marker",
                )
            }
        }
    }
}

private fun createBounds(coordinates: List<Coordinate>): LatLngBounds {
    val boundsBuilder = LatLngBounds.builder()
    coordinates.forEach {
        boundsBuilder.include(LatLng(it.latitude, it.longitude))
    }
    return boundsBuilder.build()
}