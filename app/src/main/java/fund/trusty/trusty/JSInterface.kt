package fund.trusty.trusty

import android.content.Context
import android.os.Handler
import android.webkit.JavascriptInterface
import com.google.firebase.iid.FirebaseInstanceId
import android.os.Looper.getMainLooper
import im.delight.android.webview.AdvancedWebView


/**
 * Created by root on 2/28/18.
 */
class JSInterface (val context:Context, val webView:AdvancedWebView) {
    @JavascriptInterface
    fun sendToken(){
        val token = FirebaseInstanceId.getInstance().token
        val mainHandler = Handler(context.mainLooper)

        val myRunnable = Runnable { webView.loadUrl(String.format("javascript:sendToken('%s','android');", token), null) }
        mainHandler.post(myRunnable)
    }
}