package com.apestudios.facebook.share;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareHashtag;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.ShareDialog;
import com.getcapacitor.PluginCall;

public class FacebookShare {

    private ShareDialog shareDialog;

    public FacebookShare(ShareDialog shareDialog) {
        this.shareDialog = shareDialog;
    }

    public void sharePhoto(String data, String hashtags) {
        byte[] photoImageData = Base64.decode(data, Base64.DEFAULT);
        Bitmap image = BitmapFactory.decodeByteArray(photoImageData, 0, photoImageData.length);
        SharePhoto photo = new SharePhoto.Builder().setBitmap(image).build();

        SharePhotoContent.Builder contentBuilder = new SharePhotoContent.Builder().addPhoto(photo);

        if (hashtags != null) {
            contentBuilder.setShareHashtag(new ShareHashtag.Builder().setHashtag(hashtags).build());
        }

        shareDialog.show(contentBuilder.build(), ShareDialog.Mode.AUTOMATIC);
    }
}
