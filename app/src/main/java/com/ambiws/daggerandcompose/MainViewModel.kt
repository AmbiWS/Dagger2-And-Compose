package com.ambiws.daggerandcompose

import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.utils.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor() : BaseViewModel() {

    val startDestinationEvent = SingleLiveEvent<Int>()

    fun initStartDestination() {
        startDestinationEvent.value = R.id.dashboardFragment
    }
}
