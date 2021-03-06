package com.example.challengekonfio.utils

import android.app.Activity
import androidx.appcompat.app.AlertDialog
import com.example.challengekonfio.R

class LoadingDialog(private val activity: Activity) {
    private var alertDialog: AlertDialog? = null

    fun startLoadingDialog() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        builder.setView(inflater.inflate(R.layout.dialog_loading, null))
        builder.setCancelable(false)
        alertDialog = builder.create()
        alertDialog!!.show()
    }

    fun dismisDialog() {
        alertDialog!!.dismiss()
    }
}