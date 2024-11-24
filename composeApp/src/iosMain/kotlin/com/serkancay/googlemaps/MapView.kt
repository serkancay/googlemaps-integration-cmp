package com.serkancay.googlemaps

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.UIKitInteropInteractionMode
import androidx.compose.ui.viewinterop.UIKitInteropProperties
import androidx.compose.ui.viewinterop.UIKitView

@OptIn(ExperimentalComposeUiApi::class)
@Composable
actual fun MapView(
    modifier: Modifier,
    coordinates: List<Coordinate>,
) {
    UIKitView(
        factory = { mapViewController.invoke(coordinates).view },
        modifier = modifier,
        properties = UIKitInteropProperties(
            isNativeAccessibilityEnabled = true,
            interactionMode = UIKitInteropInteractionMode.NonCooperative,
        )
    )
}