package com.ambiws.daggerandcompose.features.home.ui

import androidx.lifecycle.ViewModel
import com.ambiws.daggerandcompose.features.home.data.NumbersRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val repository: NumbersRepository
) : ViewModel() {

    fun getNumberFact(): String {
        return repository.getNumberFact()
    }
}
