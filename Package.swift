// swift-tools-version: 5.9
import PackageDescription

let package = Package(
    name: "CapacitorStartio",
    platforms: [.iOS(.v13)],
    products: [
        .library(
            name: "CapacitorStartio",
            targets: ["CapacitorStartIOPlugin"])
    ],
    dependencies: [
        .package(url: "https://github.com/ionic-team/capacitor-swift-pm.git", branch: "main")
    ],
    targets: [
        .target(
            name: "CapacitorStartIOPlugin",
            dependencies: [
                .product(name: "Capacitor", package: "capacitor-swift-pm"),
                .product(name: "Cordova", package: "capacitor-swift-pm")
            ],
            path: "ios/Sources/CapacitorStartIOPlugin"),
        .testTarget(
            name: "CapacitorStartIOPluginTests",
            dependencies: ["CapacitorStartIOPlugin"],
            path: "ios/Tests/CapacitorStartIOPluginTests")
    ]
)