package com.automosen.si_helti.network

import com.automosen.si_helti.network.dao.HospitalDao
import com.automosen.si_helti.network.dao.MalariaDao
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

/*  EXAMPLE

    @POST("${ApiService.base_url_account}/bs_android/login")
    fun doLogin(
            @Query("email") email: String,
            @Query("password") password: String,
            @Query("pushNotifToken") pushNotifToken: String = "",
            @Query("pushType") pushType: Int = 1
    ): Call<BaseDao<DoLoginDao, List<Boolean>>>

    @POST("${ApiService.base_url_account}/bs_android/register")
    fun doRegister(
            @Query("name") name: String,
            @Query("email") email: String,
            @Query("phone") phone: String,
            @Query("password") password: String,
            @Query("tos_confirm") tos_confrim: Boolean,

            @Query("email2") email2: String,
            @Query("phone2") phone2: String,
            @Query("gender") gender: Int,
            @Query("address") address: String,
            @Query("date_of_birth") date_of_birth: String,
            @Query("pushNotifToken") pushNotifToken: String = "",
            @Query("pushType") pushType: Int = 1
    ): Call<BaseDao<DoLoginDao, Any>>

    @GET("${ApiService.base_url_account}/notification/{NOTIFID}")
    fun getNotificationDetail(
            @Path("NOTIFID") notifId: String,
            @Query("setRead") setRead: Int = 1
    ): Call<BaseDao<NotificationDao.Notification, List<Boolean>>>

    @DELETE("${ApiService.base_url_account}/notification/{notifId}")
    fun doNotificationRemove(
            @Path("notifId") notifId: String
    ): Call<BaseDao<Boolean, List<Boolean>>>

    @PUT("${ApiService.base_url_account}/setting/profile")
    fun doProfileUpdate(
            @Query("name") name: String,
            @Query("gender") gender: Int,
            @Query("date_of_birth") date_of_birth: String
    ): Call<BaseDao<List<Boolean>, List<Boolean>>>

    @Multipart
    @PUT("${ApiService.base_url_account}/setting/profile")
    fun doProfileUpdate(
            @Part avatar: MultipartBody.Part
    ): Call<BaseDao<List<Boolean>, List<Boolean>>>
*/

    @GET("/sihelti/index.php/malaria")
    fun getMalariaInformation(): Call<List<MalariaDao>>

    @GET("/sihelti/index.php/RumahSakit")
    fun getHospitalInformation(): Call<List<HospitalDao>>
}