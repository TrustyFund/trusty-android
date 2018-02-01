package fund.trusty.trusty

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.xwalk.core.XWalkNavigationHistory
import org.xwalk.core.XWalkView
import com.google.firebase.iid.FirebaseInstanceId



class MainActivity : AppCompatActivity(){

    lateinit var xWalkView:XWalkView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        xWalkView=findViewById<XWalkView>(R.id.xWalkView)
        val token = FirebaseInstanceId.getInstance().token
        Log.d("token fcm", token);
        loadStartPage()
    }



//region xWalk
private fun loadStartPage(){
            xWalkView.load("file:///android_asset/index.html",null)
    }

    override fun onPause() {
        super.onPause()
        xWalkView.onHide();
    }

    override fun onResume() {
        super.onResume()
        loadStartPage()
    }

    override fun onDestroy() {
        super.onDestroy()
        xWalkView.onDestroy()
    }

    override fun onBackPressed() {
        if(xWalkView.navigationHistory.canGoBack()){
            xWalkView.navigationHistory.navigate(XWalkNavigationHistory.Direction.BACKWARD,1)
        }
        else {
            super.onBackPressed()
        }
    }
//endregion
}
