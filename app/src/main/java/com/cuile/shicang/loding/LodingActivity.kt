package com.cuile.shicang.loding

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.room.Room
import com.cuile.shicang.AppDataBase
import com.cuile.shicang.Poem
import com.cuile.shicang.PoemRepository
import com.cuile.shicang.R
import kotlinx.android.synthetic.main.activity_loding.*

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class LodingActivity : AppCompatActivity(){

    private val lodingViewModel: LodingViewModel by lazy {
        LodingViewModelFactory(
            PoemRepository.getInstance(
                Room.databaseBuilder(
                    applicationContext,
                    AppDataBase::class.java,
                    "shicang").build().poemDao()
            )
        ).create(LodingViewModel::class.java)
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
