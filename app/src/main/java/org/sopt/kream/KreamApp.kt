package org.sopt.kream

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate

class KreamApp : Application() {
    override fun onCreate() {
        super.onCreate()

        setDarkMode()
    }

    private fun setDarkMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }
}