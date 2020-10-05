package com.e.myappliedresource.reposiotry

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.e.myappliedresource.model.ResponseModel
import com.e.myappliedresource.utils.Global_utility
import com.sourceasgroup.apiInterface.WebApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainRepository(application: Application) {
    private var liveDataResponse: MutableLiveData<ResponseModel> = MutableLiveData()

    fun oilpriceapiData(application: Application): MutableLiveData<ResponseModel> {
        with(WebApiService) {
            create().getRespons("Bearer 4b9c72a02fb915ddfc11817e0dfb37dc", "WTI_USD")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe({
                    if (it.status.equals("success")) {
                        liveDataResponse.postValue(it)
                    }else{
                        Global_utility.showtost(application, "error")

                    }
                })

            return liveDataResponse
        }

    }

}