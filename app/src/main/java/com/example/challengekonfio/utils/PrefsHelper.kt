package com.example.challengekonfio.utils

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class PrefsHelper @Inject constructor(@ApplicationContext private val context: Context) {

    private var pref: SharedPreferences
    private var editor: SharedPreferences.Editor

    private var PRIVATE_MODE = 0
    companion object {
        private const val PREF_NAME = "prefs"
        private const val is_ONE_TIME = "isOneTime"
    }

    init {
        pref = context.getSharedPreferences(PREF_NAME, PRIVATE_MODE)
        editor = pref.edit()
    }

    var oneTime: Boolean
        get() = pref.getBoolean(is_ONE_TIME, true)
        set(isFirstTime) {
            editor.putBoolean(is_ONE_TIME, isFirstTime)
            editor.commit()
        }



}