package com.kenzietaqiyassar.mandirinewsapp

import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView;
import com.kenzietaqiyassar.mandirinewsapp.databinding.FragmentHomeBinding
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kenzietaqiyassar.mandirinewsapp.adapter.NewsAdapter
import com.kenzietaqiyassar.mandirinewsapp.api.APIClient
import com.kenzietaqiyassar.mandirinewsapp.api.AllNewsAPI
import com.kenzietaqiyassar.mandirinewsapp.api.LatestNewsAPI
import com.kenzietaqiyassar.mandirinewsapp.databinding.ActivityMainBinding
import com.kenzietaqiyassar.mandirinewsapp.domain.NewsRepository
import com.kenzietaqiyassar.mandirinewsapp.model.NewsResponse
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var homeBinding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the main activity layout
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar and other UI elements
        setSupportActionBar(binding.appBarMain.toolbar)

        binding.appBarMain.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // Set up navigation
        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

//        homeBinding = FragmentHomeBinding.inflate(layoutInflater)
//        setContentView(homeBinding.root)
//
//        // Set up RecyclerViews and fetch data
//        homeBinding.rvRecentNews.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
//        homeBinding.rvAllNews.layoutManager = LinearLayoutManager(this)
//        val newsRepository = NewsRepository()
//
//        newsRepository.getRecentNews(
//            onSuccess = { articles ->
//                homeBinding.rvRecentNews.adapter = NewsAdapter(articles)
//            },
//            onFailure = { errorMessage ->
//                println("error")
//            }
//        )
//
//        newsRepository.getAllNews(
//            onSuccess = { articles ->
//                homeBinding.rvAllNews.adapter = NewsAdapter(articles)
//            },
//            onFailure = { errorMessage ->
//                println("error")
//            }
//        )
    }




override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}