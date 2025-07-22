package com.ambiws.daggerandcompose.features.profile.ui

import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.databinding.FragmentProfileBinding

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(
    FragmentProfileBinding::inflate
) {

    override fun setupListeners() {
        super.setupListeners()
        binding.customToolbar.ivLeftAction.setOnClickListener {
            viewModel.navigateBack()
        }
    }
}
