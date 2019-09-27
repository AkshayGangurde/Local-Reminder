package com.mahindra.kmsga.utils

import android.app.Application
import android.content.Context
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Base64
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import java.nio.charset.StandardCharsets
import java.text.SimpleDateFormat
import java.util.*

//Common Methods
fun getBase64String(input: String): String {
    val data: ByteArray = input.toByteArray(StandardCharsets.UTF_8)
    return Base64.encodeToString(data, Base64.DEFAULT)
}

fun isEmptyField(txt: EditText): Boolean {
    return TextUtils.isEmpty(txt.text.toString()) || txt.text.toString().equals(
        "null",
        ignoreCase = true
    )
}

fun isInteger(number: String): Boolean {
    var number = number
    number = "" + number
    try {
        Integer.parseInt(number)
        return true
    } catch (e: NumberFormatException) {
        return false

    }

}
//Extension Functions

fun Context.showToast(charSequence: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, charSequence, duration).show()
}

/**
 *  get the current date in specified format
 * @param timeStampFormat
 * @return
 */
fun getCurrentTimeStamp(timeStampFormat: String): String {
    return SimpleDateFormat(timeStampFormat, Locale.US).format(Date())
}

/**
 * get the requested calendar instance in specified format
 *
 * @param timeStampFormat
 * @param calendar
 * @return
 */
fun getTimeStamp(timeStampFormat: String, calendar: Calendar): String {
    return SimpleDateFormat(timeStampFormat, Locale.US).format(calendar.time)
}
