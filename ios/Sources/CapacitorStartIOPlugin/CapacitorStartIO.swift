import Foundation

@objc public class CapacitorStartIO: NSObject {
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
}
