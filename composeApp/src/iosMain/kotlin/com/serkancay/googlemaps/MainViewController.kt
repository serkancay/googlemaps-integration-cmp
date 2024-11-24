package com.serkancay.googlemaps

import androidx.compose.ui.window.ComposeUIViewController
import platform.UIKit.UIViewController

lateinit var mapViewController: (List<Coordinate>) -> UIViewController

fun MainViewController(
    mapUIViewController: (List<Coordinate>) -> UIViewController
) = ComposeUIViewController {
    mapViewController = mapUIViewController
    App()
}