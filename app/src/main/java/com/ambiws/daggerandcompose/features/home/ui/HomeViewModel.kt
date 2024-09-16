package com.ambiws.daggerandcompose.features.home.ui

import com.ambiws.daggerandcompose.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel() {

    fun navigateToList() {
        navigation.navigate(
            HomeFragmentDirections.actionHomeFragmentToListFragment()
        )
    }
}
