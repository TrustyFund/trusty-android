package fund.trusty.trusty

import android.app.Application
import android.content.Intent
import fund.trusty.trusty.retrofit.models.TrustyInteraceAPI
import io.reactivex.disposables.Disposable

/**
 * Created by well on 07.02.2018.
 */
class TrustyApp :Application() {
    val apiTrusty by lazy {
        TrustyInteraceAPI.create()
    }
    var disposable: Disposable? = null
    override fun onCreate() {
        super.onCreate()
    }
}