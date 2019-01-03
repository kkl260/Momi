package com.tsl.momi.ui.camera

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.tsl.momi.R
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.utils.Utils

import kotlinx.android.synthetic.main.fragment_camera_details.*
import java.io.*


class CameraDetailsFragment : Fragment() {

    private lateinit var viewModel: CameraViewModel
    val args: CameraDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(CameraViewModel::class.java)
        Glide.with(view).asBitmap().load(Utils.getByte(args.imagePath)).into(image)
        save_button.setOnClickListener {
            Utils.addItemToList(DonationItem(args.imagePath, title_input_edittext.text.toString()))
            Navigation.findNavController(view).navigate(CameraDetailsFragmentDirections.actionCameraDetailsFragmentToItemListFragment())
        }
    }
}