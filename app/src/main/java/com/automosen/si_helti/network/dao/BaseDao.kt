package com.automosen.si_helti.network.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseDao<T,K>{
    @SerializedName("status")
    @Expose
    var status : Int = 0

    @SerializedName("message")
    @Expose
    var message : String = ""

    @SerializedName("data")
    @Expose
    var data : T? = null

    @SerializedName("errors")
    @Expose
    var errors : K? = null
}