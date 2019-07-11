package com.cuile.shicang.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.cuile.shicang.R
import com.cuile.shicang.dagger.home.inject
import com.cuile.shicang.data.model.Poem
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment : Fragment() {

    @Inject
    lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        inject(this)

        viewModel.homePoem.observe(this, Observer<Poem> { t -> message.text = t.toString() })

        homeRefreshPoemFAB.setOnClickListener {
            viewModel.refreshHomePoem()
        }
    }

}
