package com.ambiws.daggerandcompose.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.viewbinding.ViewBinding
import com.ambiws.daggerandcompose.base.navigation.NavigationCommandHandler
import com.ambiws.daggerandcompose.utils.logd

@Suppress("unused")
abstract class BaseHostFragment<VM : BaseViewModel, VB : ViewBinding>(
    private val inflate: Inflate<VB>
) : BaseFragment<VM, VB>(inflate) {

    override val navigationCommandHandler: NavigationCommandHandler = NavigationCommandHandler(
        navControllerDefinition = { findNavController() },
        childNavControllerDefinition = { getCurrentFragment()!!.findNavController() }
    )

    private val destinationChangedListener =
        NavController.OnDestinationChangedListener { controller, destination, _ ->
            logd("Destination changed in inner graph, graphId: ${controller.graph.id}, destinationId: $destination")
            viewModel.currentDestination.value = destination
            mainViewModel.currentDestination.value = destination
        }

    private val fragmentLifecycleListener = object : FragmentManager.FragmentLifecycleCallbacks() {

        override fun onFragmentStarted(fm: FragmentManager, f: Fragment) {
            if (f is NavHostFragment) {
                f.navController.addOnDestinationChangedListener(destinationChangedListener)
            }
        }

        override fun onFragmentStopped(fm: FragmentManager, f: Fragment) {
            if (f is NavHostFragment) {
                f.navController.removeOnDestinationChangedListener(destinationChangedListener)
            }
        }
    }

    abstract fun getCurrentFragment(): Fragment?

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        childFragmentManager.registerFragmentLifecycleCallbacks(fragmentLifecycleListener, false)
    }

    override fun onDestroyView() {
        super.onDestroyView()

        childFragmentManager.unregisterFragmentLifecycleCallbacks(fragmentLifecycleListener)
    }

    fun navigateChild(direction: NavDirections) {
        viewModel.navigateChild(direction, null)
    }
}
