package com.example.navigation

import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.ActionBar
import com.google.android.material.internal.NavigationMenuItemView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var firstFragment: FirstFragment
    lateinit var secondFragment: SecondFragment
    lateinit var thirdFragment: ThirdFragment

    private var toolbar : Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)
        val actionBar = supportActionBar
        actionBar?.title = "Navigation Drawer"

        val drawerToggle : ActionBarDrawerToggle = object : ActionBarDrawerToggle(this,drawerLayout,toolbar, (
                    R.string.open),(R.string.close)) {

        }

        drawerToggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(p0: MenuItem): Boolean {
        when (p0.itemId) {
            R.id.nav_first -> {
                firstFragment = FirstFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, firstFragment)
                    .commit()


            }
            R.id.nav_second -> {
                secondFragment = SecondFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, secondFragment)
                    .commit()


            }
            R.id.nav_third -> {
                thirdFragment = ThirdFragment()
                supportFragmentManager.beginTransaction().replace(R.id.frame_layout, thirdFragment)
                    .commit()


            }


        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
