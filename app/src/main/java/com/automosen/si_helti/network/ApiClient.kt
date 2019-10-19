package com.automosen.si_helti.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS
import okhttp3.logging.HttpLoggingInterceptor

class ApiClient {
    private var retrofit: Retrofit? = null

    fun getClient(baseUrl : String): Retrofit? {
        if (retrofit == null) {
            val builder = OkHttpClient().newBuilder()
            builder.readTimeout(10, TimeUnit.SECONDS)
            builder.connectTimeout(5, TimeUnit.SECONDS)

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)

            builder.addInterceptor { chain ->
                val request = chain.request().newBuilder()
                        .addHeader("Accept", "application/json")
                        .build()
                chain.proceed(request)
            }

            val client = builder.build()

            retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client)
                    .baseUrl(baseUrl)
                    .build()
        }
        return retrofit
    }

    companion object {
        fun instance() = ApiClient()
    }
}