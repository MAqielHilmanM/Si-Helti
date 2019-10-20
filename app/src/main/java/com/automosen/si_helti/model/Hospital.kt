package com.automosen.si_helti.model

import java.io.Serializable

data class Hospital (
    val id : String,
    val name : String,
    val latitude : Double,
    val longitude : Double,
    val address : String
) : Serializable