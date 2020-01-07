package com.example.testapp.ui

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.testapp.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        initFragment()
    }

    private fun initFragment() {
        replaceFragment(NowPlayingListFragment())
    }

    //TODO do not have much time to implement appropriate navigation
    fun replaceFragment(fragment: Fragment){
        if(fragment is NowPlayingMovieFragment){
            initToolbar(true)
        }
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fl_container, fragment)
            .addToBackStack(fragment.javaClass.canonicalName)
            .commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
            initToolbar(false)
            return false
        }
        return super.onOptionsItemSelected(item)
    }


    private fun initToolbar(showBack: Boolean) {
        supportActionBar?.apply{
            setDisplayHomeAsUpEnabled(showBack)
            setHomeButtonEnabled(showBack)
        }
    }
}