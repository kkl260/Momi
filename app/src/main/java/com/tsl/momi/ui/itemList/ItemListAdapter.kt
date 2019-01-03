package com.tsl.momi.ui.itemList

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.tsl.momi.R
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.utils.Utils

class ItemListAdapter(data: List<DonationItem>) : BaseQuickAdapter<DonationItem, BaseViewHolder>(R.layout.donation_item, data) {

    override fun convert(helper: BaseViewHolder, donationItem: DonationItem) {
        Glide.with(mContext).asBitmap().load(Utils.getByte(donationItem.imagePath)).into(helper.getView<ImageView>(R.id.donation_image))
        helper.setText(R.id.donation_title, donationItem.title)
    }
}