package fund.trusty.trusty

import android.util.Log
import com.google.firebase.iid.FirebaseInstanceIdService
import com.google.firebase.iid.FirebaseInstanceId
import fund.trusty.trusty.retrofit.models.Response
import fund.trusty.trusty.retrofit.models.TrustyInteraceAPI
import retrofit2.Call
import retrofit2.Callback


/**
 * Created by well on 08.02.2018.
 */
class MyFirebaseInstanceIDService : FirebaseInstanceIdService(){
    private val TAG = "MyFirebaseIIDService"

    /**
     * Called if InstanceID token is updated. This may occur if the security of
     * the previous token had been compromised. Note that this is called when the InstanceID token
     * is initially generated so this is where you would retrieve the token.
     */
    // [START refresh_token]
    override fun onTokenRefresh() {
        // Get updated InstanceID token.
        val refreshedToken = FirebaseInstanceId.getInstance().token
        Log.d(TAG, "Refreshed token: " + refreshedToken!!)

        // If you want to send messages to this application instance or
        // manage this apps subscriptions on the server side, send the
        // Instance ID token to your app server.
        sendRegistrationToServer(refreshedToken)
    }
    // [END refresh_token]

    /**
     * Persist token to third-party servers.
     *
     * Modify this method to associate the user's FCM InstanceID token with any server-side account
     * maintained by your application.
     *
     * @param token The new token.
     */
    private fun sendRegistrationToServer(token: String?) {
        val trustyInteraceAPI= TrustyInteraceAPI.create()
        val call = trustyInteraceAPI.setToken(token.toString(), "application/x-www-form-urlencoded")
        call.enqueue(object : Callback<Response> {
            override fun onFailure(call: Call<Response>?, t: Throwable?) {
                Log.d("retrofit", "fail response");
            }

            override fun onResponse(call: Call<Response>?, response: retrofit2.Response<Response>?) {
                Log.d("retrofit", response?.body().toString())
            }
        })
    }
}