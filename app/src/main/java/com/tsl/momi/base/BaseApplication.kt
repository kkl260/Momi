package com.tsl.momi.base

import android.app.Application
import com.tsl.momi.BuildConfig
import timber.log.Timber
import com.crashlytics.android.Crashlytics
import com.jakewharton.threetenabp.AndroidThreeTen
import com.orhanobut.hawk.Hawk
import com.tsl.momi.R
import io.fabric.sdk.android.Fabric
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump


class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fabric.with(this, Crashlytics())
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
        ViewPump.init(
            ViewPump.builder()
                .addInterceptor(
                    CalligraphyInterceptor(
                        CalligraphyConfig.Builder()
                            .setDefaultFontPath("fonts/HelveticaNeue-Light.ttf")
                            .setFontAttrId(R.attr.fontPath)
                            .build()
                    )
                )
                .build()
        )
        Hawk.init(this).build()
        AndroidThreeTen.init(this)
    }
}