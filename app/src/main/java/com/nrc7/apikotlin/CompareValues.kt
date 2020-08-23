package com.nrc7.apikotlin

import com.nrc7.apikotlin.models.Serie

class CompareValues {

    fun getLowerValue(list: List<Serie>): Serie {
        return Serie(list.minBy { it.valor }!!.fecha, list.minBy { it.valor }!!.valor)
    }
}