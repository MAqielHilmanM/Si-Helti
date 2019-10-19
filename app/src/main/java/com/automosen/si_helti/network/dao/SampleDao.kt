package com.automosen.si_helti.network.dao

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class SampleDao {
    @SerializedName("member_cached_info") @Expose val member_cached_info: String? = null
    @SerializedName("id") @Expose val id: Int? = null
    @SerializedName("user_id") @Expose val user_id: Int? = null
    @SerializedName("user_reseller_id") @Expose val user_reseller_id: Int? = null
    @SerializedName("reseller_refid") @Expose val reseller_refid: String? = null
    @SerializedName("coupon") @Expose val coupon: String? = null
    @SerializedName("ktp") @Expose val ktp: String? = null
    @SerializedName("npwp") @Expose val npwp: String? = null
    @SerializedName("bank_id") @Expose val bank_id: String? = null
    @SerializedName("bank_branch") @Expose val bank_branch: String? = null
    @SerializedName("account_number") @Expose val account_number: String? = null
    @SerializedName("account_holder") @Expose val account_holder: String? = null
    @SerializedName("activated_start_on") @Expose val activated_start_on: String? = null
    @SerializedName("activated_end_on") @Expose
    val activated_end_on: String? = null
    @SerializedName("cached_info") @Expose val cached_info: String? = null
    @SerializedName("ktp_url") @Expose val ktp_url: String? = null
    @SerializedName("npwp_url") @Expose val npwp_url: String? = null
}