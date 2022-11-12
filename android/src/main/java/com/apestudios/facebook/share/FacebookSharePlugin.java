package com.apestudios.facebook.share;

import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.widget.ShareDialog;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "FacebookShare")
public class FacebookSharePlugin extends Plugin {

    private FacebookShare implementation;

    private String callbackId;

    private CallbackManager callbackManager;
    private ShareDialog shareDialog;

    private FacebookCallback<Sharer.Result> shareCallback = new FacebookCallback<Sharer.Result>() {
        @Override
        public void onCancel() {
            Log.d("FacebookSharePlugin", "Canceled");

            JSObject response = new JSObject();
            response.put("success", false);
            response.put("message", "User cancelled");

            proccessResponse(response);
        }

        @Override
        public void onError(@NonNull FacebookException error) {
            Log.d(getLogTag(), String.format("Error: %s", error.toString()));

            JSObject response = new JSObject();
            response.put("success", false);
            response.put("message", error.getMessage());

            proccessResponse(response);
        }

        @Override
        public void onSuccess(@NonNull Sharer.Result result) {
            Log.d("FacebookSharePlugin", "Success!");

            JSObject response = new JSObject();
            response.put("success", true);
            response.put("message", "Shared successfully");
            if (result.getPostId() != null) {
                response.put("postId", result.getPostId());
            }

            proccessResponse(response);
        }

        private void proccessResponse(JSObject response) {
            PluginCall savedCall = getBridge().getSavedCall(callbackId);

            if (savedCall == null) {
                Log.e(getLogTag(), "error: no plugin saved call found.");
                return;
            }

            savedCall.resolve(response);
            getBridge().releaseCall(callbackId);
        }
    };

    @Override
    public void load() {
        FacebookSdk.sdkInitialize(getActivity().getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        shareDialog = new ShareDialog(getActivity());
        shareDialog.registerCallback(callbackManager, shareCallback);
        implementation = new FacebookShare(shareDialog);
    }

    @PluginMethod
    public void sharePhoto(PluginCall call) {
        String data = call.getString("data");
        String hashtags = call.getString("hashtags");
        String sharedMode = call.getString("sharedMode", "automatic");

        implementation.sharePhoto(data, hashtags, sharedMode);

        callbackId = call.getCallbackId();
        Log.d(getLogTag(), "callbackId: " + callbackId);
        this.bridge.saveCall(call);
    }

    @PluginMethod
    public void shareVideo(PluginCall call) {
        String path = call.getString("path");
        String hashtags = call.getString("hashtags");
        String sharedMode = call.getString("sharedMode", "automatic");

        implementation.shareVideo(path, hashtags, sharedMode);

        callbackId = call.getCallbackId();
        Log.d(getLogTag(), "callbackId: " + callbackId);
        this.bridge.saveCall(call);
    }
}
