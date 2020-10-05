package com.e.myappliedresource.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.e.myappliedresource.R
import com.e.myappliedresource.databinding.FragmentOilgassBinding
import com.e.myappliedresource.model.Data
import com.e.myappliedresource.model.ResponseModel
import com.e.myappliedresource.utils.Global_utility
import com.e.myappliedresource.viewModel.OilGassPriceVM


class OilGassFragment : Fragment() {

   private lateinit var viewModel: OilGassPriceVM
    private var viewBinding : FragmentOilgassBinding?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding =  DataBindingUtil.inflate(inflater, R.layout.fragment_oilgass, container, false)
        val view = viewBinding!!.getRoot()
        viewModel = ViewModelProviders.of(activity!!).get(OilGassPriceVM::class.java)

        viewBinding!!.oilGassFragVm = viewModel
        viewModel.mainOilGassPriceData()?.observe(activity!!, Observer<ResponseModel> {
            if (it.status.equals("success")){
                viewBinding?.let { v -> result(it.data) }
            }else{
                Global_utility.showtost(activity!!,"null")
            }

        })
        return view
    }

    private fun result(data: Data) {
        viewBinding!!.tvProductPrice.text = data.formatted
        viewBinding!!.tvName.text = data.type
    }


}