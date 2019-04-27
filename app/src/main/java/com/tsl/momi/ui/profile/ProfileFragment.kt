package com.tsl.momi.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.orhanobut.hawk.Hawk
import com.tsl.momi.R
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.ui.itemList.ItemListAdapter
import com.tsl.momi.utils.DONATION_LIST
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private var mDonationList: MutableList<DonationItem> = mutableListOf<DonationItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerview.layoutManager = GridLayoutManager(activity, 2)
        val mAdapter = ItemListAdapter(mDonationList)
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT)
        mDonationList = Hawk.get(DONATION_LIST, mutableListOf<DonationItem>())
        mAdapter.setNewData(mDonationList)
        recyclerview.adapter = mAdapter
        clean_out_button.setOnClickListener {
            mDonationList.clear()
            mAdapter.notifyDataSetChanged()
        }
    }
}
