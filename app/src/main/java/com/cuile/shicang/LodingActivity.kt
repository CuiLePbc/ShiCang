package com.cuile.shicang

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_loding.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LodingActivity : AppCompatActivity(){

    private val lodingViewModel: LodingViewModel by lazy {
        ViewModelProviders.of(this).get(LodingViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loding)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        lodingViewModel.poem.observe(this, Observer<Poem> {
            lodingTitle.text = it.title
            lodingAuthor.text = it.author
            val poemContent = it.content
                .replace(",", ",\n")
                .replace("，", "，\n")
                .replace("。", "。\n")
                .replace(".", ".\n")

            lodingContent.text = poemContent
        })
    }

}
