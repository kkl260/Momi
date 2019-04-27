package com.tsl.momi.ui.itemDetail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.fragment_camera.*
import com.tsl.momi.R
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.utils.CURRENT_DONATION
import com.tsl.momi.utils.Utils
import kotlinx.android.synthetic.main.fragment_item_details.*
import java.io.File
import java.io.FileOutputStream
import java.util.*


class ItemDetailFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val donationItem = Hawk.get<DonationItem>(CURRENT_DONATION)
        item_name.text = donationItem.title
        Glide.with(view).asBitmap().load(Utils.getByte(donationItem.imagePath)).into(item_image)
    }
}
