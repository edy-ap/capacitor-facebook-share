import Foundation
import FBSDKShareKit

@objc public class FacebookShare: NSObject {

    @objc public func sharePhoto(data: String, hashtags: String) {
        
        let decodedData = NSData(base64EncodedString: data!, options: [])
        
        if let data = decodedData {
            let image = UIImage(data: data as Data)
        }
        
        let photo = SharePhoto(image: image, userGenerated: true)
        
        let content = SharePhotoContent()
        content.photos = [photo]
        
        let dialog = ShareDialog(
            fromViewController: self,
            content: content,
            delegate: self
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
