package com.tsl.momi.ui.chat

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.fragment_camera.*
import com.tsl.momi.R
import com.tsl.momi.data.models.ChatItem
import com.tsl.momi.data.models.DonationItem
import com.tsl.momi.utils.CURRENT_DONATION
import com.tsl.momi.utils.Utils
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_item_details.*
import timber.log.Timber
import java.io.File
import java.io.FileOutputStream
import java.util.*


class ChatFragment : Fragment() {

    lateinit var data: MutableList<ChatItem>
    lateinit var adapter: MultipleItemAdapter
    var firstTime: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        recyclerview.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        data = mutableListOf<ChatItem>()
        adapter = MultipleItemAdapter(data)
        recyclerview.adapter = adapter
        button_chatbox_send.setOnClickListener {
            val text = edittext_chatbox.text.toString()
            data.add(ChatItem(1, text))
            adapter.setNewData(data)
            edittext_chatbox.text.clear()
            if (firstTime) timer.start()
        }
    }

    var timer = object: CountDownTimer(2000, 1000) {
        override fun onTick(millisUntilFinished: Long) {
        }

        override fun onFinish() {
            firstTime = false
            data.add(ChatItem(2, "Yup, Come and get it!"))
            adapter.setNewData(data)
        }
    }
}
