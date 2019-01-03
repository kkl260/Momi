package com.tsl.momi.di.component

import com.tsl.momi.di.module.NetworkModule
import com.tsl.momi.ui.itemList.ItemListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelInjector {

    fun inject(itemListViewModel: ItemListViewModel)

    @Component.Builder
    interface Builder {
        fun build(): ViewModelInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}