import ComposeApp
import GoogleMaps
import SwiftUI

struct MapView: UIViewRepresentable {
    var coordinates: [Coordinate]

    func makeUIView(context: Context) -> GMSMapView {
        let options = GMSMapViewOptions()
        let path = GMSMutablePath()
        let gmsMapView = GMSMapView(options: options)

        for coordinate in coordinates {
            let marker = GMSMarker()
            let location = CLLocationCoordinate2D(
                latitude: coordinate.latitude, longitude: coordinate.longitude)
            marker.position = location
            marker.title = "iOS Native Marker"
            marker.map = gmsMapView
            path.add(location)
        }

        let bounds = GMSCoordinateBounds(path: path)
        gmsMapView.animate(with: GMSCameraUpdate.fit(bounds, withPadding: 50.0))

        return gmsMapView
    }

    func updateUIView(_ uiView: GMSMapView, context: Context) {}
}
