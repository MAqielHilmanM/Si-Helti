package com.automosen.si_helti.model

data class Diagnosa (
    val viewType: Int,
    var header : String? = null,
    var diseaseTitle: String? = null,
    var diseasePercentage: Int? = null,
    var listThings: List<String>? = null,
    var listHospital: List<Hospital>? = null
)
