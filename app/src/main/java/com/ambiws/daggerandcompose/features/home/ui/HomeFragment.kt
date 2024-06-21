package com.ambiws.daggerandcompose.features.home.ui

import androidx.fragment.app.viewModels
import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.databinding.FragmentHomeBinding
import com.ambiws.daggerandcompose.utils.loge

class HomeFragment : BaseFragment<FragmentHomeBinding>(
    FragmentHomeBinding::inflate
) {

    private val viewModel: HomeViewModel by viewModels {
        getAppComponent().viewModelsFactory()
    }

    override fun setupUi() {
        super.setupUi()
        loge(viewModel.getNumberFact())
    }
}
