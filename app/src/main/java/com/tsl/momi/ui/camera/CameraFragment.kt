package com.tsl.momi.ui.camera

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_camera.*
import androidx.navigation.Navigation
import com.tsl.momi.R
import java.io.File
import java.io.FileOutputStream
import java.util.*


class CameraFragment : Fragment() {

    private lateinit var viewModel: CameraViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this).get(CameraViewModel::class.java)
        take_picture_button.setOnClickListener {
            camera.captureImage { cameraKitView, image ->
                val savedPhoto = File(context!!.cacheDir, Calendar.getInstance().time.toString() + ".jpg")
                try {
                    val outputStream = FileOutputStream(savedPhoto.path)
                    outputStream.write(image)
                    outputStream.close()
                    Navigation.findNavController(view).navigate(CameraFragmentDirections.actionCameraFragmentToCameraDetailsFragment(savedPhoto.path))
                } catch (e: java.io.IOException) {
                    e.printStackTrace()
                }

            }
        }
    }

    override fun onStart() {
        camera.onStart()
        super.onStart()
    }

    override fun onStop() {
        camera.onStop()
        super.onStop()
    }

    override fun onResume() {
        camera.onResume()
        super.onResume()
    }

    override fun onPause() {
        camera.onPause()
        super.onPause()
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        camera.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

}
