package com.e.myappliedresource.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.e.myappliedresource.R
import com.e.myappliedresource.adapter.HomeAdapter
import com.e.myappliedresource.databinding.FragmentHomeBinding
import com.e.myappliedresource.viewModel.HomeFragVM


class HomeFragment : Fragment() {


    private lateinit var mAndroidViewModel: HomeFragVM
    private var viewBinding: FragmentHomeBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        viewBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        // Inflate the layout for this fragment
        val view = viewBinding!!.getRoot()
        // inflater.inflate(R.layout.fragment_home, container, false)
        mAndroidViewModel = ViewModelProviders.of(activity!!).get(HomeFragVM::class.java)

        viewBinding!!.recyclerView.setLayoutManager(GridLayoutManager(activity!!,  2))
        viewBinding!!.recyclerView.setHasFixedSize(true);
        viewBinding!!.recyclerView.setItemAnimator( DefaultItemAnimator());
        var adapter = HomeAdapter(activity!!)
        viewBinding!!.recyclerView.adapter = adapter
        return view
    }


}