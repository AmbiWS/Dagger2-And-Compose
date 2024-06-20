package com.ambiws.daggerandcompose

import android.app.Application
import com.ambiws.daggerandcompose.core.di.component.DaggerNetComponent
import com.ambiws.daggerandcompose.core.di.component.NetComponent
import com.ambiws.daggerandcompose.core.di.module.AppModule
import com.ambiws.daggerandcompose.core.di.module.NetModule


// TODO Add scopes feature within Dagger 2
// TODO Implement caching feature (lists & room)
class App : Application() {

    private lateinit var netComponent: NetComponent

    override fun onCreate() {
        super.onCreate()
        netComponent = DaggerNetComponent.builder()
            .appModule(AppModule(this))
            .netModule(NetModule())
            .build()
    }

    fun getNetComponent(): NetComponent {
        return netComponent
    }
}
