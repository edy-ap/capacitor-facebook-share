import Foundation
import FBSDKShareKit

@objc public class FacebookShare: NSObject {

    @objc public func sharePhoto(data: String, hashtags: String, facebookSharePlugin: FacebookSharePlugin) {
        
        let decodedData = NSData(base64Encoded: data, options: [])
        
        guard let stringData = Data(base64Encoded: data),
              let uiImage = UIImage(data: stringData) else {
                  print("Error: couldn't create UIImage")
                  return
              }
        
        let photo = SharePhoto(image: uiImage, isUserGenerated: true)
        
        let content = SharePhotoContent()
        content.photos = [photo]
        
        let dialog = ShareDialog(
            fromViewController: facebookSharePlugin.bridge?.viewController,
            content: content,
            delegate: facebookSharePlugin
        )

        // Recommended to validate before trying to display the dialog
        do {
            try dialog.validate()
        } catch {
            // Handle error
        }

        dialog.show()
    }
}
