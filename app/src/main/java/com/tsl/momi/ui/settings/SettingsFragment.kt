package com.tsl.momi.ui.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.tsl.momi.R
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlin.LazyThreadSafetyMode.NONE

class SettingsFragment : Fragment() {

    private val title by lazy(NONE) { arguments?.getString("title") ?: "" }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        settingsTextView.text = title
    }

}
