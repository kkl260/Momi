package com.tsl.momi.ui.itemList

import androidx.lifecycle.MutableLiveData
import com.orhanobut.hawk.Hawk
import com.tsl.momi.base.BaseViewModel
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.network.BaseApi
import com.tsl.momi.utils.DONATION_LIST
import io.reactivex.disposables.Disposable
import retrofit2.Retrofit
import javax.inject.Inject

class ItemListViewModel :BaseViewModel(){
    @Inject
    lateinit var baseApi: BaseApi

    @Inject
    lateinit var retrofit: Retrofit

    var isLoading: MutableLiveData<Boolean> = MutableLiveData()
    val errorMessage:MutableLiveData<String> = MutableLiveData()
    val mItemList: MutableLiveData<List<DonationItem>> = MutableLiveData()

    private lateinit var subscription: Disposable

    init{
        getCampaigns()
    }

    override fun onCleared() {
        super.onCleared()
        if (::subscription.isInitialized) subscription.dispose()
    }

    fun getCampaigns(){
        isLoading.value = true
        val donationItemList: MutableList<DonationItem> = Hawk.get(DONATION_LIST, arrayListOf<DonationItem>())
        mItemList.value = donationItemList
        isLoading.value = false
    }
}