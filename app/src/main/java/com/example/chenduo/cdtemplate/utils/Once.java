
package com.example.chenduo.cdtemplate.utils;

import android.content.Context;

/**
 * Created by drakeet on 8/16/15.
 */
public class Once {

    Context mContext;

    public Once(Context context) {
        mContext = context;
    }

    public void call(String tagKey, OnceCallback callback) {
        boolean isSecondTime = (boolean) SPUtils.get(mContext, tagKey, false);
        if (!isSecondTime) {
            callback.onCall();
            SPUtils.put(mContext, tagKey, true);
        }
    }

    public void call(int tagKeyResId, OnceCallback callback) {
        call(mContext.getString(tagKeyResId), callback);
    }

    private static final String KEY_ONCE = "ONCE";

    public void call(OnceCallback callback) {
        call(KEY_ONCE, callback);
    }

    public interface OnceCallback {
        void onCall();
    }
}
