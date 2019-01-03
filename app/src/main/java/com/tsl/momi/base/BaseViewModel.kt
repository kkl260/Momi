package com.tsl.momi.base

import androidx.lifecycle.ViewModel
import com.tsl.momi.di.component.DaggerViewModelInjector
import com.tsl.momi.di.component.ViewModelInjector
import com.tsl.momi.di.module.NetworkModule
import com.tsl.momi.ui.itemList.ItemListViewModel

abstract class BaseViewModel : ViewModel(){
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is ItemListViewModel -> injector.inject(this)
        }
    }
}