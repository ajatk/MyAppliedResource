package com.sourceasgroup.apiInterface

import com.e.myappliedresource.model.ResponseModel
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {   //Bearer Token
    @Headers("Accept: application/json")
    @GET("latest")
    fun getRespons(@Header( "Authorization") content_type:String, @Query("by_code")pass:String): Observable<ResponseModel>

//    @GET("app/adduser.php")
//    fun getRegister(@Query( "mobile_no") mobil:String, @Query("email")email:String): Single<SignUpResponse>
//
//    @GET("app/search.php")
//    fun getSearch(@Query( "stext") search:CharSequence): Single<SearchDataResponse>

}