package com.tanamo.dicto


import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric


class Tanamo : Application() {


    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())


    }


}