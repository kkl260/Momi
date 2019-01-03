package com.tsl.momi.utils

import android.content.Context
import android.widget.Toast
import com.orhanobut.hawk.Hawk
import org.threeten.bp.LocalDate
import org.threeten.bp.format.DateTimeFormatter
import android.app.Activity
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ProgressBar
import com.tsl.momi.data.models.DonationItem
import java.io.File
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.IOException


object Utils {
    fun toast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun toastLong(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun toast(context: Context, message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun toastLong(context: Context, message: Int) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun getToken(): String{
        return "Token " + Hawk.get(TOKEN)
    }

    fun formatDateToString(d: String): String {
        return LocalDate.parse(d, DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            .format(DateTimeFormatter.ofPattern("MM/dd/yyyy"))
    }

    fun hideKeyboard(activity: Activity) {
        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        //Find the currently focused view, so we can grab the correct window token from it.
        var view = activity.currentFocus
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = View(activity)
        }
        imm!!.hideSoftInputFromWindow(view!!.windowToken, 0)
    }

    fun showProgressBar(activity: Activity, progressBar: ProgressBar){
        progressBar.visibility = View.VISIBLE
        activity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    fun hideProgressBar(activity: Activity, progressBar: ProgressBar){
        progressBar.visibility = View.GONE
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
    }

    fun addItemToList(donationItem: DonationItem){
        val donationItemList: MutableList<DonationItem> = Hawk.get(DONATION_LIST, arrayListOf<DonationItem>())
        donationItemList.add(donationItem)
        Hawk.put(DONATION_LIST, donationItemList)
    }

    fun getByte(path: String): ByteArray {
        var getBytes = byteArrayOf()
        try {
            val file = File(path)
            getBytes = ByteArray(file.length().toInt())
            val inputStream = FileInputStream(file)
            inputStream.read(getBytes)
            inputStream.close()
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return getBytes
    }
}