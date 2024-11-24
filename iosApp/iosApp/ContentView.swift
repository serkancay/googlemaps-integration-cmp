import ComposeApp
import SwiftUI
import UIKit

struct ComposeView: UIViewControllerRepresentable {
    func makeUIViewController(context: Context) -> UIViewController {
        MainViewControllerKt.MainViewController(
            mapUIViewController: {
                (coordinates: [Coordinate]) -> UIViewController in
                return UIHostingController(
                    rootView: MapView(coordinates: coordinates))
            }
        )
    }

    func updateUIViewController(
        _ uiViewController: UIViewController, context: Context
    ) {}
}

struct ContentView: View {
    var body: some View {
        ComposeView()
            .ignoresSafeArea(.keyboard)  // Compose has own keyboard handler
    }
}
