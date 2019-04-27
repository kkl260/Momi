package com.tsl.momi.data.models

import com.chad.library.adapter.base.entity.MultiItemEntity

class ChatItem: MultiItemEntity {
    private var itemType: Int = 0
    var content: String? = null

    constructor(itemType: Int, text: String) {
        this.itemType = itemType
        this.content = text
    }

    override fun getItemType(): Int {
        return itemType
    }

    companion object {
        const val SENDER = 1
        const val RECEIVER = 2
    }
}