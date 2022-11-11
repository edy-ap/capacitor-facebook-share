package com.apestudios.facebook.share;

import com.facebook.FacebookSdk;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "FacebookShare")
public class FacebookSharePlugin extends Plugin {

    private FacebookShare implementation;

    @Override
    public void load() {
        implementation = new FacebookShare(this.getActivity());
        FacebookSdk.sdkInitialize(this.getActivity().getApplicationContext());
    }

    @PluginMethod
    public void sharePhoto(PluginCall call) {
        String data = call.getString("data");
        String hashtags = call.getString("hashtags");

        implementation.sharePhoto(data, hashtags);
        JSObject ret = new JSObject();
        call.resolve(ret);
    }
}
