package fund.trusty.trusty

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import com.google.firebase.iid.FirebaseInstanceId
import com.jaeger.library.StatusBarUtil
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), AdvancedWebView.Listener{

    @SuppressLint("AddJavascriptInterface", "SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.splashScreenBackground))
        val token = FirebaseInstanceId.getInstance().token.toString()
        Log.d("token fcm", token)

        advancedWebView.setListener(this,this)
        advancedWebView.loadUrl(siteUrl)
        val webViewSettings = advancedWebView.settings;
        webViewSettings.javaScriptEnabled = true
        advancedWebView.addJavascriptInterface(JSInterface(this,advancedWebView), "Android")

    }

    override fun onPageFinished(url: String?) {
        advancedWebView.visibility = View.VISIBLE
        splashScreenImage.visibility = View.INVISIBLE
    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
    }

    override fun onDownloadRequested(url: String?, suggestedFilename: String?, mimeType: String?, contentLength: Long, contentDisposition: String?, userAgent: String?) {
    }

    override fun onExternalPageRequest(url: String?) {
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
    }

    override fun onBackPressed() {
        if(!advancedWebView.onBackPressed())
            return
        super.onBackPressed()
    }

    override fun onResume() {
        super.onResume()
        advancedWebView.onResume();
    }

    override fun onPause() {
        advancedWebView.onPause()
        super.onPause()
    }

    override fun onDestroy() {
        advancedWebView.onDestroy()
        super.onDestroy()
    }
}
