package com.automatodev.home_ponto.config

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.automatodev.home_ponto.dto.AppPreferencesDto
import com.automatodev.home_ponto.util.UtilTag

class AppPreferences(context: Context) {

    private var shared: SharedPreferences? = null
    private val namePreferences: String = "application_pref"

    init {
        shared = context.getSharedPreferences(namePreferences, Context.MODE_PRIVATE)
    }

    fun getAppPreferences(): AppPreferencesDto {

        val pref = AppPreferencesDto()

        pref.showIntro = shared?.getBoolean("showIntro", true)
        pref.darkTheme = shared?.getBoolean("darkTheme", false)
        pref.registration = shared?.getInt("registration", 0)

        return pref
    }

    fun savePreferences(dtoPref: AppPreferencesDto): Boolean {

        return try {

            val edit = shared?.edit()
            edit?.putBoolean("showIntro", dtoPref.showIntro ?: false)
            edit?.putBoolean("darkTheme", dtoPref.darkTheme ?: false)
            edit?.putInt("registration", dtoPref.registration ?: 0)

            edit?.apply()

            true

        } catch (e: Exception) {
            Log.e(UtilTag.TAG, e.printStackTrace().toString())
            false
        }
    }

}