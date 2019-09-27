package com.mahindra.kmsga.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.util.*


fun hideSoftInput(activity: Activity) {
    var view = activity.currentFocus
    if (view == null)
        view = View(activity)

    val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    Objects.requireNonNull(imm).hideSoftInputFromWindow(view.rootView.windowToken, 0)
}

fun showSoftInput(context: Context, edtText: EditText) {
    edtText.isFocusableInTouchMode = true
    edtText.requestFocus()

    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    Objects.requireNonNull(imm).showSoftInput(edtText, 0)
}

fun toggleSoftInput(context: Context) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    Objects.requireNonNull(imm).toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}
