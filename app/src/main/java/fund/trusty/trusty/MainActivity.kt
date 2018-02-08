package fund.trusty.trusty

import android.graphics.Bitmap
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.LinearLayout
import org.xwalk.core.XWalkNavigationHistory
import org.xwalk.core.XWalkView
import com.google.firebase.iid.FirebaseInstanceId
import fund.trusty.trusty.retrofit.models.Response
import fund.trusty.trusty.retrofit.models.TrustyInteraceAPI
import im.delight.android.webview.AdvancedWebView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback


class MainActivity : AppCompatActivity(), AdvancedWebView.Listener{



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val token = FirebaseInstanceId.getInstance().token.toString()
        Log.d("token fcm", token)

        advancedWebView.setListener(this,this)
        advancedWebView.loadUrl(serverUrl)
    }

    override fun onPageFinished(url: String?) {
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
