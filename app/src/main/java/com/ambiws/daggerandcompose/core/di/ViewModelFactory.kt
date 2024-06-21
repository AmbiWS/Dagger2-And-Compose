package com.ambiws.daggerandcompose.core.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ambiws.daggerandcompose.base.BaseViewModel
import com.ambiws.daggerandcompose.features.home.ui.HomeViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    myViewModelProvider: Provider<HomeViewModel>
) : ViewModelProvider.Factory {

    private val providers = mapOf<Class<*>, Provider<out BaseViewModel>>(
        HomeViewModel::class.java to myViewModelProvider
    )

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return providers[modelClass]!!.get() as T
    }
}
