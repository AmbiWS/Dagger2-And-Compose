package com.ambiws.daggerandcompose.core.di.components

import com.ambiws.daggerandcompose.core.di.scopes.AppScope
import dagger.Component

@Component
@AppScope
interface AppComponent {

    val viewModelComponent: ViewModelComponent.Builder

    @Component.Builder
    interface Builder {
        fun build(): AppComponent
    }
}
