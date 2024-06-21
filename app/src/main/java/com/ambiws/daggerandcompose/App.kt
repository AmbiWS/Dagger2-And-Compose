package com.ambiws.daggerandcompose

import android.app.Application
import com.ambiws.daggerandcompose.core.di.AppModule
import com.ambiws.daggerandcompose.core.di.DaggerNetComponent
import com.ambiws.daggerandcompose.core.di.NetComponent
import com.ambiws.daggerandcompose.core.di.NetModule

// TODO Add scopes feature within Dagger 2
// TODO Implement caching feature (lists & room)
// TODO Optimize DI graph
// TODO Check VM recreation cases for MainActivity
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
