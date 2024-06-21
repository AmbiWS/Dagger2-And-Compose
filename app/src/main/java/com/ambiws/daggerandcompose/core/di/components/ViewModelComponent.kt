package com.ambiws.daggerandcompose.core.di.components

import com.ambiws.daggerandcompose.core.di.factory.ViewModelFactory
import com.ambiws.daggerandcompose.core.di.modules.ViewModelModule
import com.ambiws.daggerandcompose.core.di.scopes.FeatureScope
import dagger.Subcomponent

@Subcomponent(modules = [ViewModelModule::class])
@FeatureScope
interface ViewModelComponent {

    val factory: ViewModelFactory

    @Subcomponent.Builder
    interface Builder {

        fun build(): ViewModelComponent
    }
}
