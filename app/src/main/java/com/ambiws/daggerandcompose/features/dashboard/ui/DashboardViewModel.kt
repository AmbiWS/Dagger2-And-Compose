package com.ambiws.daggerandcompose.features.dashboard.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.navigation.NavController
import com.ambiws.daggerandcompose.R
import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.features.dashboard.ui.navbar.BottomItem
import com.ambiws.daggerandcompose.utils.SingleLiveEvent
import com.ambiws.daggerandcompose.utils.extensions.mutable
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine

class DashboardViewModel : BaseViewModel() {

    lateinit var currentBottomNavController: LiveData<NavController>

    lateinit var isStartDestination: LiveData<Boolean>

    val bottomBarVisible: LiveData<Boolean> = MutableLiveData(true)

    val selectedTab = SingleLiveEvent<BottomItem>()

    init {
        launch {
            currentDestination.collect {
                bottomBarVisible.mutable().value =
                    when (it?.id) {
                        R.id.profileFragment -> false
                        else -> true
                    }
            }
        }
    }

    fun connectBottomNavController(navControllerFlow: StateFlow<NavController>) {
        currentBottomNavController = navControllerFlow.asLiveData()
        isStartDestination =
            combine(currentDestination, navControllerFlow) { navDestination, navController ->
                navController.graph.startDestinationId == navDestination?.id
            }.asLiveData()
    }
}
