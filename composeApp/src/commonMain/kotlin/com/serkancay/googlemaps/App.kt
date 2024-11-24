package com.serkancay.googlemaps

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MapView(
                modifier = Modifier.fillMaxSize(),
                coordinates = listOf(
                    Coordinate(latitude = 41.015137, longitude = 28.979530),
                    Coordinate(latitude = 39.925533, longitude = 32.866287),
                    Coordinate(latitude = 38.423733, longitude = 27.142826),
                    Coordinate(latitude = 37.575275, longitude = 36.922821),
                )
            )
        }
    }
}