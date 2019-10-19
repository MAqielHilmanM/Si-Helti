package com.automosen.si_helti.screens.diagnosa

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.base.BaseActivity
import com.automosen.si_helti.model.Diagnosa
import com.automosen.si_helti.model.Hospital
import kotlinx.android.synthetic.main.activity_diagnosa.*

class DiagnosaActivity : BaseActivity() {
    override fun setView(): Int {
        return R.layout.activity_diagnosa
    }

    override fun setToolbar(): Toolbar? {
        toolbar.title = ""
        return toolbar
    }

    override fun initView(savedInstanceState: Bundle?) {
        initRecycler()
        initDummy()
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

        private fun initDummy(){
                listData.add(Diagnosa(DiagnosaAdapter.TYPE_HEADER,"Lorem ipsum dolor sit amet, consectetur adipiscing elit. Tincidunt adipiscing commodo iaculis consectetur vitae. Senectus fermentum facilisis velit urna. Ornare phasellus pulvinar et natoque in."))
                listData.add(Diagnosa(DiagnosaAdapter.TYPE_DISEASE,null,"Malaria",90))
                listData.add(Diagnosa(DiagnosaAdapter.TYPE_DISEASE,null,"Headache",90))
                listData.add(Diagnosa(DiagnosaAdapter.TYPE_DISEASE,null,"Demam",90))
                listData.add(Diagnosa(DiagnosaAdapter.TYPE_SOLUTION,listThings = listOf("Full Rest","skip class", "skip work")))
                listData.add(Diagnosa(DiagnosaAdapter.TYPE_CONSULTATION,listHospital = listOf(
                    Hospital(""),
                    Hospital(""),
                    Hospital(""),
                    Hospital(""),
                    Hospital("")
                )))
                recyclerView.adapter?.notifyDataSetChanged()
            }

    companion object {
        fun startActivity(context: Context){
            context.startActivity(Intent(context,DiagnosaActivity::class.java))
        }
    }
}
