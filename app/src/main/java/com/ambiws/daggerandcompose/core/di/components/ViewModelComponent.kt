package com.ambiws.daggerandcompose.core.di.components

import android.content.Context
import com.ambiws.daggerandcompose.core.di.factory.ViewModelFactory
import com.ambiws.daggerandcompose.core.di.modules.NetModule
import com.ambiws.daggerandcompose.core.di.modules.UtilsModule
import com.ambiws.daggerandcompose.core.di.modules.ViewModelModule
import com.ambiws.daggerandcompose.core.di.scopes.FeatureScope
import com.ambiws.daggerandcompose.features.list.di.ListModule
import dagger.BindsInstance
import dagger.Subcomponent

@Subcomponent(
    modules = [
        ViewModelModule::class, NetModule::class,
        UtilsModule::class, ListModule::class
    ]
)
@FeatureScope
interface ViewModelComponent {

    val factory: ViewModelFactory

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun context(context: Context): Builder
        fun build(): ViewModelComponent
    }
}
