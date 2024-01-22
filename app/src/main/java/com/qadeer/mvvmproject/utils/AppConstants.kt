package com.qadeer.mvvmproject.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

object AppConstants {

    const val baseUrl = ""


    fun View.showSnackBar(message: String) {
        Snackbar.make(
            this, message, Snackbar.LENGTH_SHORT
        ).show()
    }

}