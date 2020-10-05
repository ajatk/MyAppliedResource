package com.e.myappliedresource.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.e.myappliedresource.model.ResponseModel
import com.e.myappliedresource.reposiotry.MainRepository

class OilGassPriceVM(application: Application): AndroidViewModel(application) {
    private var mainRepository: MainRepository

    init {
        mainRepository = MainRepository(getApplication())
    }
    fun mainOilGassPriceData(): MutableLiveData<ResponseModel>? {

        return mainRepository.oilpriceapiData(getApplication())
    }
}