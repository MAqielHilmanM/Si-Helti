package com.automosen.si_helti.screens.disease


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.screens.diagnosa.form.DiagnosaFormActivity
import com.automosen.si_helti.screens.disease.detail.DiseaseDetailAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_disease_detail.view.*


class DiseaseSheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(
            R.layout.fragment_disease_detail, container,
            false
        )

        initRecycler(v)
        initDummy()

        v.btn_sheet_diagnose.setOnClickListener {
            DiagnosaFormActivity.startActivity(activity!!)
        }
        return v
    }

    var listData: MutableList<String> = mutableListOf()
    lateinit var recyclerView: RecyclerView

    private fun initRecycler(view: View) {
        recyclerView = view.rv_detail_causes_desc

        recyclerView.apply {
            layoutManager = LinearLayoutManager(view.context)
            adapter = DiseaseDetailAdapter(listData)
        }
    }

    private fun initDummy() {
        listData.add("high fever")
        listData.add("headache")
        listData.add("nausea")
        recyclerView.adapter?.notifyDataSetChanged()
    }


}
