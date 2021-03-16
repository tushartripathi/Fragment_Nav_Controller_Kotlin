 package com.example.navicontroller

import android.graphics.drawable.ColorDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

 class MainActivity : AppCompatActivity() {

    private lateinit var navController:NavController
     private lateinit var appBarConfig :AppBarConfiguration
     private lateinit var drawerLayout : DrawerLayout
     private lateinit var naviagtionView : NavigationView
     private lateinit var listner: NavController.OnDestinationChangedListener
     @RequiresApi(Build.VERSION_CODES.M)
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         navController = findNavController(R.id.fragment)
         drawerLayout = findViewById(R.id.myDrawerLayout)
         naviagtionView = findViewById(R.id.naviagtionView)
         naviagtionView.setupWithNavController(navController)
         appBarConfig = AppBarConfiguration(navController.graph,drawerLayout )
         setupActionBarWithNavController(navController,appBarConfig)

         listner = NavController.OnDestinationChangedListener { controller, destination, arguments ->
             if(destination.id == R.id.firstFragment)
             {
                 supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.design_default_color_primary_dark)))
             }
             else if (destination.id == R.id.secondFragment)
             {
                 supportActionBar?.setBackgroundDrawable(ColorDrawable(getColor(R.color.design_default_color_background)))
             }
         }


    }

     override fun onSupportNavigateUp(): Boolean {

        val navController = findNavController(R.id.fragment)
         return navController.navigateUp(appBarConfig) || super.onSupportNavigateUp()
     }
}