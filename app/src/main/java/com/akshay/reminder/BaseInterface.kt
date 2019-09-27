package com.akshay.reminder

interface BaseInterface {

    interface View {

        fun showMessage(message: String)

        fun showError(error: String)
    }

}