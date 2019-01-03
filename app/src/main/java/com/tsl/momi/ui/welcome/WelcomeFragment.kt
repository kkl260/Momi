package com.tsl.momi.ui.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.tsl.momi.R
import kotlinx.android.synthetic.main.fragment_welcome.*

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        receive_background.setOnClickListener { Navigation.findNavController(view).navigate(WelcomeFragmentDirections.actionWelcomeFragmentToItemListFragment())}
        give_background.setOnClickListener { Navigation.findNavController(view).navigate(WelcomeFragmentDirections.actionWelcomeFragmentToCameraFragment())}
    }

}
