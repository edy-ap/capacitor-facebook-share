import Foundation
import FBSDKShareKit

@objc public class FacebookShare: NSObject {

    public var plugin: FacebookSharePlugin?

    @objc public func sharePhoto(_ data: String, withHashtags hashtags: String, withSharedMode mode: String) {

        let decodedData = NSData(base64Encoded: data, options: [])

        guard let stringData = Data(base64Encoded: data),
              let uiImage = UIImage(data: stringData) else {
            print("Error: couldn't create UIImage")
            return
        }

        let photo = SharePhoto(image: uiImage, isUserGenerated: true)

        let content = SharePhotoContent()
        content.photos = [photo]

        if hashtags != "" {
            content.hashtag = Hashtag(hashtags)
        }

        let dialog = ShareDialog(
            viewController: UIApplication.shared.keyWindow?.rootViewController,
            content: content,
            delegate: plugin
        )

        dialog.mode = getSharedMode(mode)

        // Recommended to validate before trying to display the dialog
        do {
            try dialog.validate()
        } catch {
            // Handle error
        }

        dialog.show()
    }

    @objc public func shareVideo(_ path: String, withHashtags hashtags: String, withSharedMode mode: String) {

        guard let url = URL(string: path) else { return }

        let video = ShareVideo(videoURL: url)

        let content = ShareVideoContent()
        content.video = video

        if hashtags != "" {
            content.hashtag = Hashtag(hashtags)
        }

        let dialog = ShareDialog(
            viewController: UIApplication.shared.keyWindow?.rootViewController,
            content: content,
            delegate: plugin
        )

        dialog.mode = getSharedMode(mode)

        // Recommended to validate before trying to display the dialog
        do {
            try dialog.validate()
        } catch {
            // Handle error
        }

        dialog.show()
    }

    private func getSharedMode(_ mode: String) -> ShareDialog.Mode {
        let sharedMode: ShareDialog.Mode
        switch mode {
        case "feed", "feedWeb":
            sharedMode = .feedWeb
        case "feedBrowser":
            sharedMode = .feedBrowser
        case "native":
            sharedMode = .native
        case "shareSheet":
            sharedMode = .shareSheet
        case "web":
            sharedMode = .web
        default:
            sharedMode = .automatic
        }
        return sharedMode
    }
}
