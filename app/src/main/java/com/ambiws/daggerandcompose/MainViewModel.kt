package com.ambiws.daggerandcompose

import androidx.lifecycle.ViewModel
import com.ambiws.daggerandcompose.utils.SingleLiveEvent

class MainViewModel : ViewModel() {

    val startDestinationEvent = SingleLiveEvent<Int>()

    fun initStartDestination() {
        startDestinationEvent.value = R.id.homeFragment
    }
}
