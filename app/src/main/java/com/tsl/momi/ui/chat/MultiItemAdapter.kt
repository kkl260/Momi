package com.tsl.momi.ui.chat

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import com.tsl.momi.R
import com.tsl.momi.data.models.ChatItem
import timber.log.Timber

class MultipleItemAdapter(data: List<ChatItem>) : BaseMultiItemQuickAdapter<ChatItem, BaseViewHolder>(data) {

    init {
        addItemType(ChatItem.SENDER, R.layout.item_message_sent)
        addItemType(ChatItem.RECEIVER, R.layout.item_message_received)
    }

    override fun convert(helper: BaseViewHolder, item: ChatItem) {
        Timber.d("TEST2 = ")
        Timber.d("TEST3 = " + item.content)
        when (helper.itemViewType) {
            ChatItem.RECEIVER -> helper.setText(R.id.text_message_body_received, item.content)
            ChatItem.SENDER -> helper.setText(R.id.text_message_body_sent, item.content)
        }
    }

}