package com.ambiws.daggerandcompose.features.home.ui

import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.databinding.FragmentHomeBinding
import com.ambiws.daggerandcompose.utils.logd

class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    override fun setupUi() {
        super.setupUi()
        logd(viewModel.getNumberFact())
    }
}
