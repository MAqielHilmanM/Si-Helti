package com.automosen.si_helti.screens.disease.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.screens.diagnosa.form.DiagnosaFormActivity
import kotlinx.android.synthetic.main.activity_disease_detail.*

class DiseaseDetailActivity : BaseActivity() {
    override fun setToolbar(): Toolbar? {
        toolbar.title = ""
        return toolbar
    }

    override fun initView(savedInstanceState: Bundle?) {
        initRecycler()
        initDummy()
    }

    override fun initListener() {
        btn_sheet_diagnose.setOnClickListener {
            DiagnosaFormActivity.startActivity(this)
        }
    }

    override fun setView(): Int {
        return R.layout.activity_disease_detail
    }

    var listData: MutableList<String> = mutableListOf()
    lateinit var recyclerView: RecyclerView

    private fun initRecycler() {
        recyclerView = rv_detail_causes_desc

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false);
            adapter = DiseaseDetailAdapter(listData)
        }
    }

    private fun initDummy() {
        listData.add("high fever")
        listData.add("headache")
        listData.add("nausea")
        recyclerView.adapter?.notifyDataSetChanged()
    }


    companion object {
        fun startActivity(context: Context) {
            context.startActivity(Intent(context, DiseaseDetailActivity::class.java))
        }
    }
}
