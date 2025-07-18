package com.ambiws.daggerandcompose.features.home.ui

import androidx.recyclerview.widget.LinearLayoutManager
import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.base.list.DefaultListDiffer
import com.ambiws.daggerandcompose.databinding.FragmentHomeBinding
import com.ambiws.daggerandcompose.features.home.ui.list.HouseBaseItemModel
import com.ambiws.daggerandcompose.features.home.ui.list.HousesAdapterDelegate
import com.ambiws.daggerandcompose.utils.extensions.subscribe
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            DefaultListDiffer<HouseBaseItemModel>(),
            HousesAdapterDelegate.housesDefaultAdapterDelegate(),
        )
    }

    override fun setupUi() {
        super.setupUi()
        with(binding) {
            rvHouses.layoutManager = LinearLayoutManager(requireContext())
            rvHouses.adapter = adapter
        }
    }

    override fun setupObservers() {
        super.setupObservers()
        subscribe(viewModel.housesLiveData) {
            adapter.items = it
        }
    }
}
