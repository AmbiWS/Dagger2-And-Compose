package com.ambiws.daggerandcompose

import androidx.lifecycle.ViewModel
import com.ambiws.daggerandcompose.utils.SingleLiveEvent
import javax.inject.Inject

class MainViewModel @Inject constructor() : ViewModel() {

    val startDestinationEvent = SingleLiveEvent<Int>()

    fun initStartDestination() {
        startDestinationEvent.value = R.id.homeFragment
    }
}
