package com.automosen.si_helti.network.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class HospitalDao {
    @SerializedName("id_RS") @Expose var id_RS: String? = null
    @SerializedName("nama_rumah_sakit") @Expose var nama_rumah_sakit: String? = null
    @SerializedName("email_RS") @Expose var email_RS: String? = null
    @SerializedName("latitude") @Expose var latitude: String? = null
    @SerializedName("logitude") @Expose var logitude: String? = null
    @SerializedName("alamat") @Expose var alamat: String? = null
}