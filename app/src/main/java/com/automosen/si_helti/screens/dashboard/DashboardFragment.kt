package com.automosen.si_helti.screens.dashboard

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseFragment
import com.automosen.si_helti.model.Dashboard
import com.automosen.si_helti.model.DashboardType
import com.automosen.si_helti.model.Disease
import com.automosen.si_helti.model.History
import com.automosen.si_helti.network.ApiClient
import com.automosen.si_helti.network.ApiInterface
import com.automosen.si_helti.network.ApiService
import com.automosen.si_helti.network.dao.MalariaDao
import com.automosen.si_helti.screens.diagnosa.form.DiagnosaFormActivity
import com.automosen.si_helti.screens.disease.DiseaseActivity
import com.automosen.si_helti.utils.PreferenceUtils
import com.automosen.si_helti.utils.Tools
import kotlinx.android.synthetic.main.fragment_dashboard.view.*
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class DashboardFragment : BaseFragment() {
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private var mMyLatLang: LatLng? = null
    val listDiseases : ArrayList<Disease> = arrayListOf()
    val listHistory : ArrayList<History> = arrayListOf()

    override fun setView(): Any {
        return com.automosen.si_helti.R.layout.fragment_dashboard
    }

    override fun initView(view: View, savedInstanceState: Bundle?) {
        initToolbar(view)
        initRecycler(view)
        initDummy()

        view.card_dashboard_diagnose.setOnClickListener {
            DiagnosaFormActivity.startActivity(activity!!)
        }

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(activity!!)
        loadCurrentLocation()
    }


    private var perms = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }


    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(DiseaseActivity.RC_LOCATION)
    fun loadCurrentLocation(){
        if (EasyPermissions.hasPermissions(activity!!, *perms)){
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location : Location? ->
                    if(location!=null)
                        mMyLatLang = LatLng(location.latitude,location.longitude)
                }
            loadData()
        }else
            EasyPermissions.requestPermissions(
                this, "Need location for detect any disease on your area",
                DiseaseActivity.RC_LOCATION, *perms
            )
    }

    fun initToolbar(view : View){
        view.toolbar.title = "Si Helti"
        (activity as AppCompatActivity).setSupportActionBar(view.toolbar)
    }

    var listData: MutableList<Dashboard> = mutableListOf()
    lateinit var recyclerView: RecyclerView

    private fun initRecycler(view : View) {
        recyclerView = view.rv_dashboard

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false);
            adapter = DashboardAdapter(listData)
        }
    }

    private fun initDummy() {

//        listDiseases.add(Disease(""))
//        listDiseases.add(Disease(""))
//        listDiseases.add(Disease(""))
//
//        listHistory.add(History(""))
//        listHistory.add(History(""))
//        listHistory.add(History(""))

        val sp = PreferenceUtils(activity!!)
        val lastData = sp.get(String::class,"lastResult","") as String
        if(lastData.isNotEmpty()){
            listHistory.add(History(""))
        }

        listData.add(Dashboard(DashboardType.Disease,"Disease information", listDiseases))
        listData.add(Dashboard(DashboardType.History,"Your Diagnosis History ", listHistory))
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun onResume() {
        super.onResume()
        if(mMyLatLang != null) loadData()

        val sp = PreferenceUtils(activity!!)
        val lastData = sp.get(String::class,"lastResult","") as String
        if(lastData.isNotEmpty()){
            listHistory.clear()
            listHistory.add(History(""))
            recyclerView.adapter?.notifyDataSetChanged()
        }

    }

    fun loadData(){
        val pb = Tools.showProgressDialog(activity!!)
        val mApiInterface = ApiClient.instance().getClient(ApiService.base_url)?.create(ApiInterface::class.java)
        val callMalaria = mApiInterface?.getMalariaInformation()
        callMalaria?.enqueue(object : Callback<List<MalariaDao>>{
            override fun onFailure(call: Call<List<MalariaDao>>, t: Throwable) {
                Log.e("Error",t.message)
                pb.dismiss()
            }

            override fun onResponse(call: Call<List<MalariaDao>>, response: Response<List<MalariaDao>>) {
                listDiseases.clear()
                response.body()?.forEach {
                    if(insideRadius(LatLng(it.latitude!!.toDouble(),it.longitude!!.toDouble()))){
                        listDiseases.add(Disease(""))
                    }
                }
                Log.d("Disease","list disease = ${listDiseases.size}")
                recyclerView.adapter?.notifyDataSetChanged()
                pb.dismiss()
            }

        })
    }

    fun insideRadius(latlang : LatLng):Boolean{
        val loc1 = Location("")
        loc1.latitude = latlang.latitude
        loc1.longitude = latlang.longitude

        Log.e("Radius","DataLocation = ${loc1.latitude},${loc1.longitude}")

        val loc2 = Location("")
        loc2.latitude = mMyLatLang!!.latitude
        loc2.longitude = mMyLatLang!!.longitude

        Log.e("Radius","MyLocation = ${loc2.latitude},${loc2.longitude}")

        val distance = loc1.distanceTo(loc2)
        Log.e("Radius","jarak = $distance")
        return distance <= 500

    }

    companion object {
        fun newInstance() = DashboardFragment()
    }
}