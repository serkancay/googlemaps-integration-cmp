package com.serkancay.googlemaps

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
expect fun MapView(
    modifier: Modifier = Modifier,
    coordinates: List<Coordinate>,
)