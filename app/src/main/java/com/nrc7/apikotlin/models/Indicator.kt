package com.nrc7.apikotlin.models

data class Indicator(
    val autor: String,
    val codigo: String,
    val nombre: String,
    val serie: List<Serie>,
    val unidad_medida: String,
    val version: String
)