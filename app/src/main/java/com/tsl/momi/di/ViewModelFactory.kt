package com.tsl.momi.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tsl.momi.ui.itemList.ItemListViewModel

class ViewModelFactory(private val activity: FragmentActivity?): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ItemListViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ItemListViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")

    }
}