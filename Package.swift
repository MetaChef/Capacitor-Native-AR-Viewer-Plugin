// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "NativeArViewer",
    platforms: [.iOS(.v14)],
    products: [
        .library(
            name: "NativeArViewer",
            targets: ["NativeARViewerPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", from: "7.0.0")
    ],
    targets: [
        .target(
            name: "NativeARViewerPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/NativeARViewerPlugin"),
        .testTarget(
            name: "NativeARViewerPluginTests",
            dependencies: ["NativeARViewerPlugin"],
            path: "ios/Tests/NativeARViewerPluginTests")
    ]
)