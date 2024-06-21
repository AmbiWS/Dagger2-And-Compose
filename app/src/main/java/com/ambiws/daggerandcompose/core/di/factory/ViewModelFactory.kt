package com.ambiws.daggerandcompose.core.di.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ambiws.daggerandcompose.base.BaseViewModel
import javax.inject.Inject
import javax.inject.Provider

class ViewModelFactory @Inject constructor(
    private val viewModelFactories: Map<Class<out BaseViewModel>, @JvmSuppressWildcards Provider<BaseViewModel>>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return viewModelFactories.getValue(modelClass as Class<BaseViewModel>).get() as T
    }

    val viewModelsClasses get() = viewModelFactories.keys
}
