package com.automosen.si_helti.screens.diagnosa

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.model.Diagnosa
import com.automosen.si_helti.model.Hospital
import com.automosen.si_helti.network.ApiClient
import com.automosen.si_helti.network.ApiInterface
import com.automosen.si_helti.network.ApiService
import com.automosen.si_helti.network.dao.HospitalDao
import com.automosen.si_helti.utils.PreferenceUtils
import com.automosen.si_helti.utils.Tools
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_diagnosa.*
import retrofit2.Call
import retrofit2.Response
import kotlin.random.Random

class DiagnosaActivity : BaseActivity() {
    lateinit var sp : PreferenceUtils
    val listHospital : ArrayList<Hospital> = arrayListOf()

    override fun setView(): Int {
        return R.layout.activity_diagnosa
    }

    override fun setToolbar(): Toolbar? {
        toolbar.title = ""
        return toolbar
    }

    override fun initView(savedInstanceState: Bundle?) {
        sp = PreferenceUtils(this)
        initRecycler()

//        val fromActivity = intent.getStringExtra(EXTRA_ACTIVITY)?: ""
//        if(fromActivity.isEmpty()){
//            initDummy()
//        }else{
//            val data = sp.get(String::class,"lastResult","") as String
//            val type = object : TypeToken<List<Diagnosa>>() {}.type
//            listData = Gson().fromJson(data, type)
//            recyclerView.adapter?.notifyDataSetChanged()
//        }
        initDummy()
        loadHospital()
    }

    override fun initListener() {

    }

    var listData: MutableList<Diagnosa> = mutableListOf()
    lateinit var recyclerView: RecyclerView

    private fun initRecycler() {
        recyclerView = rv_diagnosa

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false);
            adapter = DiagnosaAdapter(listData)
        }
    }

    private fun initDummy() {
        listData.add(Diagnosa(DiagnosaAdapter.TYPE_HEADER, "Here our diagnosa about what your fill : "))
        listData.add(Diagnosa(DiagnosaAdapter.TYPE_DISEASE, null, "Malaria", Random.nextInt(40, 80)))
        listData.add(Diagnosa(DiagnosaAdapter.TYPE_DISEASE, null, "Fever", Random.nextInt(40, 80)))
        listData.add(
            Diagnosa(
                DiagnosaAdapter.TYPE_SOLUTION,
                listThings = listOf("Rest", "Avoid the heat", "Stay hydrated")
            )
        )
        listData.add(
            Diagnosa(
                DiagnosaAdapter.TYPE_CONSULTATION, listHospital = listHospital
            )
        )

        sp.set("lastResult",Gson().toJson(listData))

        recyclerView.adapter?.notifyDataSetChanged()
    }

    fun loadHospital(){
        val pb = Tools.showProgressDialog(this)
        val mApiInterface = ApiClient.instance().getClient(ApiService.base_url)?.create(ApiInterface::class.java)
        val callHospital = mApiInterface?.getHospitalInformation()
        callHospital?.enqueue(object : retrofit2.Callback<List<HospitalDao>>{
            override fun onFailure(call: Call<List<HospitalDao>>, t: Throwable) {
                Log.e("Error",t.message)
                pb.dismiss()
            }

            override fun onResponse(call: Call<List<HospitalDao>>, response: Response<List<HospitalDao>>) {
                listHospital.clear()
                response.body()?.forEach {
                    listHospital.add(Hospital(
                        it.id_RS!!,
                        it.nama_rumah_sakit!!,
                        it.latitude!!.toDouble(),
                        it.logitude!!.toDouble(),
                        it.alamat!!))
                }
                recyclerView.adapter?.notifyDataSetChanged()
                pb.dismiss()
            }

        })
    }

    companion object {
        const val EXTRA_ACTIVITY = "extra_act"

        fun startActivity(context: Context, activityName: String = "") {
            val intent = Intent(context, DiagnosaActivity::class.java)
            intent.putExtra(EXTRA_ACTIVITY,activityName)
            context.startActivity(intent)
        }
    }
}
