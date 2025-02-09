package com.ambiws.daggerandcompose.utils.extensions

import androidx.activity.OnBackPressedCallback
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment

inline fun <reified T : ViewModel> FragmentActivity.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory)[T::class.java]
}

inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory)[T::class.java]
}

fun NavHostFragment.getCurrentFragment(): Fragment? = childFragmentManager.primaryNavigationFragment

inline fun Fragment.onBackPressedCallback(crossinline onBackPressedCallback: OnBackPressedCallback.() -> Unit) {
    requireActivity().onBackPressedDispatcher.addCallback(this) {
        onBackPressedCallback()
    }
}
