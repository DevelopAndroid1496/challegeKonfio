package com.example.challengekonfio.utils

import android.app.Activity
import android.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.challengekonfio.R

class UtilsComponents(private val activity: Activity) {

    private var alertDialog: AlertDialog? = null

    fun showDialogProgress() {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity.layoutInflater
        //builder.setView(inflater.inflate(R.layout.custom_dialog_loading, null))
        builder.setCancelable(false)
        alertDialog = builder.create()
        alertDialog!!.show()
    }

    fun HideDialogProgress() {
        alertDialog!!.dismiss()
    }

    inline fun <reified T: Fragment> canonicalTag(): String? = T::class.java.canonicalName
}