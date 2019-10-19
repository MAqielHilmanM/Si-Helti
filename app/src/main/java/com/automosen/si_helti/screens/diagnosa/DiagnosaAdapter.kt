package com.automosen.si_helti.screens.diagnosa

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.automosen.si_helti.R
import com.automosen.si_helti.model.Diagnosa
import com.automosen.si_helti.model.Hospital
import kotlinx.android.synthetic.main.activity_diagnosa.view.*
import kotlinx.android.synthetic.main.item_diagnosa_consultation.view.*
import kotlinx.android.synthetic.main.item_diagnosa_desc.view.*
import kotlinx.android.synthetic.main.item_diagnosa_disease.view.*
import kotlinx.android.synthetic.main.item_diagnosa_things.view.*


class DiagnosaAdapter(private val children: List<Diagnosa>) : RecyclerView.Adapter<DiagnosaAdapter.ViewHolder>() {

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_DISEASE = 1
        const val TYPE_SOLUTION = 2
        const val TYPE_CONSULTATION = 3
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class ViewHolderHeader(itemView: View) : ViewHolder(itemView) {
        //TODO : Initialize Here
        fun initData(child : Diagnosa){
            itemView.tv_diagnose_desc.text = child.header
        }
        fun initListener(context: Context, child:String){

        }
    }

    inner class ViewHolderDisease(itemView: View) : ViewHolder(itemView) {
        //TODO : Initialize Here
        @SuppressLint("SetTextI18n")
        fun initData(child : Diagnosa){
            itemView.tv_disease_title.text = child.diseaseTitle
            itemView.tv_percentage.text = "${child.diseasePercentage?:0}%"
            itemView.percentage_disease.progress = child.diseasePercentage?: 0
        }
        fun initListener(context: Context, child:String){

        }
    }

    inner class ViewHolderSolution(itemView: View) : ViewHolder(itemView) {
        //TODO : Initialize Here
        fun initData(child : List<String>){
            itemView.rv_things.apply {
                setRecycledViewPool(this.recycledViewPool)
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = DiagnosaThingsAdapter(child)
            }
        }
        fun initListener(context: Context, child:String){

        }
    }

    inner class ViewHolderAppoinment(itemView: View) : ViewHolder(itemView) {
        //TODO : Initialize Here
        fun initData(child : List<Hospital>){
            itemView.rv_hospital.apply {
                setRecycledViewPool(this.recycledViewPool)
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = DiagnosaConsultationAdapter(child)
            }
        }
        fun initListener(context: Context, child:String){

        }
    }

    lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        context = parent.context

        return when (viewType) {
            TYPE_HEADER -> ViewHolderHeader(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_diagnosa_desc, parent, false)
            )
            TYPE_DISEASE -> ViewHolderDisease(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_diagnosa_disease, parent, false)
            )
            TYPE_SOLUTION -> ViewHolderSolution(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_diagnosa_things, parent, false)
            )
            else -> ViewHolderAppoinment(
                LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_diagnosa_consultation, parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun getItemViewType(position: Int): Int {
        return children[position].viewType
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]

        when(holder) {
            is ViewHolderHeader -> {
                holder.initData(child)
            }
            is ViewHolderDisease -> {
                holder.initData(child)
            }
            is ViewHolderSolution -> {
                holder.initData(child.listThings?: arrayListOf())
            }
            is ViewHolderAppoinment -> {
                holder.initData(child.listHospital?: arrayListOf())
            }
        }
    }

}
