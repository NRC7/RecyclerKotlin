package com.nrc7.apikotlin.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.nrc7.apikotlin.CompareValues
import com.nrc7.apikotlin.R
import com.nrc7.apikotlin.adapters.DollarValuesAdapter
import com.nrc7.apikotlin.services.GetPost
import com.nrc7.apikotlin.models.Serie
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), GetPost.OnGetDollarValuesListener, DollarValuesAdapter.OnItemClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GetPost().getDollarValues(this)
    }

    override fun onGetDollarValues(values: List<Serie>) {
        recycler_view.adapter = DollarValuesAdapter(values, this)
        //recycler_view.layoutManager = LinearLayoutManager(this)

        val serie = CompareValues().getLowerValue(values)
        lowestDate.text = serie.valor.toString()
        lowestValue.text = serie.fecha

    }

    // respuesta del click
    override fun onItemClickListener(position: Int) {
        Toast.makeText(this, "" + position, Toast.LENGTH_SHORT).show()
    }
}
