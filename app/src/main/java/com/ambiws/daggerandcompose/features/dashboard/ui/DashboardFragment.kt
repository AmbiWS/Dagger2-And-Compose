package com.ambiws.daggerandcompose.features.dashboard.ui

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.ambiws.daggerandcompose.R
import com.ambiws.daggerandcompose.base.BaseHostFragment
import com.ambiws.daggerandcompose.base.navigation.BottomNavigationController
import com.ambiws.daggerandcompose.databinding.FragmentDashboardBinding
import com.ambiws.daggerandcompose.features.dashboard.ui.navbar.BottomItem
import com.ambiws.daggerandcompose.utils.extensions.getCurrentFragment
import com.ambiws.daggerandcompose.utils.extensions.onBackPressedCallback
import com.ambiws.daggerandcompose.utils.extensions.subscribe

class DashboardFragment : BaseHostFragment<DashboardViewModel, FragmentDashboardBinding>(
    FragmentDashboardBinding::inflate
) {

    private lateinit var bottomNavigationController: BottomNavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupBottomNavController()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomNavigation()
        initCallbacks()
        binding.bottomNavbar.setActiveTab(BottomItem.HOME)
    }

    private fun initCallbacks() {
        onBackPressedCallback {
            when (binding.bottomNavbar.currentActiveTab) {
                BottomItem.PROFILE -> {
                    binding.bottomNavbar.setActiveTab(binding.bottomNavbar.prevActiveTab)
                }
                else -> {
                    requireActivity().finish()
                }
            }
        }
    }

    private fun setupBottomNavController() {
        bottomNavigationController = BottomNavigationController(
            bottomGraphs = listOf(
                BottomNavigationController.BottomGraph(
                    BottomItem.HOME,
                    R.navigation.navigation_,
                    R.id.navigation_
                ),
                BottomNavigationController.BottomGraph(
                    BottomItem.LIST,
                    R.navigation.navigation_,
                    R.id.navigation_
                ),
                BottomNavigationController.BottomGraph(
                    BottomItem.PROFILE,
                    R.navigation.navigation_,
                    R.id.navigation_
                )
            ),
            fragmentManager = childFragmentManager,
            containerId = R.id.dashboardContainer
        )
    }

    private fun initBottomNavigation() {
        viewModel.connectBottomNavController(
            bottomNavigationController.setup(
                bottomNavigationView = binding.bottomNavbar
            )
        )
    }

    override fun setupObservers() {
        super.setupObservers()
        subscribe(viewModel.bottomBarVisible) {
            binding.bottomNavbar.isVisible = it
        }
        subscribe(viewModel.selectedTab) {
            binding.bottomNavbar.setActiveTab(it)
        }
    }

    override fun getCurrentFragment(): Fragment? =
        (childFragmentManager.findFragmentById(R.id.dashboardContainer) as? NavHostFragment)?.getCurrentFragment()
}
