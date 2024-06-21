package com.ambiws.daggerandcompose.features.home.ui

import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : ViewModel() {

    fun getNumberFact(): String {
        return "Some fact."
    }
}
