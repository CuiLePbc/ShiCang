package com.cuile.shicang.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cuile.shicang.R
import com.cuile.shicang.ui.home.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,
                    HomeFragment.newInstance()
                )
                .commitNow()
        }
    }
}
