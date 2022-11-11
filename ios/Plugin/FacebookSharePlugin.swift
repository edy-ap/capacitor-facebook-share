import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(FacebookSharePlugin)
public class FacebookSharePlugin: CAPPlugin {
    private let implementation = FacebookShare()
    
    @objc func sharePhoto(_ call: CAPPluginCall) {
        let data = call.getString("data") ?? ""
        let hashtags = call.getString("hashtags") ?? ""
        implementation.sharePhoto(data: data, hashtags: hashtags, self)
        call.resolve()
    }
}
