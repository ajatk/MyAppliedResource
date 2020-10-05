package com.sourceasgroup.apiInterface

import android.content.Context
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class WebApiService {
    companion object Factory {

        //Token 4b9c72a02fb915ddfc11817e0dfb37dc
//https://api.oilpriceapi.com/v1/prices/latest/?by_code=WTI_USD
        var BASE_URL = "https://api.oilpriceapi.com/v1/prices/"

        var gson = GsonBuilder().setLenient().create()
        fun create(): ApiInterface {
            //Log.e("retrofit","create")
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val okhttpClient = OkHttpClient.Builder().addInterceptor(logging)
            //okhttpClient.addInterceptor(logging)

            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okhttpClient.build())
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }



}