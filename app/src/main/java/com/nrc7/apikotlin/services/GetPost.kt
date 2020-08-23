package com.nrc7.apikotlin.services

import android.util.Log
import com.nrc7.apikotlin.models.Indicator
import com.nrc7.apikotlin.models.Serie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetPost {

    fun getDollarValues(callback: OnGetDollarValuesListener) {
        RetrofitClient.instance.getAllDollarValues("dolar")
            .enqueue(object : Callback<Indicator> {
                override fun onResponse(call: Call<Indicator>, response: Response<Indicator>) {
                    Log.d("TAG", "RESPONSE")
                    Log.d("TAG", response.body()?.serie?.size.toString())
                    val dollarValues = response.body()
                    if (dollarValues != null) {
                        callback.onGetDollarValues(dollarValues.serie)
                    }
                }

                override fun onFailure(call: Call<Indicator>, t: Throwable) {
                    Log.d("TAG", "FAILURE")
                    Log.d("TAG", t.message)
                    Log.d("TAG", t.printStackTrace().toString())
                }

            })
    }

    interface OnGetDollarValuesListener {
        fun onGetDollarValues(values: List<Serie>)
    }
}