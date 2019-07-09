package com.cuile.shicang.ui.loding

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import com.cuile.shicang.data.db.AppDataBase
import com.cuile.shicang.data.model.Poem
import com.cuile.shicang.data.PoemRepository
import com.cuile.shicang.R
import com.cuile.shicang.dagger.loding.inject
import com.cuile.shicang.ui.MainActivity
import kotlinx.android.synthetic.main.activity_loding.*
import javax.inject.Inject

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LodingActivity : AppCompatActivity(){

    @Inject
    lateinit var lodingViewModel: LodingViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loding)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)

        inject(this)

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

        lodingViewModel.showStatus.observe(this, Observer<Boolean> {
            if (it) {
                startActivity(Intent(this, MainActivity::class.java))
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                finish()
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        })
    }

}
