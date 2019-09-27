package com.akshay.reminder.splash.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.akshay.reminder.BaseInterface
import com.akshay.reminder.R
import com.akshay.reminder.splash.presenter.SplashPresenter
import com.mahindra.kmsga.data.prefs.AppPreferencesHelper
import com.mahindra.kmsga.utils.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * A simple [Fragment] subclass.
 */
class SplashFragment : Fragment(), BaseInterface.View {

    lateinit var splashPresenter: SplashPresenter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //initialise App Preferences
        AppPreferencesHelper.getInstance(activity!!)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onResume() {
        super.onResume()

        splashPresenter = SplashPresenter(this)

        //Navigate to next screen
        navigate()
    }

    override fun showMessage(message: String) {
        activity?.showToast(message)
    }

    override fun showError(error: String) {
        activity?.showToast(error)
    }

    //for navigating to next screen
    private fun navigate() {
        lifecycleScope.launch {
            delay(2000)
            /*if ()
                findNavController().navigate(R.id.addMessageFragment)
            else {
                findNavController().navigate(R.id.messageListFragment)
            }*/
            findNavController().navigate(R.id.action_blankFragment_to_messageListFragment)
        }
    }

}
