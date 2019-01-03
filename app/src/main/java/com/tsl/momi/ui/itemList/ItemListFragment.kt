package com.tsl.momi.ui.itemList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.google.android.material.snackbar.Snackbar
import com.orhanobut.hawk.Hawk
import com.tsl.momi.R
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.di.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_item_list.*

class ItemListFragment : Fragment() {

    private lateinit var viewModel: ItemListViewModel
    private var errorSnackbar: Snackbar? = null
    private var mDonationList: List<DonationItem> = mutableListOf<DonationItem>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_item_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        item_recyclerview.layoutManager = GridLayoutManager(activity, 2)
        val mAdapter = ItemListAdapter(mDonationList)
        mAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT)
        item_recyclerview.adapter = mAdapter
        viewModel = ViewModelProviders.of(this, ViewModelFactory(activity)).get(ItemListViewModel::class.java)
        viewModel.mItemList.observe(this, Observer { itemList ->
            if(itemList != null){
                mDonationList = itemList
                mAdapter.setNewData(mDonationList)
            }
        })
        viewModel.isLoading.observe(this, Observer { swipe_refresh.isRefreshing = it })
        viewModel.errorMessage.observe(this, Observer {
                errorMessage -> if(errorMessage != null) showError(errorMessage) else hideError()
        })
        swipe_refresh.setOnRefreshListener {viewModel.getCampaigns()}

//        mAdapter.setOnItemClickListener { adapter, view, position ->
//            // we dont need to store all videos to room so just save this video to sharedprefs
//            val campaignVideo = mDonationList[position]
//            Hawk.put(VideoFragment.CAMPAIGN_VIDEO, campaignVideo)
//            Navigation.findNavController(view).navigate(CampaignListFragmentDirections.actionCampaignListFragmentToVideoFragment())
//        }
    }


    private fun showError(errorMessage: String){
        errorSnackbar = Snackbar.make(container, errorMessage, Snackbar.LENGTH_SHORT)
        errorSnackbar?.show()
    }

    private fun hideError(){
        errorSnackbar?.dismiss()
    }
}

