package fund.trusty.trusty.retrofit.models

import fund.trusty.trusty.baseUrl
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.*


/**
 * Created by well on 08.02.2018.
 */
public interface TrustyInteraceAPI {

    @FormUrlEncoded
    @POST("/token")
    fun setToken(@Field("token") token:String,
                 @Header("Content-type") header: String): Call<Response>

    companion object {
        fun create(): TrustyInteraceAPI{
            val logging = HttpLoggingInterceptor()
            val client = OkHttpClient.Builder()
                    .addInterceptor(logging.setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            val retrofit = Retrofit.Builder()
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .build()
            return retrofit.create(TrustyInteraceAPI::class.java)
        }
    }
}