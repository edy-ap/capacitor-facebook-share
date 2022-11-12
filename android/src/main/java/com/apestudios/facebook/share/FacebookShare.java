package com.apestudios.facebook.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Base64;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;

public class FacebookShare {

    private ShareDialog shareDialog;

    public FacebookShare(ShareDialog shareDialog) {
        this.shareDialog = shareDialog;
    }

    public void sharePhoto(String data, String hashtags, String mode) {
        byte[] photoImageData = Base64.decode(data, Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(photoImageData, 0, photoImageData.length);
        SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();

        SharePhotoContent.Builder contentBuilder = new SharePhotoContent.Builder().addPhoto(photo);

        if (hashtags != null) {
            contentBuilder.setShareHashtag(new ShareHashtag.Builder().setHashtag(hashtags).build());
        }

        shareDialog.show(contentBuilder.build(), getSharedMode(mode));
    }

    public void shareVideo(String filePath, String hashtags, String mode) {
        Uri videoFileUri = Uri.parse(filePath);

        ShareVideo shareVideo = new ShareVideo.Builder().setLocalUrl(videoFileUri).build();

        ShareVideoContent.Builder contentBuilder = new ShareVideoContent.Builder().setVideo(shareVideo);

        if (hashtags != null) {
            contentBuilder.setShareHashtag(new ShareHashtag.Builder().setHashtag(hashtags).build());
        }

        shareDialog.show(contentBuilder.build(), getSharedMode(mode));
    }

    private ShareDialog.Mode getSharedMode(String mode) {
        ShareDialog.Mode dialogMode;
        switch (mode) {
            case "feed":
                dialogMode = ShareDialog.Mode.FEED;
                break;
            case "native":
                dialogMode = ShareDialog.Mode.NATIVE;
                break;
            case "web":
                dialogMode = ShareDialog.Mode.WEB;
                break;
            default:
                dialogMode = ShareDialog.Mode.AUTOMATIC;
        }

        return dialogMode;
    }
}
