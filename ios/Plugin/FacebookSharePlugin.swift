import Foundation
import Capacitor
import FBSDKShareKit
/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(FacebookSharePlugin)
public class FacebookSharePlugin: CAPPlugin {
    private var implementation = FacebookShare()
    private var callbackId = ""

    override public func load() {
        implementation.plugin = self
    }

    @objc func sharePhoto(_ call: CAPPluginCall) {
        let data = call.getString("data") ?? ""
        let hashtags = call.getString("hashtags") ?? ""
        let sharedMode = call.getString("sharedMode", "automatic")
        implementation.sharePhoto(data, withHashtags: hashtags, withSharedMode: sharedMode)
        callbackId = call.callbackId
        bridge?.saveCall(call)
    }

    @objc func shareVideo(_ call: CAPPluginCall) {
        let path = call.getString("path") ?? ""
        let hashtags = call.getString("hashtags") ?? ""
        let sharedMode = call.getString("sharedMode", "automatic")
        implementation.shareVideo(path, withHashtags: hashtags, withSharedMode: sharedMode)
        callbackId = call.callbackId
        bridge?.saveCall(call)
    }
}

extension FacebookSharePlugin: SharingDelegate {

    public func sharer(_ sharer: Sharing, didCompleteWithResults results: [String: Any]) {
        var response = JSObject()
        response["success"] = true
        response["message"] = "Shared successfully"

        proccessResponse(response)

    }

    public func sharer(_ sharer: Sharing, didFailWithError error: Error) {
        var response = JSObject()
        response["success"] = false
        response["message"] = error.localizedDescription

        proccessResponse(response)
    }

    public func sharerDidCancel(_ sharer: Sharing) {
        var response = JSObject()
        response["success"] = false
        response["message"] = "User cancelled"

        proccessResponse(response)
    }

    private func proccessResponse(_ response: JSObject) {
        if let savedCall = bridge?.savedCall(withID: callbackId) {
            savedCall.resolve(response)
            bridge?.releaseCall(savedCall)
        }
    }
}
