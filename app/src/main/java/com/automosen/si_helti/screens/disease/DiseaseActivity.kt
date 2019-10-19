package com.automosen.si_helti.screens.disease

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.location.Location
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.model.Disease
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.CircleOptions
import com.google.android.gms.maps.model.LatLng
import kotlinx.android.synthetic.main.fragment_disease_sheet.*
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions


class DiseaseActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private var perms = arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION)

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.automosen.si_helti.R.layout.activity_disease)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(com.automosen.si_helti.R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        initRecycler()
        initDummy()

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

    }

    var listData: MutableList<Disease> = mutableListOf()
    lateinit var recyclerView: RecyclerView

    private fun initRecycler() {
        recyclerView = rv_sheet

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false);
            adapter = DiseaseAdapter(listData)
        }
    }

    private fun initDummy() {
        listData.add(Disease(""))
        listData.add(Disease(""))
        listData.add(Disease(""))
        recyclerView.adapter?.notifyDataSetChanged()
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @SuppressLint("MissingPermission")
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        loadCurrentLocation()
    }

    @SuppressLint("MissingPermission")
    @AfterPermissionGranted(Companion.RC_LOCATION)
    fun loadCurrentLocation() {
        if (EasyPermissions.hasPermissions(this, *perms)) {
            fusedLocationClient.lastLocation
                .addOnSuccessListener { location: Location? ->
                    if (location != null) {
                        val latLng = LatLng(location.latitude, location.longitude)
                        val cameraUpdate = CameraUpdateFactory.newLatLngZoom(latLng, 15f)
                        mMap.animateCamera(cameraUpdate)

                        for (i in 0..4) {
                            val circle = mMap
                                .addCircle(CircleOptions().center(latLng))
                            circle.radius = 500.0 - (i * 100)
                            circle.strokeWidth = 0f
                            circle.fillColor = Color.parseColor("#3300ACC1")
                            circle.isVisible = true
                        }
                    }
                }
        } else
            EasyPermissions.requestPermissions(
                this, "Need location for detect any disease on your area",
                DiseaseActivity.RC_LOCATION, *perms
            )
    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, DiseaseActivity::class.java))
        }

        const val RC_LOCATION = 100
    }
}
