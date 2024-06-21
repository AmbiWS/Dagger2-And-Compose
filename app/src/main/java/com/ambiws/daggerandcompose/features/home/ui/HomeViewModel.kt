package com.ambiws.daggerandcompose.features.home.ui

import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.features.home.data.NumbersRepository
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    val repository: NumbersRepository
) : BaseViewModel() {

    fun getNumberFact(): String {
        return repository.getNumberFact()
    }
}
