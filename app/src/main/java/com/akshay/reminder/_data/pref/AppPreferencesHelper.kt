package com.mahindra.kmsga.data.prefs

import android.content.Context
import android.content.SharedPreferences
import com.akshay.reminder._utilities.AppConstants

object AppPreferencesHelper : PreferencesHelper {

    private const val PREF_KEY_IS_USER_LOGGED_IN = "PREF_KEY_IS_USER_LOGGED_IN"
    private const val PREF_KEY_CURRENT_USER_ID = "PREF_KEY_CURRENT_USER_ID"
    private const val PREF_KEY_CURRENT_USER_NAME = "PREF_KEY_CURRENT_USER_NAME"
    private const val PREF_KEY_CURRENT_USER_EMAIL = "PREF_KEY_CURRENT_USER_EMAIL"
    private const val PREF_KEY_FIRST_NAME = "PREF_KEY_FIRST_NAME"
    private const val PREF_KEY_LAST_NAME = "PREF_KEY_LAST_NAME"

    private var mPrefs: SharedPreferences? = null


    fun getInstance(mContext: Context) {
        if (mPrefs == null) {
            mPrefs = mContext.getSharedPreferences(AppConstants.PREF_NAME, Context.MODE_PRIVATE)
        }
    }

    override fun getCurrentUserLoggedInStatus(): Boolean? {
        return mPrefs?.getBoolean(PREF_KEY_IS_USER_LOGGED_IN, false)
    }

    override fun setCurrentUserLoggedInStatus(status: Boolean?) {
        mPrefs?.edit()?.putBoolean(PREF_KEY_IS_USER_LOGGED_IN, status!!)?.apply()
    }


    override fun getCurrentUserId(): Long? {
        return mPrefs?.getLong(PREF_KEY_CURRENT_USER_ID, 0)
    }

    override fun setCurrentUserId(userId: Long) {
        mPrefs?.edit()?.putLong(PREF_KEY_CURRENT_USER_ID, userId)?.apply()
    }


    override fun getCurrentUserName(): String? {
        return mPrefs?.getString(PREF_KEY_CURRENT_USER_NAME, "")
    }

    override fun setCurrentUserName(userName: String) {
        mPrefs?.edit()?.putString(PREF_KEY_CURRENT_USER_NAME, userName)?.apply()
    }

    override fun getCurrentUserEmail(): String? {
        return mPrefs?.getString(PREF_KEY_CURRENT_USER_EMAIL, null)
    }

    override fun setCurrentUserEmail(email: String) {
        mPrefs?.edit()?.putString(PREF_KEY_CURRENT_USER_EMAIL, email)?.apply()
    }

    override fun setFirstName(firstName: String) {
        mPrefs?.edit()?.putString(PREF_KEY_FIRST_NAME, firstName)?.apply()
    }

    override fun getFirstName(): String? {
        return mPrefs?.getString(PREF_KEY_FIRST_NAME, null)
    }

    override fun setLastName(lastName: String) {
        mPrefs?.edit()?.putString(PREF_KEY_LAST_NAME, lastName)?.apply()
    }

    override fun getLastName(): String? {
        return mPrefs?.getString(PREF_KEY_LAST_NAME, null)
    }

}