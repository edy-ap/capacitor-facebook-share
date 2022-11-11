import Foundation
import FBSDKShareKit

@objc public class FacebookShare: NSObject, SharingDelegate {
    
    public func sharer(_ sharer: FBSDKShareKit.Sharing, didCompleteWithResults results: [String : Any]) {
    
    }
    
    public func sharer(_ sharer: FBSDKShareKit.Sharing, didFailWithError error: Error) {
    
    }
    
    public func sharerDidCancel(_ sharer: FBSDKShareKit.Sharing) {
    
    }
    

    @objc public func sharePhoto(data: String, hashtags: String) {
        
        let decodedData = NSData(base64Encoded: data, options: [])
        
        guard let stringData = Data(base64Encoded: data),
              let uiImage = UIImage(data: stringData) else {
                  print("Error: couldn't create UIImage")
                  return
              }
        
        let photo = SharePhoto(image: uiImage, isUserGenerated: true)
        
        let content = SharePhotoContent()
        content.photos = [photo]
        
        if(hashtags != ""){
            content.hashtag = Hashtag(hashtags)
        }
        
        let dialog = ShareDialog(
            viewController: UIApplication.shared.keyWindow?.rootViewController,
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

