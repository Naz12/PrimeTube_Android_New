package com.example.primetube

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , IMainActivity {

    var  navController : NavController? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(maintoolbar)
        var actionbar = supportActionBar
//        actionbar?.title = "smaple title"
        actionbar?.setIcon(R.drawable.ic_remove_from_queue_black_24dp)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)

         navController = findNavController(R.id.nav_host_fragment)

        navView.setupWithNavController(navController!!)


        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(setOf(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        MenuInflater(this).inflate(R.menu.appbar_menu , menu)
        return true
    }

    override fun navigateToPlayerView(videoId : String) {
        var bundle = Bundle()
        bundle.putString("videoid" , videoId)
        navController!!.navigate(R.id.playerFragment , bundle)
    }


}
