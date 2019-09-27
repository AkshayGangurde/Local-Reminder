package com.mahindra.kmsga.data.prefs

interface PreferencesHelper {

    //UserResponse Login Status
    fun getCurrentUserLoggedInStatus(): Boolean?

    fun setCurrentUserLoggedInStatus(status: Boolean?)

    //UserResponse Id
    fun setCurrentUserId(userId: Long)

    fun getCurrentUserId(): Long?

    //UserResponse Name
    fun setCurrentUserName(userName: String)

    fun getCurrentUserName(): String?

    //UserResponse Email Id
    fun setCurrentUserEmail(email: String)

    fun getCurrentUserEmail(): String?

    //First Name
    fun setFirstName(firstName: String)

    fun getFirstName(): String?

    //Last Name
    fun setLastName(lastName: String)

    fun getLastName(): String?

}