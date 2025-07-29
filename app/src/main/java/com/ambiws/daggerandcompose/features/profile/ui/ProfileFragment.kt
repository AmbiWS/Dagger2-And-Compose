package com.ambiws.daggerandcompose.features.profile.ui

import com.ambiws.daggerandcompose.base.BaseFragment
import com.ambiws.daggerandcompose.databinding.FragmentProfileBinding
import com.ambiws.daggerandcompose.features.dashboard.ui.DashboardFragment
import com.ambiws.daggerandcompose.utils.extensions.getParentFragment

class ProfileFragment : BaseFragment<ProfileViewModel, FragmentProfileBinding>(
    FragmentProfileBinding::inflate
) {

    override fun setupListeners() {
        super.setupListeners()
        setupDashboardNavigationBack()
    }

    private fun setupDashboardNavigationBack() {
        val parentNavigationHostFragment = getParentFragment(false)
        val parentDashboardFragment = parentNavigationHostFragment?.getParentFragment(false)
        val bottomNavbar = if (parentDashboardFragment != null && parentDashboardFragment is DashboardFragment) {
            parentDashboardFragment.binding.bottomNavbar
        } else return

        binding.customToolbar.ivLeftAction.setOnClickListener {
            bottomNavbar.setActiveTab(
                bottomNavbar.prevActiveTab
            )
        }
    }
}
