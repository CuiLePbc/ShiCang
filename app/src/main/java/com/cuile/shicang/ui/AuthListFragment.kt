package com.cuile.shicang.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.fragment.findNavController
import com.cuile.shicang.R
import kotlinx.android.synthetic.main.fragment_auth_list.*

/**
 * A simple [Fragment] subclass.
 */
class AuthListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_auth_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        goToPoemFragmentBtn.setOnClickListener {
            findNavController().navigate(R.id.poemListFragment)
        }
    }

}
