package com.tsl.momi.ui.itemList

import androidx.lifecycle.MutableLiveData
import com.orhanobut.hawk.Hawk
import com.tsl.momi.base.BaseViewModel
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.data.models.UserDao
import com.tsl.momi.data.models.campaign.CampaignVideosResult
import com.tsl.momi.network.BaseApi
import com.tsl.momi.network.PaginatedResponse
import com.tsl.momi.network.ServerError
import com.tsl.momi.utils.DONATION_LIST
import com.tsl.momi.utils.Utils
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.HttpException
import retrofit2.Retrofit
import timber.log.Timber
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