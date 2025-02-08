package com.ambiws.daggerandcompose.features.dashboard.ui

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.ambiws.daggerandcompose.R
import com.ambiws.daggerandcompose.base.BaseHostFragment
import com.ambiws.daggerandcompose.databinding.FragmentDashboardBinding
import com.ambiws.daggerandcompose.utils.extensions.getCurrentFragment

class DashboardFragment : BaseHostFragment<DashboardViewModel, FragmentDashboardBinding>(
    FragmentDashboardBinding::inflate
) {


    override fun getCurrentFragment(): Fragment? =
        (childFragmentManager.findFragmentById(R.id.dashboardContainer) as? NavHostFragment)?.getCurrentFragment()
}
