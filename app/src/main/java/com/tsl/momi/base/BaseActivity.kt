package com.tsl.momi.base

import android.content.Context
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View.*
import androidx.annotation.NonNull
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.snackbar.Snackbar
import com.tsl.momi.R
import com.tsl.momi.utils.NetworkStateReceiver
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.activity_base.*
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tsl.momi.utils.Utils


class BaseActivity : AppCompatActivity(), NavController.OnDestinationChangedListener, NetworkStateReceiver.NetworkStateReceiverListener {

    lateinit var navController: NavController
    private var networkStateReceiver: NetworkStateReceiver? = null
    private var snackbar: Snackbar? = null
    companion object {
        var isNetworkAvailable = true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
        setSupportActionBar(toolbar)

        snackbar = Snackbar.make(container, getString(R.string.no_internet), Snackbar.LENGTH_INDEFINITE)
        setNetworkStateReceiver()

        navController = Navigation.findNavController(this, R.id.baseNavigationFragment)
        navController.addOnDestinationChangedListener(this)
        bottom_navigation.setupWithNavController(navController)
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when(item.itemId) {
                R.id.home -> {
                    if (!navController.currentDestination!!.id.equals(R.id.welcomeFragment)){
                        navController.navigate(R.id.welcomeFragment)
                    }
                    true
                }
                R.id.chat -> {
                    // Do something for navigation item 1
                    true
                }
                R.id.profile -> {
                    // Do something for navigation item 2
                    true
                }
                else -> false
            }
        }
        bottom_navigation.selectedItemId = R.id.home
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {
        when(destination.id){
            R.id.cameraFragment, R.id.cameraDetailsFragment -> {bottom_navigation.visibility=GONE}
            else -> {appBar.visibility= VISIBLE}
        }
    }

    private fun setNetworkStateReceiver(){
        networkStateReceiver = NetworkStateReceiver(this)
        networkStateReceiver!!.addListener(this)
    }

    override fun onSupportNavigateUp() =
        navController.navigateUp()

    override fun onNetworkAvailable() {
        isNetworkAvailable = true
        snackbar!!.dismiss()
    }

    override fun onNetworkUnavailable() {
        isNetworkAvailable = false
        snackbar!!.show()
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(networkStateReceiver, IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION))
    }

    override fun onPause() {
        unregisterReceiver(networkStateReceiver)
        super.onPause()
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }
}
